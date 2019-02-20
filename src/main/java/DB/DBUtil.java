package DB;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    static PoolProperties poolProperties = new PoolProperties(){
        {
            setUrl("jdbc:mysql://127.0.0.1/imooc_shop?characterEncoding=UTF-8");
            setUsername("root");
            setPassword("root");
            setDriverClassName("com.mysql.cj.jdbc.Driver");
            setMinIdle(5);//始终保留的连接的最小连接数 ，默认10
            setInitialSize(5);//启动时的初始连接数 默认10
            setMaxIdle(10);//设置池内最大空闲连接数
            setTestOnBorrow(true);//取出连接时是否对其进行验证
            setValidationQuery("select 1");//如果上面的设置为true，则这要设置
            setMaxActive(20);//最大活跃连接数
        }
    };
    public static Connection getConnection() throws SQLException {
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(poolProperties);
        return datasource.getConnection();
    }
}
