package tn.esprit.Exam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Exam.Entity.Cours;
import tn.esprit.Exam.Entity.Etudiant;
import tn.esprit.Exam.Entity.Niveau;
import tn.esprit.Exam.Entity.Specialite;
import tn.esprit.Exam.Services.EtudiantService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/etudiants")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantService.addEtudiant(e);
    }

    @PostMapping("/cours-depart")
    public Cours addCoursAndDepart(@RequestBody Cours c) {
        return etudiantService.addCoursAndDepart(c);
    }

    @PostMapping("/cours-assign/{idDepart}")
    public Cours addCoursAndAssignToDepart(@RequestBody Cours c, @PathVariable Long idDepart) {
        return etudiantService.addCoursAndAssignToDepart(c, idDepart);
    }

    @PostMapping("/affecter-cours")
    public void affecterCoursToEtudiant(@RequestParam String nomCours, @RequestParam String nomEtudiant) {
        etudiantService.affecterCoursToEtudiant(nomCours, nomEtudiant);
    }

    @GetMapping("/etudiants-retrieve")
    public List<Etudiant> retrieveEtudiant(@RequestParam Niveau n, @RequestParam String d, @RequestParam Specialite s) {
        return etudiantService.retrieveEtudiant(n, LocalDate.parse(d), s);
    }

    // Le scheduler s'exécute automatiquement, pas besoin d'endpoint

    @PostMapping("/disassign-cours")
    public void disassignCoursFromEtudiant(@RequestParam String nomCours, @RequestParam String nomEtudiant) {
        etudiantService.disassignCoursFromEtudiant(nomCours, nomEtudiant);
    }
}