package DB;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements javax.sql.DataSource{
    public static LinkedList<Connection> mypool = new LinkedList<Connection>();
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//指定连接类型
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        int initSize = 5;
        for (int i=1;i<=5;i++){
            Connection c = null;
            try {
                c = this.getConnection();
                mypool.push(c);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection genConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1/imooc_shop?characterEncoding=UTF-8", "root", "root");//获取连接
    }

    public Connection getConnection() throws SQLException {
        if (mypool.size()>0){
            return mypool.pop();
        } else {
            System.out.println("连接池为空");
            return null;
        }
    }

    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
