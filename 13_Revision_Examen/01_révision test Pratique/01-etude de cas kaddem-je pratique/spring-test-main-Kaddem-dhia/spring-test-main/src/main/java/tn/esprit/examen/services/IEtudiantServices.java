package tn.esprit.examen.services;

import tn.esprit.examen.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {
    List<Etudiant> getAllEtudiants();
    Etudiant addEtudiant(Etudiant et);
    Etudiant getEtudiantById(Integer idEtudiant);
    void removeEtudiantById(Integer idEtudiant);

}
