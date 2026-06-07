package models.facades;

import models.daos.*;
import models.daos.generic.Dao;
import models.entities.*;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements IModel{

    public ModelImpl(){
        init();
    }

    private IClubDAO clubDAO= new ClubImplDao();
    private IEquipe equipeDao = new EquipeMemoryDaoImpl();
    private IPersonneDAO personneDAO = new PersonneDAODaoImpl();

    private void init(){}

    @Override
    public void saveClub(Club club) {
        clubDAO.create(club);
    }

    @Override
    public void saveEquipe(Equipe equipe){
        equipeDao.create(equipe);
    }

    @Override
    public void savePersonne(Personne personne){
        personneDAO.create(personne);
    }

    @Override
    public <T> List<T> recupererListIndex(Dao<T> maDao) {
        Iterable<T> iterable = maDao.readAll();
        List<T> list = new ArrayList<>();

        for( T t : iterable ){
            list.add(t);
        }
        return list ;
    }

    @Override
    public List<Club> getClubList(){
        return recupererListIndex(clubDAO);
    }
    @Override
    public List<Equipe> getEquipeList(){
        return recupererListIndex(equipeDao);
    }
    @Override
    public List<Joueur> getJoueurList(){
        return personneDAO.getJoueursList();
    }
    @Override
    public List<Entraineur> getEntraineurList(){
        return personneDAO.getEntraineursList();
    }

}
