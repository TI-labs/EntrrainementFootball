package models.entities;

import java.time.LocalDate;
import java.util.*;

public class Club extends AbstractEntity {
    private Set<Equipe> equipes = new HashSet<>();
    private LocalDate dateDeCreation ;
    private String nom;

    public Set<Equipe> getEquipe() {
        return Collections.unmodifiableSet(equipes);
    }

    public void setEquipe(HashSet<Equipe> equipe) {
        this.equipes = equipe;
    }

    public void addEquipe(Equipe equipe){
        equipes.add(equipe);
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

    public Club(String nom, LocalDate dateDeCreation) {
        setNom(nom);
        setDateDeCreation(dateDeCreation);

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
