package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

    private static final String PERSISTENCE_UNIT = "Love";

    private static EntityManagerFactory factory;

    static {
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        } catch (Exception e) {
            System.out.println("Error Creating EntityManagerFactory");
            e.printStackTrace();
        }
    }

    private HibernateUtil() {
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }

    public static void closeFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
}