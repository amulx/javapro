import DB.DBUtil;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;


import java.sql.SQLException;

import static DB.gen.Tables.SHOP_ADMIN;
import static org.jooq.impl.DSL.select;

public class MyIndex {
    public static void main(String[] args) throws SQLException {

        DSLContext dslcontext = DSL.using(DBUtil.getConnection(), SQLDialect.MYSQL);

        int pageSize=10;
        int page = 2;
        // 查询语句优化
        // select * from shop_admin where adminid <= (select adminid from shop_admin order by id desc limit 1 offset 20) order by id desc limit 10
        Result<Record> records = dslcontext.select()
                .from(SHOP_ADMIN)
                .where(SHOP_ADMIN.ADMINID.le(select(SHOP_ADMIN.ADMINID).from(SHOP_ADMIN)
                        .orderBy(SHOP_ADMIN.ADMINID.desc()).limit(1).offset(page*pageSize)))
                .orderBy(SHOP_ADMIN.ADMINID.desc()).fetch();

         for (Record r : records){
//             r.valuesRow();
             System.out.println(r.get("adminuser"));
         }

    }
}
