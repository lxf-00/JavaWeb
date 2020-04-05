package www.dao;

import www.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * 查询所有的雇员信息
     */
    public List<Employee> findAll() throws Exception;
}
