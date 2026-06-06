package presenter;

import models.facades.IModel;
import views.facades.IView;

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

    public void start() {
        int choix;
        do {
            view.afficherMenuPrincipal(MENU_PRINCIPAL, TITRE_MENU_PRINCIPAL);
            choix = view.saisirChoixMenuAvecSortie(TAILLE_MENU_PRINCIPAL);
            gestionMenu(choix);
        } while (choix != CHOIX_SORTIE);
    }

    private void gestionMenu(int choix) {
        switch (choix) {
            case 1 -> saisirUnClub();
            case 2 -> créerUneEquipeDansUnClub();
            case 3 -> ajouterUnJoueurDansUneEquipe();
            case 4 -> afficherLesInfosDUneEquipe();
            case 5 -> supprimerUnJoueurDUneEquipe();
        }
    }

    private void saisirUnClub() {

    }

    private void créerUneEquipeDansUnClub() {
    }

    private void ajouterUnJoueurDansUneEquipe() {

    }

    private void afficherLesInfosDUneEquipe() {
    }

    private void supprimerUnJoueurDUneEquipe() {
    }
}
