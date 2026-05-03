package tn.esprit.Exam.Services;

import tn.esprit.Exam.Entity.Cours;
import tn.esprit.Exam.Entity.Etudiant;
import tn.esprit.Exam.Entity.Niveau;
import tn.esprit.Exam.Entity.Specialite;

import java.time.LocalDate;
import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant e);
    Cours addCoursAndDepart(Cours c);
    Cours addCoursAndAssignToDepart(Cours c, Long idDepart);
    void affecterCoursToEtudiant(String nomCours, String nomEtudiant);
    List<Etudiant> retrieveEtudiant(Niveau n, LocalDate d, Specialite s);
    void ordonnerDepart();
    void disassignCoursFromEtudiant(String nomCours, String nomEtudiant);
}