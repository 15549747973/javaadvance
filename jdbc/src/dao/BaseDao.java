import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao {

    /**
     * 增删改
     * @param connection
     * @param sql
     * @param args
     * @return
     * @throws Exception
     */
    public int update(Connection connection,String sql,Object...args) throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);

            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement);
        }
        return 0;
    }

    /**
     * 查询一条记录
     * @param connection
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     * @throws Exception
     */
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

    /**
     * 查询多条记录
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> List<T> queryForList(Connection connection,Class<T> clazz, String sql, Object...args) throws Exception {
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
        JDBCUtils.close(null,preparedStatement,resultSet);
        return list;
    }

    /**
     * 查询一个数值
     */
    public Object getValue(Connection connection,String sql,Object...args) throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,preparedStatement);
        }
        return null;
    }
}
