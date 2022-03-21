import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    public static Connection getConnection() throws Exception{
        //1.加载配置文件
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties=new Properties();
        properties.load(resourceAsStream);

        //2.读取配置数据
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String driver=properties.getProperty("driver");
        String url=properties.getProperty("url");

        //3.加载驱动
        Class.forName(driver);

        //4.根据配置信息获取连接
        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public static void close(Connection connection, Statement statement) throws Exception {
        if(connection!=null)connection.close();
        if(statement!=null)statement.close();
    }
    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws Exception {
        if(connection!=null)connection.close();
        if(statement!=null)statement.close();
        if(resultSet!=null)resultSet.close();
    }


    static DataSource dataSource =null;
    static {
        try {
            Properties properties=new Properties();
            InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection1() throws Exception {
        Connection connection = dataSource.getConnection();
        return connection;
    }
}
