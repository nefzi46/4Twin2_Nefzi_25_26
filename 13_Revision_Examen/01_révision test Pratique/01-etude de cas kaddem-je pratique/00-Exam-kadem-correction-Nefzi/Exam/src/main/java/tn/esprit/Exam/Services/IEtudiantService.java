package tn.esprit.Exam.Services;

import tn.esprit.Exam.Entity.Departement;
import tn.esprit.Exam.Entity.Etudiant;
import tn.esprit.Exam.Entity.Option;

import java.util.List;

public interface IEtudiantService {


    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant(Etudiant e);
    Etudiant updateEtudiant(Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
    // Signatures supplémentaires du spec
    Etudiant addAndAssignEtudiant(Etudiant e, Option o, Departement d);
}
