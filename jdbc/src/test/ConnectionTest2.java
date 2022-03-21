import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConnectionTest2 {
    public void update(String sql,Object...args) throws Exception {
        //1.利用JdbcUtils获取连接
        Connection connection = JDBCUtils.getConnection();
        //2.预编译sql语句
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.填充占位符
        for(int i=0;i<args.length;i++){
            preparedStatement.setObject(i+1,args[i]);
        }
        //4.执行
        preparedStatement.execute();
        //5.关闭连接
        JDBCUtils.close(connection,preparedStatement);
    }
    @Test
    public void test1() throws Exception {
        //29857
        //使用addBatch:8224
        //1825

        long start=System.currentTimeMillis();
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);
        String sql="insert into user_table values (?,null,null)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for(int i=0;i<2000000;i++){
            preparedStatement.setObject(1,i);
            //使用addBatch()攒sql
            preparedStatement.addBatch();
            if(i%500==0){
                preparedStatement.execute();
                preparedStatement.clearBatch();
            }

        }
        connection.commit();
        JDBCUtils.close(connection,preparedStatement);
        System.out.println(System.currentTimeMillis()-start);
    }
}
