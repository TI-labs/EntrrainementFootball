package models.entities;

import models.references.Poste;

import java.time.LocalDate;
import java.util.Objects;

public class Joueur extends Personne{

    private double prix;
    private LocalDate dateDeNaissance;
    private Poste poste;
    private boolean estTitulaire;

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public boolean isEstTitulaire() {
        return estTitulaire;
    }

    public void setEstTitulaire(boolean estTitulaire) {
        this.estTitulaire = estTitulaire;
    }


    protected Joueur(String nom, String prenom, double prix, LocalDate dateDeNaissance, Poste poste, boolean estTitulaire) {
        super(nom, prenom);
        setPrix(prix);
        setDateDeNaissance(dateDeNaissance);
        setPoste(poste);
        setEstTitulaire(estTitulaire);
    }

    @Override
    public String presentation() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Joueur joueur = (Joueur) o;
        return Objects.equals(dateDeNaissance, joueur.dateDeNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dateDeNaissance);
    }
}
