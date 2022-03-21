import java.sql.Connection;
import java.util.List;

public class UserTableDaoIpml extends BaseDao implements UserTableDao{
    @Override
    public int insert(Connection connection, UserTable userTable) throws Exception {
        String sql="insert into user_table values (?,?,?)";
        return update(connection,sql,userTable.getUser(),userTable.getPassword(),userTable.getBalance());
    }

    @Override
    public int deleteByUser(Connection connection, String user) throws Exception {
        String sql="delete from user_table where user= ?";
        return update(connection,sql,user);
    }

    @Override
    public int updateImpl(Connection connection, UserTable userTable) throws Exception {
        String sql="update user_table set user = ?,password = ?,balance = ? where user = ?";
        return update(connection,sql,userTable.getUser(),userTable.getPassword(),userTable.getBalance(), userTable.getUser());
    }

    @Override
    public UserTable queryByUser(Connection connection, String user) throws Exception {
        String sql="select * from user_table where user = ? ";
        return query(connection,UserTable.class,sql,user);
    }

    @Override
    public List<UserTable> queryAll(Connection connection) throws Exception {
        String sql="select * from user_table";
        return queryForList(connection,UserTable.class,sql);
    }

    @Override
    public Object getSpecialValue(Connection connection) throws Exception {
        String sql="select count(*) from user_table";
        return getValue(connection,sql);
    }
}
