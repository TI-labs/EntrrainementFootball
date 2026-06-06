package models.entities;

import models.exceptions.EntitiyExeption;
import models.exceptions.FactoryException;
import views.exceptions.ViewException;

public final class FactoryEntities {

    private FactoryEntities(){}

    public static Entity createEntity(String name) throws FactoryException {
        try {
            Entity entity = new Entity(name);
            return entity;
        }
        catch (EntitiyExeption e) {
            throw new FactoryException("[Erreur création Entity] " + e.getMessage());
        }
    }
}
