package models.daos;

import models.daos.generic.MemoryDao;
import models.entities.AbstractEntity;

public final class DaoFactory {

    private static IEntityMemoryDao entityMemoryDao;

    private DaoFactory() {}

    public static IEntityMemoryDao getEntityMemoryDao() {

        if (entityMemoryDao == null) {
            entityMemoryDao = new EntityMemoryDao();
        }
        return entityMemoryDao;
    }
}
