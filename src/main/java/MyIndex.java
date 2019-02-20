import DB.DBUtil;
import DB.gen.tables.UsersCoin;
import DB.gen.tables.records.UsersCoinRecord;
import org.jooq.*;
import org.jooq.impl.DSL;


import java.sql.SQLException;

import static DB.gen.Tables.USERS_COIN;

public class MyIndex {
    public static void main(String[] args) throws SQLException {
        TransCoin("wulong", "xxx", 5);
    }

    static void TransCoin(final String from, final String to, int coin) throws SQLException {
        DSLContext dslcontext = DSL.using(DBUtil.getConnection(), SQLDialect.MYSQL);

        dslcontext.transaction(new TransactionalRunnable() {
            @Override
            public void run(Configuration configuration) throws Throwable {
                UsersCoinRecord usersCoinRecord = DSL.using(configuration).select()
                        .from(USERS_COIN)
                        .where(USERS_COIN.USER_NAME.eq(from))
                        .fetchOne()
                        .into(UsersCoinRecord.class);
                System.out.println(usersCoinRecord.getCoin());
                if (usersCoinRecord.getCoin()==null || usersCoinRecord.getCoin()<5){
                    throw new Exception("钱不够了");
                }

                int fromResult = DSL.using(configuration).update(USERS_COIN)
                        .set(USERS_COIN.COIN,usersCoinRecord.getCoin()-5)
                        .where(USERS_COIN.USER_NAME.eq(from))
                        .execute();

                int toResult = DSL.using(configuration).update(USERS_COIN)
                        .set(USERS_COIN.COIN,USERS_COIN.COIN.add(5))
                        .where(USERS_COIN.USER_NAME.eq(to))
                        .execute();
                if (fromResult !=1 || toResult !=1){
                    throw new RuntimeException("转账失败");
                }
                System.out.println("转账完成");
            }
        });
    }
}
