package models.entities;

public class Entraineur extends Personne{
    @Override
    public String presentation(){
        return "";
    }

    protected Entraineur(String nom, String prenom) {
        super(nom, prenom);
    }


}
