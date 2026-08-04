package service;
import java.util.List;
import entity.Department;
public interface DepartmentService {
    boolean saveDepartment(Department department);
    Department searchDepartment(int deptId);
    List<Department> displayDepartments();
    boolean modifyDepartment(Department department);
    boolean removeDepartment(int deptId);
}