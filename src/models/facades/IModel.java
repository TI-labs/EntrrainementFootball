package models.facades;

import models.daos.generic.Dao;
import models.entities.*;

import java.util.List;

public interface IModel {

    void saveClub(Club club);

    void saveEquipe(Equipe equipe);

    void savePersonne(Personne personne);

    <T> List<T> recupererListIndex(Dao<T> maDao);

    List<Club> getClubList();

    List<Equipe> getEquipeList();

    List<Joueur> getJoueurList();

    List<Entraineur> getEntraineurList();
}
