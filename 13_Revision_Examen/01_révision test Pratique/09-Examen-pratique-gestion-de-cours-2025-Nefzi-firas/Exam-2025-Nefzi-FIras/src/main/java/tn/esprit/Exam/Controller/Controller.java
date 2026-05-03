package tn.esprit.Exam.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Exam.Entity.Championnat;
import tn.esprit.Exam.Entity.Pilote;
import tn.esprit.Exam.Services.ChampionnatService;
import tn.esprit.Exam.Services.PiloteService;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ChampionnatService championnatService;




//    @PostMapping("/cours-depart")
//    public Course addCoursAndDepart(@RequestBody Course c) {
//        return championnatService.addCoursAndDepart(c);
//    }
//
//    @PostMapping("/cours-assign/{idDepart}")
//    public Course addCoursAndAssignToDepart(@RequestBody Course c, @PathVariable Long idDepart) {
//        return championnatService.addCoursAndAssignToDepart(c, idDepart);
//    }
//
//    @PostMapping("/affecter-cours")
//    public void affecterCoursToEtudiant(@RequestParam String nomCours, @RequestParam String nomEtudiant) {
//        championnatService.affecterCoursToEtudiant(nomCours, nomEtudiant);
//    }
//
//    @GetMapping("/etudiants-retrieve")
//    public List<Championnat> retrieveEtudiant(@RequestParam Categorie n, @RequestParam String d, @RequestParam Specialite s) {
//        return championnatService.retrieveEtudiant(n, LocalDate.parse(d), s);
//    }
//
//    // Le scheduler s'exécute automatiquement, pas besoin d'endpoint
//
//    @PostMapping("/disassign-cours")
//    public void disassignCoursFromEtudiant(@RequestParam String nomCours, @RequestParam String nomEtudiant) {
//        championnatService.disassignCoursFromEtudiant(nomCours, nomEtudiant);
//    }
}