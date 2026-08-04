package main;
import util.HibernateUtil;
import java.util.List;
import java.util.Scanner;
import entity.Department;
import entity.Employee;
import service.DepartmentService;
import service.DepartmentServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;
public class EmployeeManagementApp {
    static Scanner sc = new Scanner(System.in);
    static EmployeeService employeeService = new EmployeeServiceImpl();
    static DepartmentService departmentService = new DepartmentServiceImpl();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Department");
            System.out.println("2. View Departments");
            System.out.println("3. Add Employee");
            System.out.println("4. View Employee By ID");
            System.out.println("5. View All Employees");
            System.out.println("6. Update Employee");
            System.out.println("7. Delete Employee");
            System.out.println("8. Exit");
            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                addDepartment();
                break;
            case 2:
                showDepartments();
                break;
            case 3:
                addEmployee();
                break;

            case 4:
                searchEmployee();
                break;
            case 5:
                displayEmployees();
                break;
            case 6:
                updateEmployee();
                break;
            case 7:
                deleteEmployee();
                break;
            case 8:
                System.out.println("Thank You!");
                HibernateUtil.closeFactory();
                break;
            default:
                System.out.println("Invalid Choice.");
            }
        } while (choice != 8);
        sc.close();
    }
    private static void addDepartment() {
        sc.nextLine();
        System.out.print("Department Name : ");
        String name = sc.nextLine();
        System.out.print("Location : ");
        String location = sc.nextLine();
        Department department = new Department(name, location);
        if (departmentService.saveDepartment(department))
            System.out.println("Department Added Successfully.");
        else
            System.out.println("Operation Failed.");
    }
    private static void showDepartments() {
        List<Department> list = departmentService.displayDepartments();
        list.forEach(System.out::println);
    }
    private static void addEmployee() {
        sc.nextLine();
        System.out.print("Employee Name : ");
        String name = sc.nextLine();
        System.out.print("Email : ");
        String email = sc.nextLine();
        System.out.print("Salary : ");
        double salary = sc.nextDouble();
        System.out.print("Department Id : ");
        int deptId = sc.nextInt();
        Department department = departmentService.searchDepartment(deptId);
        if (department == null) {
            System.out.println("Department Not Found.");
            return;
        }
        Employee employee = new Employee(name, email, salary);
        employee.setDepartment(department);
        if (employeeService.saveEmployee(employee))
            System.out.println("Employee Added Successfully.");
        else
            System.out.println("Operation Failed.");
    }
    private static void searchEmployee() {
        System.out.print("Employee Id : ");
        int id = sc.nextInt();
        Employee employee = employeeService.searchEmployee(id);
        if (employee != null)
            System.out.println(employee);
        else
            System.out.println("Employee Not Found.");
    }
    private static void displayEmployees() {
        List<Employee> employees = employeeService.displayEmployees();
        if (employees.isEmpty()) {
            System.out.println("No Employee Records Found.");
            return;
        }
        employees.forEach(System.out::println);
    }
    private static void updateEmployee() {
        System.out.print("Employee Id : ");
        int id = sc.nextInt();
        Employee employee = employeeService.searchEmployee(id);
        if (employee == null) {
            System.out.println("Employee Not Found.");
            return;
        }
        sc.nextLine();
        System.out.print("New Name : ");
        employee.setEmpName(sc.nextLine());
        System.out.print("New Email : ");
        employee.setEmail(sc.nextLine());
        System.out.print("New Salary : ");
        employee.setSalary(sc.nextDouble());
        if (employeeService.modifyEmployee(employee))
            System.out.println("Employee Updated.");
        else
            System.out.println("Update Failed.");
    }
    private static void deleteEmployee() {
        System.out.print("Employee Id : ");
        int id = sc.nextInt();
        if (employeeService.removeEmployee(id))
            System.out.println("Employee Deleted.");
        else
            System.out.println("Delete Failed.");
    }
}