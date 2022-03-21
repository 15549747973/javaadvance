import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ConnectionTest1 {
    @Test
    public void test1() throws SQLException {
        /**
         * 使用driver驱动获得connection连接
         */

        Driver driver=new Driver();
        String url="jdbc:mysql://localhost:3307/jdbc_learn";
        Properties properties=new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");

        Connection connection=driver.connect(url,properties);

        System.out.println(connection);
    }

    @Test
    public void test2() throws Exception {
        /**
         * 使用反射初始化driver
         */
        Class class1=Class.forName("com.mysql.jdbc.Driver");
        Driver driver= (Driver) class1.newInstance();

        String url="jdbc:mysql://localhost:3307/jdbc_learn";
        Properties properties=new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123456");
        Connection connection=driver.connect(url,properties);
        System.out.println(connection);
    }

    @Test
    public void test3() throws Exception {
        Class class1=Class.forName("com.mysql.jdbc.Driver");
        Driver driver= (Driver) class1.newInstance();

        DriverManager.registerDriver(driver);

        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/jdbc_learn","root","123456");
        System.out.println(connection);
    }

//    @Test
//    public void test4() throws Exception {
//        //1.加载配置文件并读取相关信息
//        InputStream resourceAsStream = ConnectionTest1.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        Properties properties=new Properties();
//        properties.load(resourceAsStream);
//        String driver=properties.getProperty("driver");
//        String url=properties.getProperty("url");
//        String user=properties.getProperty("user");
//        String password=properties.getProperty("password");
//
//        //2.加载驱动
//        Class.forName(driver);
//
//        //获取连接
//        Connection connection=DriverManager.getConnection(url,user,password);
//
//
//        String sql="insert into user_table values (?,?,?)";
//        PreparedStatement ps=connection.prepareStatement(sql);
//        ps.setString(1,"qq");
//        ps.setString(2,"qq");
//        ps.setString(3, String.valueOf(99));
//
//        ps.execute();
//    }

    @Test
    public void test5()throws Exception{
        //1.从jdbc.properties中获取参数
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties=new Properties();
        properties.load(resourceAsStream);

        String driver=properties.getProperty("driver");
        String url=properties.getProperty("url");
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");

        //2.加载驱动
        Class.forName(driver);

        //3.获取连接
        Connection connection=DriverManager.getConnection(url,user,password);

        //4.编写sql语句
        String sql="insert into user_table values (?,? ,?) ";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,"mike");
        preparedStatement.setString(2,"123");
        preparedStatement.setString(3, null);

        //5.执行语句
        preparedStatement.execute();

        //6.关闭
        preparedStatement.close();
        connection.close();

    }

    /**
     * 改进：使用JDBCUtils获取连接和断开连接
     * @throws Exception
     */
    @Test
    public void test6() throws Exception {
        //1、获取数据库连接
        Connection connection= JDBCUtils.getConnection();
        //2、预编译sql语句
        String sql="update user_table set password = ? where user=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3、填充占位符
        preparedStatement.setObject(1,"123456");
        preparedStatement.setObject(2,"AA");
        //4、执行
        preparedStatement.execute();
        //5、关闭
        JDBCUtils.close(connection,preparedStatement);
    }

//    /**
//     * 改进：编写update方法，执行 增删改 操作时只需要向update函数中传入sql语句和对应参数即可
//     * @param sql
//     * @param args
//     * @throws Exception
//     */
//    public void update(String sql,Object...args) throws Exception {
//        //1、获取连接
//        Connection connection = JDBCUtils.getConnection();
//        //2.预编译sql语句
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        //3.填充占位符
//        for(int i=0;i<args.length;i++){
//            preparedStatement.setObject(i+1,args[i]);
//        }
//        //4、执行
//        preparedStatement.execute();
//        //5.断开连接
//        JDBCUtils.close(connection,preparedStatement);
//    }
    @Test
    public void test7() throws Exception {
//        String sql="insert into user_table values (?,?,? )";
//        update(sql,"11","11",1);
        String sql="delete from user_table where user=?";
        update(sql,"qq");
    }


    public Customer queryForCustomer(String sql,Object...args) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for(int i=0;i<args.length;i++){
            preparedStatement.setObject(i+1,args[i]);
        }

        ResultSet resultSet=preparedStatement.executeQuery();
        Customer customer=null;
        if(resultSet.next()){//查询到结果，使用查询结果的元数据获取列数，并使用反射对对象进行赋值
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            customer=new Customer();
            for(int i=0;i<resultSetMetaData.getColumnCount();i++){
                //获取列的数据
                Object columnObject=resultSet.getObject(i+1);
                //获取列的名称
                String columnName=resultSetMetaData.getColumnName(i+1);
                //利用反射对对象的对应属性进行赋值
                Field field=Customer.class.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(customer,columnObject);
            }
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return customer;
    }
    @Test
    public void test8() throws Exception {
        String sql="select id,name,email,birth from customers where id = ?";
        Customer customer = queryForCustomer(sql, 1);
        System.out.println(customer);
    }

    public <T> T query(Class<T> clazz,String sql,Object...args) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for(int i=0;i<args.length;i++){
            preparedStatement.setObject(i+1,args[i]);
        }

        ResultSet resultSet=preparedStatement.executeQuery();
        T t=null;
        if(resultSet.next()){//查询到结果，使用查询结果的元数据获取列数，并使用反射对对象进行赋值
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            t=clazz.newInstance();
            for(int i=0;i<resultSetMetaData.getColumnCount();i++){
                //获取列的数据
                Object columnObject=resultSet.getObject(i+1);
                //获取列的名称
                String columnName=resultSetMetaData.getColumnName(i+1);
                //利用反射对对象的对应属性进行赋值
                Field field=clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t,columnObject);
            }
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return t;
    }
    @Test
    public void test9() throws Exception {
//        String sql="select id,name,email,birth from customers where id = ?";
//        Customer customer = query(Customer.class,sql, 1);
//        System.out.println(customer);
        String sql="select id,name from user where id = ?";
        User user = query(User.class,sql, 1);
        System.out.println(user);
    }

    public <T> List<T> queryForList(Class<T> clazz, String sql, Object...args) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for(int i=0;i<args.length;i++){
            preparedStatement.setObject(i+1,args[i]);
        }

        ResultSet resultSet=preparedStatement.executeQuery();
        ArrayList<T> list = new ArrayList<>();
        while(resultSet.next()){//查询到结果，使用查询结果的元数据获取列数，并使用反射对对象进行赋值
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            T t=clazz.newInstance();
            for(int i=0;i<resultSetMetaData.getColumnCount();i++){
                //获取列的数据
                Object columnObject=resultSet.getObject(i+1);
                //获取列的名称
                String columnName=resultSetMetaData.getColumnName(i+1);
                //利用反射对对象的对应属性进行赋值
                Field field=clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t,columnObject);
            }
            list.add(t);
        }
        JDBCUtils.close(connection,preparedStatement,resultSet);
        return list;
    }
    @Test
    public void test10() throws Exception {
        String sql="select id,name from user where id < ?";
        List<User> users = queryForList(User.class, sql,"1 or 1 = 1");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }

    public int update(String sql,Object...args) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1、获取连接
            connection = JDBCUtils.getConnection();
            //2.预编译sql语句
            preparedStatement = connection.prepareStatement(sql);
            //3.填充占位符
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            //4、执行
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.断开连接
            JDBCUtils.close(connection,preparedStatement);
        }
        return 0;
    }


    /**
     * 事务的实现：阻止自动提交，可以回滚
     *
     *      1、防止DML、DDL执行后的自提交：setautocommit=false;
     *      2、阻止connection断开的自动提交:使用一个connection,用完再断开
     *
     * @param connection
     * @param sql
     * @param args
     * @return
     * @throws Exception
     */
    public int update(Connection connection,String sql,Object...args) throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            //1.预编译sql语句
            preparedStatement = connection.prepareStatement(sql);
            //2.填充占位符
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            //3、执行
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.断开连接
            JDBCUtils.close(null,preparedStatement);
        }
        return 0;
    }
    @Test
    public void test11() throws Exception {
        Connection connection= null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);//DML后不允许自动提交
            String sql="update user_table set balance=balance-100 where user=? ";
            update(connection,sql,"AA");

            String sql1="update user_table set balance=balance+100 where user=? ";
            update(connection,sql1,"BB");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
            JDBCUtils.close(connection,null);
        }
    }



    public <T> T query( Connection connection,Class<T> clazz,String sql,Object...args) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for(int i=0;i<args.length;i++){
            preparedStatement.setObject(i+1,args[i]);
        }

        ResultSet resultSet=preparedStatement.executeQuery();
        T t=null;
        if(resultSet.next()){//查询到结果，使用查询结果的元数据获取列数，并使用反射对对象进行赋值
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            t=clazz.newInstance();
            for(int i=0;i<resultSetMetaData.getColumnCount();i++){
                //获取列的数据
                Object columnObject=resultSet.getObject(i+1);
                //获取列的名称
                String columnName=resultSetMetaData.getColumnName(i+1);
                //利用反射对对象的对应属性进行赋值
                Field field=clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t,columnObject);
            }
        }
        JDBCUtils.close(null,preparedStatement,resultSet);
        return t;
    }

    @Test
    public void test12() throws Exception {
        Connection connection=JDBCUtils.getConnection();
        String sql="select * from user_table where user = ?";
        System.out.println(query(connection,UserTable.class,sql,"AA"));
        JDBCUtils.close(connection,null);
    }
}
