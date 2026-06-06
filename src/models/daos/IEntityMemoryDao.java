package models.daos;

import models.daos.generic.Dao;
import models.entities.Entity;

import java.util.List;

public interface IEntityMemoryDao extends Dao<Entity> {

    List<Entity> readAllWithName(String name);
}
