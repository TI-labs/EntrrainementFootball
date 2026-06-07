package views.facades;

import models.entities.AbstractEntity;
import views.exceptions.ViewException;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

public interface IView {

    void afficherMessage(String message);
    void afficherMenuPrincipal(List<String> menu, String titre);
    void afficherMenuEncadreAvecRetour(List<String> menu, String titre);
    void afficherMenuSimpleAvecRetour(List<String> choix, String nomElement);



    int saisirChoixMenuAvecSortie(int tailleMenu);


    <T> void afficherListe(List<T> maListe, Function<T, String> affichable) throws ViewException;

    <T extends AbstractEntity> T choisirDansListe(List<T> maListe, Function<T, String> affichable) throws ViewException;
    <T extends Enum<T>> T choisirEnum(Class<T> monEnum, Function<T, String> affichable) throws ViewException;

    String entrerNom();

    String saisirNom(String s);

    LocalDate saisirDateDeCreation(String s);

    double saisirPrix();

    boolean saisirTitularisation();
}
