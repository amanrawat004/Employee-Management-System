package dao;
import java.util.List;
import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import util.HibernateUtil;
public class DepartmentDAOImpl implements DepartmentDAO {
    private EntityManager entityManager;
    public DepartmentDAOImpl() {
        entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    }
    @Override
    public boolean addDepartment(Department department) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(department);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Department could not be added.");
            return false;
        }
    }
    @Override
    public Department findDepartmentById(int deptId) {
        return entityManager.find(Department.class, deptId);
    }
    @Override
    public List<Department> getAllDepartments() {
        TypedQuery<Department> query = entityManager.createQuery(
                "SELECT d FROM Department d ORDER BY d.deptName",
                Department.class);
        return query.getResultList();
    }
    @Override
    public boolean updateDepartment(Department department) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(department);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }
    @Override
    public boolean deleteDepartment(int deptId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Department department = entityManager.find(Department.class, deptId);
            if (department == null) {
                System.out.println("Department Not Found.");
                return false;
            }
            entityManager.remove(department);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }
}