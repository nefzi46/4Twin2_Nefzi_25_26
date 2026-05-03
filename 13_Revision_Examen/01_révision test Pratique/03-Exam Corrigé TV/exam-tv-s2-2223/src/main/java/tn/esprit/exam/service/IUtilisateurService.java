package tn.esprit.exam.service;

import tn.esprit.exam.entity.*;

import java.util.Date;
import java.util.List;

public interface IUtilisateurService {

    public Utilisateur ajouterUtilisateur(Utilisateur u);

    public Programme ajouterProgrammeEtChaine(Programme p);

    public Programme ajouterProgrammeEtAffecterChaine(Programme p, Long chId);

    public void affecterProgrammeAUtilisateur(String prNom, String usrNom);

    public List<Utilisateur> recupererUtilisateurs(Profession p, Date d, Thematique t);

    public void ordonnerChaines();

    //public List<Programme> recupererProgrammesInteressants(Long usrId);

    public void desaffecterProgrammeDeUtilisateur(String prNom, String usrNom);

}
