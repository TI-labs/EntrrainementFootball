package models.references;

public enum Exemple {
    EXEMPLE_1("Premier exemple"),
    EXEMPLE_2("Deuxième exemple"),
    EXEMPLE_3("Troisième exemple");

    private final String nom;

    public String getNom(){
        return nom;
    }

    Exemple(String nom) {
        this.nom = nom;
    }

}
