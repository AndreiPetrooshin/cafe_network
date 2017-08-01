package repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityUtil {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("persistenceUnit");


    public static EntityManagerFactory getInstance() {
        synchronized (entityManagerFactory){
            return entityManagerFactory;
        }
    }

    private EntityUtil() {
    }
}
