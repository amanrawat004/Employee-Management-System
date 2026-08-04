package entity;
import jakarta.persistence.*;
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;
    @Column(name = "emp_name", nullable = false, length = 50)
    private String empName;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "salary")
    private double salary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
    public Employee() {
    }
    public Employee(String empName, String email, double salary) {
        this.empName = empName;
        this.email = email;
        this.salary = salary;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "\nEmployee Details"
                + "\n"
                + "\nEmployee ID: " + empId
                + "\nName: " + empName
                + "\nEmail: " + email
                + "\nSalary: " + salary
                + "\nDepartment: "
                + (department != null ? department.getDeptName() : "Not Assigned");
    }
}