package models.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

public class Club extends AbstractEntity {
    private Set<Equipe> equipe = new HashSet<>();
    private LocalDate dateDeCreation ;
    private String nom;

    public Set<Equipe> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Equipe> equipe) {
        this.equipe = equipe;
    }

    public LocalDate getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(LocalDate dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Club(String nom, LocalDate dateDeCreation, HashSet<Equipe> equipe) {
        setNom(nom);
        setDateDeCreation(dateDeCreation);
        setEquipe(equipe);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(dateDeCreation, club.dateDeCreation) && Objects.equals(nom, club.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateDeCreation, nom);
    }
}
