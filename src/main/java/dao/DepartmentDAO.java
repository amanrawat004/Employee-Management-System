package dao;
import java.util.List;
import entity.Department;
public interface DepartmentDAO {
    boolean addDepartment(Department department);
    Department findDepartmentById(int deptId);
    List<Department> getAllDepartments();
    boolean updateDepartment(Department department);
    boolean deleteDepartment(int deptId);
}