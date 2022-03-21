import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import javax.xml.transform.Source;
import java.sql.Connection;
import java.util.List;

public class Test1 {
    @Test
    public void test1() throws Exception {
        Connection connection=JDBCUtils.getConnection();
        UserTableDao userTableDao=new UserTableDaoIpml();
        Object specialValue = userTableDao.getSpecialValue(connection);
        System.out.println(specialValue);
        JDBCUtils.close(connection,null);
    }

    @Test
    public void test2() throws Exception {
        Connection connection=JDBCUtils.getConnection();
        UserTable userTable=new UserTable("1","1123",110);
        UserTableDaoIpml userTableDaoIpml=new UserTableDaoIpml();
        int insert = userTableDaoIpml.updateImpl(connection, userTable);
        System.out.println(insert);
        JDBCUtils.close(connection,null);
    }

    @Test
    public void test3() throws Exception {
        Connection connection=JDBCUtils.getConnection();
        UserTableDaoIpml userTableDaoIpml=new UserTableDaoIpml();
        userTableDaoIpml.deleteByUser(connection,"");
        JDBCUtils.close(connection,null);
    }

    @Test
    public void test4() throws Exception {
        Connection connection=JDBCUtils.getConnection();
        UserTableDaoIpml userTableDaoIpml=new UserTableDaoIpml();
        UserTable userTable = userTableDaoIpml.queryByUser(connection, "1");
        System.out.println(userTable);
        JDBCUtils.close(connection,null);
    }

    @Test
    public void test5() throws Exception {
        Connection connection=JDBCUtils.getConnection1();
        UserTableDao userTableDao=new UserTableDaoIpml();
        List<UserTable> userTables = userTableDao.queryAll(connection);
        for (int i = 0; i < userTables.size(); i++) {
            System.out.println(userTables.get(i));
        }
        JDBCUtils.close(connection,null);
    }

    @Test
    public void test6() throws Exception {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection1();
            QueryRunner queryRunner = new QueryRunner();
            String sql = "insert into user_table values(?,?,?)";
            int cxy = queryRunner.update(connection, sql, "cxy", "123", 123);
            System.out.println(cxy);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, null);
        }
    }

    @Test
    public void test7() throws Exception {
        Connection connection=null;
        try {
            QueryRunner queryRunner=new QueryRunner();
            connection=JDBCUtils.getConnection1();
            String sql="select * from user_table where user = ?";
            BeanHandler<UserTable> beanHandler=new BeanHandler<>(UserTable.class);
            UserTable aa = queryRunner.query(connection, sql, beanHandler, "BB");
            System.out.println(aa);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,null);
        }
    }

    @Test
    public void test8() throws Exception {
        Connection connection=null;
        try {
            QueryRunner queryRunner=new QueryRunner();
            connection=JDBCUtils.getConnection1();
            String sql="select * from user_table where balance < ?";
            BeanListHandler<UserTable> beanListHandler=new BeanListHandler<>(UserTable.class);
            List<UserTable> userTableList = queryRunner.query(connection, sql, beanListHandler, 200);
            userTableList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,null);
        }
    }

    @Test
    public void test9() throws Exception {
        Connection connection=null;
        try {
            QueryRunner queryRunner=new QueryRunner();
            connection=JDBCUtils.getConnection1();
            String sql="select count(*) from user_table";
            ScalarHandler scalarHandler=new ScalarHandler();
            long count= (long) queryRunner.query(connection, sql,scalarHandler);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection,null);
        }
    }
}
