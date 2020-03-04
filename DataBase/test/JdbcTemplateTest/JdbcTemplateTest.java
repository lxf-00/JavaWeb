package JdbcTemplateTest;

import Druid.Demo.utils.JDBCUtils;
import jdbc.Demo.domain.Emp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JdbcTemplateTest {
    /**
     * Spring 对JDBC的简单封装，JdbcTemplate 测试方法
     */
    private static JdbcTemplate template;
    @Before
    public void init() {
        template = new JdbcTemplate(JDBCUtils.getDataSource());
    }

    /**
     * 测试update()
     */
    @Test
    public void testUpdate(){
        String sql = "insert into emp values (null, '赵六', 'tgb');";
        int update = template.update(sql);
        System.out.println(update);

    }

    /**
     * 测试queryForMap()
     */
    @Test
    public void testQueryForMap(){
        String sql = "select * from emp where id = 5;";
        Map<String, Object> map = template.queryForMap(sql);
        System.out.println(map);
    }

    /**
     * 测试queryForList()
     */
    @Test
    public void testQueryForList(){
        String sql = "select * from emp;";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    /**
     * 测试query():查询结果，将结果封装为JavaBean对象
     * query的参数：RowMapper
     * 				一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
     * 				new BeanPropertyRowMapper<类型>(类型.class)
     *
     *
     * 	使用演示1：
     */
    @Test
    public void testQuery1(){
        String sql = "select * from emp;";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Emp(resultSet.getInt("id"), resultSet.getString("name"));
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 测试query()
     * 使用演示2：
     */
    @Test
    public void testQuery2(){
        String sql = "select * from emp;";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 测试queryForObject() 查询结果，将结果封装为对象
     * 一般用于聚合函数的查询
     */
    @Test
    public void testQueryForObject(){
        String sql = "select count(id) from emp;";
        long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
