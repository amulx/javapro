import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyIndex {
    public static void main(String[] args) throws SQLException {
        PoolProperties p = new PoolProperties();
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(p);
        p.setUrl("jdbc:mysql://127.0.0.1/imooc_shop?characterEncoding=UTF-8");
        p.setUsername("root");
        p.setPassword("root");
        p.setDriverClassName("com.mysql.cj.jdbc.Driver");
        p.setMinIdle(5);//始终保留的连接的最小连接数 ，默认10
        p.setInitialSize(5);//启动时的初始连接数 默认10
        p.setMaxIdle(10);//设置池内最大空闲连接数
        p.setTestOnBorrow(true);//取出连接时是否对其进行验证
        p.setValidationQuery("select 1");//如果上面的设置为true，则这要设置
        p.setMaxActive(20);//最大活跃连接数

        Connection connection=datasource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from shop_admin");
        while (resultSet.next()){
            System.out.println(resultSet.getString("adminuser"));
        }

    }
}
