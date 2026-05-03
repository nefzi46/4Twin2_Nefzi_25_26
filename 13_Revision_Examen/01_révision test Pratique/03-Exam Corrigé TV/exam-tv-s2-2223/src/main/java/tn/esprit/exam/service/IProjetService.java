package tn.esprit.exam.service;

import tn.esprit.exam.entity.Projet;

import java.util.List;

public interface IProjetService {

    public List<Projet> retrieveAllProjets();

    public Projet retrieveProjet(Long projetId);

    public Projet addProjet(Projet p);

    public void removeProjet(Long projetId);

    public Projet modifyProjet(Projet projet);

}
