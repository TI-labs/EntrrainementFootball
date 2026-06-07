package models.daos;

import models.daos.generic.MemoryDao;
import models.entities.Entraineur;
import models.entities.Joueur;
import models.entities.Personne;

import java.util.ArrayList;
import java.util.List;

public class PersonneDAODaoImpl extends MemoryDao<Personne> implements IPersonneDAO {
    @Override
    public List<Joueur> getJoueursList() {
        List<Joueur> joueurs = new ArrayList<>();
        Iterable<Personne> personnes = readAll();

        for (Personne p : personnes) {
            if (p instanceof Joueur) {

                joueurs.add((Joueur) p);

            }
        }

        return joueurs;
    }

    @Override
    public List<Entraineur> getEntraineursList() {
        List<Entraineur> Entraineurs = new ArrayList<>();
        Iterable<Personne> personnes = readAll();

        for (Personne p : personnes) {
            if (p instanceof Entraineur) {

                Entraineurs.add((Entraineur) p);

            }
        }

        return Entraineurs;
    }
}
