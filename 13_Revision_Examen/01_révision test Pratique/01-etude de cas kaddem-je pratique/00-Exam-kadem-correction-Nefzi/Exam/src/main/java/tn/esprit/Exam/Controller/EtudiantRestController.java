package tn.esprit.Exam.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Exam.Entity.Etudiant;
import tn.esprit.Exam.Services.IEtudiantService;

import java.util.List;
@RestController
@RequestMapping("/etudiant")

public class EtudiantRestController {



        @Autowired
        IEtudiantService etudiantService;

        @GetMapping("/retrieve-all-etudiants")
        public List<Etudiant> getEtudiants() {
            return etudiantService.retrieveAllEtudiants();
        }

        @PostMapping("/add-etudiant")
        public Etudiant addEtudiant(@RequestBody Etudiant e) {
            return etudiantService.addEtudiant(e);
        }

        // Ajoutez les autres endpoints similaires pour update, retrieve, remove, addAndAssign
    }
