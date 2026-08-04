package dao;
import java.util.List;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import util.HibernateUtil;
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;
    public EmployeeDAOImpl() {
        entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
    }
    @Override
    public boolean addEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            System.out.println("Unable to Save Employee");
            return false;
        }
    }
    @Override
    public Employee findEmployeeById(int empId) {
        return entityManager.find(Employee.class, empId);
    }
    @Override
    public List<Employee> getEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee e ORDER BY e.empId",
                Employee.class);
        return query.getResultList();
    }
    @Override
    public boolean updateEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            return false;
        }
    }
    @Override
    public boolean removeEmployee(int empId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Employee employee = entityManager.find(Employee.class, empId);
            if (employee == null) {
                System.out.println("Employee Not Found");
                return false;
            }
            entityManager.remove(employee);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive())
                transaction.rollback();
            return false;
        }
    }
}