package service;
import java.util.List;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import entity.Employee;
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl() {
        employeeDAO = new EmployeeDAOImpl();
    }
    @Override
    public boolean saveEmployee(Employee employee) {
        if (employee.getSalary() <= 0) {
            System.out.println("Salary must be greater than 0.");
            return false;
        }
        return employeeDAO.addEmployee(employee);
    }
    @Override
    public Employee searchEmployee(int empId) {
        return employeeDAO.findEmployeeById(empId);
    }
    @Override
    public List<Employee> displayEmployees() {
        return employeeDAO.getEmployees();
    }
    @Override
    public boolean modifyEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }
    @Override
    public boolean removeEmployee(int empId) {
        return employeeDAO.removeEmployee(empId);
    }
}