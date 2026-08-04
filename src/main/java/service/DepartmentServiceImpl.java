
package service;
import java.util.List;
import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;
import entity.Department;
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDAO departmentDAO;
    public DepartmentServiceImpl() {
        departmentDAO = new DepartmentDAOImpl();
    }
    @Override
    public boolean saveDepartment(Department department) {
        return departmentDAO.addDepartment(department);
    }
    @Override
    public Department searchDepartment(int deptId) {
        return departmentDAO.findDepartmentById(deptId);
    }
    @Override
    public List<Department> displayDepartments() {
        return departmentDAO.getAllDepartments();
    }
    @Override
    public boolean modifyDepartment(Department department) {
        return departmentDAO.updateDepartment(department);
    }
    @Override
    public boolean removeDepartment(int deptId) {
        return departmentDAO.deleteDepartment(deptId);
    }
}