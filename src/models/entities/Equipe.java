package models.entities;

import models.references.Niveau;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equipe extends AbstractEntity {
    private Set<Joueur> joueurs = new HashSet<>();
    private Niveau niveau;
    private Entraineur entraineur;

    public Set<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Set<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void addJoueur(Joueur joueur){
        joueurs.add(joueur);
    }

    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "niveau=" + niveau +
                ", entraineur=" + entraineur +
                '}';
    }

    public Equipe(Niveau niveau, Entraineur entraineur) {
        setEntraineur(entraineur);
        setNiveau(niveau);

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Equipe equipe = (Equipe) o;
        return niveau == equipe.niveau && Objects.equals(entraineur, equipe.entraineur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(niveau, entraineur);
    }
}
