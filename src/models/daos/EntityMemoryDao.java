package models.daos;

import models.daos.generic.MemoryDao;
import models.entities.Entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EntityMemoryDao extends MemoryDao<Entity> implements IEntityMemoryDao {

    @Override
    public List<Entity> readAllWithName(String name) {

        List<Entity> entitiesWithName = new ArrayList<>();

        for (Entity entity : persist.values()) {
            if (entity.getName().equals(name)) {
                entitiesWithName.add(entity);
            }
        }

        return Collections.unmodifiableList(entitiesWithName);
    }


}
