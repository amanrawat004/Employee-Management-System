package dao;
import java.util.List;
import entity.Employee;
public interface EmployeeDAO {
    boolean addEmployee(Employee employee);
    Employee findEmployeeById(int empId);
    List<Employee> getEmployees();
    boolean updateEmployee(Employee employee);
    boolean removeEmployee(int empId);
}