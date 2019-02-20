import DB.DBUtil;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;


import java.sql.SQLException;

import static DB.gen.Tables.SHOP_ADMIN;
import static org.jooq.impl.DSL.field;

public class MyIndex {
    public static void main(String[] args) throws SQLException {
        // org.jooq.codegen.GenerationTool.main(new String[]{"/home/amu/IdeaProjects/amu.xml"});

        DSLContext dslcontext = DSL.using(DBUtil.getConnection(), SQLDialect.MYSQL);
        // 方法一 直接执行sql
        /*
        Result<Record> records = dslcontext.fetch("select * from shop_admin");
        for (Record r : records) {
            System.out.println(r.get("adminuser"));
        }
        */
        // 方法二：
        /*
         Result<Record> records = dslcontext.select()
                .from("shop_admin")
                .orderBy(field("adminid")).fetch();

        */
        // 方法三：
        Result<Record> records = dslcontext.select()
                .from(SHOP_ADMIN)
                .orderBy(SHOP_ADMIN.ADMINID).fetch();

         for (Record r : records){
             System.out.println(r.get("adminuser"));
         }

    }
}
