package M6_Act2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class EntityManagerUtil {

    private static final EntityManagerUtil INSTANCE = new EntityManagerUtil();
    private final EntityManagerFactory emf;

    private EntityManagerUtil() {
        this.emf = Persistence.createEntityManagerFactory("default");
    }

    public static EntityManagerUtil getInstance() {
        return INSTANCE;
    }

    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManager(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    public void shutdownFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}