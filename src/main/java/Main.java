import entity.Employee;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

//            Employee dalia = new Employee();
//            dalia.setId(6);
//            dalia.setFirstName("Dalia");
//            dalia.setLastName("Abo Sheasha");
//            entityManager.persist(dalia);

            TypedQuery<Employee> empByDeptQuery = entityManager.createNamedQuery("Employee.byDept", Employee.class);
            empByDeptQuery.setParameter(1, "Java Advocacy");
            for (Employee employee : empByDeptQuery.getResultList()) {
                System.out.println(employee);
            }

            Query countEmpByDept = entityManager.createNativeQuery("SELECT COUNT(*) FROM Employee INNER JOIN Department D on Employee.department_id = D.id WHERE D.name=:deptName");
            countEmpByDept.setParameter("deptName", "Java Advocacy");
            System.out.println("There are " + countEmpByDept.getSingleResult() + " Java Advocates.");

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
