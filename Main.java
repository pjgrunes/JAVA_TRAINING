package M6_Act4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            m6Activity4Solution(em);
        } finally {
            em.close();
            emf.close();
        }
    }

    static void m6Activity4Solution(EntityManager em) {

        em.getTransaction().begin();

        // 1. create student object, assign values
        Student newStudent = new Student("Nana", 9, "nana@school.edu");

        // 2. attach transient student object to persistence context
        em.persist(newStudent);

        // 3. call flush()
        em.flush();

        // 4. detach the managed newStudent from the persistence context
        em.detach(newStudent);

        // 5. print "is newStudent inside the persistence context: " + call contains()
        System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

        // 6. reattach the detached newStudent
        Student managedAgain = em.merge(newStudent);

        // 7. update newStudent, change some values like age or email
        managedAgain.setAge(7);
        managedAgain.setEmail("nana7@school.edu");
        managedAgain.setName("Nanar");

        // 8. call flush()
        em.flush();

        // 9. print "is newStudent inside the persistence context: " + call contains()
        System.out.println("is newStudent inside the persistence context: " + em.contains(managedAgain)); // true

        // 10/11. mark managed newStudent for deletion
        em.remove(managedAgain);

        // 12. call flush() so DELETE executes
        em.flush();

        // 13. print "is newStudent inside the persistence context: " + call contains()
        System.out.println("is newStudent inside the persistence context: " + em.contains(managedAgain)); // false

        em.getTransaction().commit();
    }
}
