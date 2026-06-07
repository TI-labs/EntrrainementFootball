package models.daos;

import models.daos.generic.Dao;
import models.entities.Entraineur;
import models.entities.Joueur;
import models.entities.Personne;

import java.util.List;

public interface IPersonneDAO extends Dao<Personne> {
    List<Joueur> getJoueursList();

    List<Entraineur> getEntraineursList();
}
