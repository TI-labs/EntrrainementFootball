package models.entities;

import models.exceptions.EntitiyExeption;

import java.util.Objects;

public class Entity extends AbstractEntity {
    String name;

    protected Entity(String name) throws EntitiyExeption {
        setName(name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) throws EntitiyExeption {
        if (name == null) {
            throw new EntitiyExeption("Entity name cannot be null");
        }
        this.name = name;
    }

    public String displayable() {
        return """
                [Entity] %s
                """.formatted(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Entity entity = (Entity) o;
        return Objects.equals(getName(), entity.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }
}
