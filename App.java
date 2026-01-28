package M6_Act3;

import jakarta.persistence.EntityManager;

public class App {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

        try {
            persistOneToMany(em);
        } finally {
            EntityManagerUtil.getInstance().closeEntityManager(em);
            EntityManagerUtil.getInstance().shutdownFactory();
        }
    }

    static void persistOneToMany(EntityManager em) {
        em.getTransaction().begin();

        
        Student student1 = em.find(Student.class, 1L);

        Course newCourse = new Course();
        newCourse.setCourseName("Math");
        newCourse.setGrade(85);
        newCourse.setStudent(student1);

        em.persist(newCourse);

        em.getTransaction().commit();
    }
}

