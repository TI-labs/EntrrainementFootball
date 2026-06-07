package presenter;

import models.entities.*;
import models.facades.IModel;
import models.references.Niveau;
import models.references.Poste;
import views.exceptions.ViewException;
import views.facades.IView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Presenter {
    private IModel model;
    private IView view;

    public Presenter(IModel model, IView view) {
        this.model = model;
        this.view = view;
    }

    private final int CHOIX_SORTIE = 0;

    private final String TITRE_MENU_PRINCIPAL = "Menu Principal";
    private final List<String> MENU_PRINCIPAL = new ArrayList<>(Arrays.asList(
            "Saisir un club",
            "Créer une équipe dans un club",
            "Ajouter un joueur dans une équipe",
            "Afficher les informations d'une équipe",
            //"Afficher les joueurs titulaires",
            "Supprimer un joueur d'une équipe"
    ));
    private final int TAILLE_MENU_PRINCIPAL = MENU_PRINCIPAL.size();

    public void start() throws ViewException {
        int choix;
        do {
            view.afficherMenuPrincipal(MENU_PRINCIPAL, TITRE_MENU_PRINCIPAL);
            choix = view.saisirChoixMenuAvecSortie(TAILLE_MENU_PRINCIPAL);
            gestionMenu(choix);
        } while (choix != CHOIX_SORTIE);
    }

    private void gestionMenu(int choix) throws ViewException {
        switch (choix) {
            case 1 -> saisirUnClub();
            case 2 -> creerUneEquipeDansUnClub();
            case 3 -> ajouterUnJoueurDansUneEquipe();
            case 4 -> afficherLesInfosDUneEquipe();
            case 5 -> supprimerUnJoueurDUneEquipe();
        }
    }

    private void saisirUnClub() {

        String nom = view.saisirNom("Entrez nom du club : ");
        LocalDate dateDeCreation = view.saisirDateDeCreation("Saisir la date de création du club : ");

        Club club = FactoryEntities.createClub(nom, dateDeCreation);

        model.saveClub(club);

    }

    private void creerUneEquipeDansUnClub() throws ViewException{
        List<Club>  listeClub = model.getClubList();
        view.afficherListe(listeClub,Club::getNom);
        int choixClub = view.saisirChoixMenuAvecSortie(listeClub.size());

        Club clubChoisi = listeClub.get(choixClub-1);
        Niveau niveau = view.choisirEnum(Niveau.class,Niveau::getNom);
        String nomEntraineur = view.saisirNom("saisissez le nom de l'entraineur : ");
        String prenomEntraineur = view.saisirNom("Saisissez le prenom de l'entraineur");

        Entraineur entraineur = FactoryEntities.createEntraineur(nomEntraineur,prenomEntraineur);
        model.savePersonne(entraineur);
        Equipe equipe = FactoryEntities.createEquipe(niveau, entraineur);
        model.saveEquipe(equipe);

        clubChoisi.addEquipe(equipe);
    }

    private void ajouterUnJoueurDansUneEquipe() throws ViewException {
        List<Club>  listeClub = model.getClubList();
        view.afficherListe(listeClub,Club::getNom);
        int choixClub = view.saisirChoixMenuAvecSortie(listeClub.size());
        List<Equipe>  listeEquipe = model.getEquipeList();
        view.afficherListe(listeEquipe,Equipe::toString);
        int choixEquipe = view.saisirChoixMenuAvecSortie(listeEquipe.size());
        String nom = view.saisirNom("saisir nom du joueur");
        String prenom = view.saisirNom("saisir prenom du joueur");

        LocalDate dateDeNaissance = view.saisirDateDeCreation("Saisissez la date de naissance");
        Poste poste = view.choisirEnum(Poste.class,Poste::name);
        double prix = view.saisirPrix();
        boolean titulaire = view.saisirTitularisation();

        Joueur joueur = FactoryEntities.createJoueur(nom, prenom, prix, dateDeNaissance, poste, titulaire);

        model.savePersonne(joueur);
        Equipe equipeChoisi = listeEquipe.get(choixEquipe - 1);

        equipeChoisi.addJoueur(joueur);


    }

    private void afficherLesInfosDUneEquipe() {
    }

    private void supprimerUnJoueurDUneEquipe() {
    }
}
