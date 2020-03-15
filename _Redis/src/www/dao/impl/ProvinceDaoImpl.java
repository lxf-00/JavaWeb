package www.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import www.dao.ProviceDao;
import www.domain.Province;
import www.util.JDBCUtils;

import java.util.List;

public class ProvinceDaoImpl implements ProviceDao {
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Province> findAll() {
        // 定义sql语句
        String sql = "select * from province;";
        // 查询、封装
        List<Province> provinces = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        // 返回集合
        return provinces;
    }
}
