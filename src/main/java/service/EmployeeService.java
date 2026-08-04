package service;
import java.util.List;
import entity.Employee;
public interface EmployeeService {
    boolean saveEmployee(Employee employee);
    Employee searchEmployee(int empId);
    List<Employee> displayEmployees();
    boolean modifyEmployee(Employee employee);
    boolean removeEmployee(int empId);
}