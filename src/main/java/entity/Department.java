package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private int deptId;

    @Column(name = "dept_name", nullable = false)
    private String deptName;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "department",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String deptName, String location) {
        this.deptName = deptName;
        this.location = location;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {

        employees.add(employee);

        employee.setDepartment(this);
    }

    @Override
    public String toString() {

        return "Department [ID=" + deptId
                + ", Name=" + deptName
                + ", Location=" + location + "]";
    }

}