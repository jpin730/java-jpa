package org.example.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeEntityManagerFactory {
    private static final EntityManagerFactory factory = buildFactory();

    private static EntityManagerFactory buildFactory() {
        return Persistence.createEntityManagerFactory("persistenceUnit");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
