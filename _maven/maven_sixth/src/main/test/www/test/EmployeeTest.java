package www.test;

import org.junit.Test;
import www.dao.EmployeeDao;
import www.dao.impl.EmployeeDaoImpl;
import www.domain.Employee;

import java.util.List;

public class EmployeeTest {
    @Test
    public void employeeTest() throws Exception {
        EmployeeDao dao = new EmployeeDaoImpl();
        List<Employee> all = dao.findAll();
        System.out.println(all);
    }
}
