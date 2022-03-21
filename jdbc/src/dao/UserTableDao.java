import java.sql.Connection;
import java.util.List;

public interface UserTableDao {
    /**
     * 插入一条usertable数据
     * @param connection
     * @param userTable
     * @throws Exception
     */
    int insert(Connection connection,UserTable userTable) throws Exception;

    int deleteByUser(Connection connection,String user) throws Exception;

    int updateImpl(Connection connection,UserTable userTable) throws Exception;

    UserTable queryByUser(Connection connection,String user) throws Exception;

    List<UserTable> queryAll(Connection connection) throws Exception;

    Object getSpecialValue(Connection connection) throws Exception;
}
