package mapper;

import com.cxy.mapper.DeptMapper;
import com.cxy.mapper.StaffMapper;
import com.cxy.pojo.Dept;
import com.cxy.pojo.DeptTemp;
import com.cxy.pojo.Staff;
import com.cxy.pojo.StaffTemp;
import com.cxy.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 蔡心勇
 * @create 2022/3/10 - 17:38
 */
public class TestStaffMapper {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
        int res = staffMapper.addStaff(new Staff(null, "aaa", "aa@qq.com", 1));
        System.out.println(res);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
        Staff staff = staffMapper.queryStaffById(1);
        System.out.println(staff);
    }

    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
        StaffTemp staffTemp = staffMapper.queryStaffAndDept(1);
        System.out.println(staffTemp);
    }

    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.queryDeptById(1);
        System.out.println(dept);
    }

    @Test
    public void test5(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
        StaffTemp staffTemp = staffMapper.queryStaffTwo(1);
        System.out.println(staffTemp);
    }

    @Test
    public void test6(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        DeptTemp deptTemp = deptMapper.queryDeptAndStaff(1);
        System.out.println(deptTemp);
    }

    @Test
    public void test7(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StaffMapper staffMapper = sqlSession.getMapper(StaffMapper.class);
        List<Staff> staffList = staffMapper.queryStaffByDeptId(1);
        staffList.forEach(System.out::println);
    }

    @Test
    public void test8(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        DeptTemp deptTemp = deptMapper.queryDeptAndStaffTwo(1);
        System.out.println(deptTemp);
    }
}
