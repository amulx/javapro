import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyIndex {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//指定连接类型
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/imooc_shop?characterEncoding=UTF-8", "root", "root");//获取连接
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from shop_admin");
            while (resultSet.next()){
                System.out.println(resultSet.getString("adminuser"));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
