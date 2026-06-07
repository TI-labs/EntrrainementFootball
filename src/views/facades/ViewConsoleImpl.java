package views.facades;

import models.entities.AbstractEntity;
import views.exceptions.ViewException;
import views.utils.AffichageConsole;
import views.utils.LectureConsole;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ViewConsoleImpl implements IView{

    @Override
    public void afficherMessage(String message) {
        AffichageConsole.afficherMessageAvecSautLigne(message);
    }

    @Override
    public void afficherMenuPrincipal(List<String> menu, String titre) {
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(menu, titre, "Quitter");
    }

    @Override
    public void afficherMenuEncadreAvecRetour(List<String> menu, String titre) {
        AffichageConsole.afficherMenuEntoureAvecOptionSortie(menu, titre, "Retour");
    }

    @Override
    public void afficherMenuSimpleAvecRetour(List<String> choix, String nomElements) {
        AffichageConsole.afficherMessageAvecSautLigne("Liste des " + nomElements + " : ");
        AffichageConsole.afficherMenuSimpleAvecOptionSortie(choix, "Retour");
    }




    @Override
    public int saisirChoixMenuAvecSortie(int tailleMenu) {
        return LectureConsole.lectureChoixInt(0, tailleMenu);
    }

    @Override
    public <T> void afficherListe(List<T> maListe, Function<T, String> affichable) throws ViewException {

        if (maListe.isEmpty()) {
            throw new ViewException("La liste est vide");
        } else {

            //affichage de l'entête
            AffichageConsole.afficherMessageAvecSautLigne("Liste des " + maListe.getFirst().getClass().getSimpleName() + "s : ");

            //affichage de chaque élément de la liste
            for (T element : maListe) {
                AffichageConsole.afficherMessageAvecSautLigne(affichable.apply(element));
            }
        }
    }

    @Override
    public <T extends AbstractEntity> T choisirDansListe(List<T> maListe, Function<T, String> affichable) throws ViewException {

        if (maListe.isEmpty()) {
            throw new ViewException("La liste est vide");
        } else {

            //création de la liste affichable
            List<String> listeAffichable = new ArrayList<>();
            for (T element : maListe) {
                listeAffichable.add(affichable.apply(element));
            }

            //affichage de la liste avec entête
            AffichageConsole.afficherMessageAvecSautLigne("Liste des " + maListe.getFirst().getClass().getSimpleName() + "s : ");
            AffichageConsole.afficherMenuSimple(listeAffichable);

            //choix dans la liste
            int choix = LectureConsole.lectureChoixInt(1, maListe.size());
            return maListe.get(choix - 1);
        }
    }

    @Override
    public <T extends Enum<T>> T choisirEnum(Class<T> monEnum, Function<T, String> affichable) throws ViewException {

        if (monEnum.getEnumConstants().length == 0) {
            throw new ViewException("Aucun élément dans l'Enum");
        } else {

            //création de la liste affichable
            List<String> listeAffichable = new ArrayList<>();
            for (T element : monEnum.getEnumConstants()) {
                listeAffichable.add(affichable.apply(element));
            }

            //affichage de la liste avec entête
            AffichageConsole.afficherMessageAvecSautLigne("Liste des " + monEnum.getSimpleName() + "s : ");
            AffichageConsole.afficherMenuSimple(listeAffichable);

            //choix dans l'Enum
            int choix = LectureConsole.lectureChoixInt(1, monEnum.getEnumConstants().length);
            return monEnum.getEnumConstants()[choix];
        }
    }

    @Override
    public String entrerNom() {
        return LectureConsole.lectureChaineCaracteres("Saisir un nom : ");
    }

    @Override
    public String saisirNom(String message) {
        return LectureConsole.lectureChaineCaracteres(message);
    }

    @Override
    public LocalDate saisirDateDeCreation(String message) {
        afficherMessage(message);
        return LectureConsole.lectureLocalDate("JJ-MM-AAAA");
    }

    @Override
    public double saisirPrix() {

        return LectureConsole.lectureDouble(" saisissez le prix du joueur : ");
    }

    @Override
    public boolean saisirTitularisation() {
        return LectureConsole.lectureBoolean("Le joueur est il titulaire? O/N");
    }
}
