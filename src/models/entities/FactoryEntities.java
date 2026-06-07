package models.entities;

import models.exceptions.EntitiyExeption;
import models.exceptions.FactoryException;
import models.references.Niveau;
import models.references.Poste;
import views.exceptions.ViewException;

import java.time.LocalDate;

public final class FactoryEntities {

    private FactoryEntities(){}

   /* public static Entity createEntity(String name) throws FactoryException {
        try {
            Entity entity = new Entity(name);
            return entity;
        }
        catch (EntitiyExeption e) {
            throw new FactoryException("[Erreur création Entity] " + e.getMessage());
        }
    }*/

    public static Club createClub(String nom, LocalDate dateDeCreation){

        return new Club(nom, dateDeCreation);
    }

    public static Equipe createEquipe(Niveau niveau,Entraineur entraineur){

        return new Equipe(niveau, entraineur);
    }

    public static Entraineur createEntraineur(String nom, String prenom){
        return new Entraineur(nom, prenom);
    }

    public static Joueur createJoueur(String nom, String prenom, double prix, LocalDate dateDeNaissance, Poste poste, Boolean estTitulaire){
        return new Joueur(nom, prenom, prix, dateDeNaissance, poste, estTitulaire);
    }


}
