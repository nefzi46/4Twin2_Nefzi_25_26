package tn.esprit.exam.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.exam.entity.Profession;
import tn.esprit.exam.entity.Programme;
import tn.esprit.exam.entity.Thematique;
import tn.esprit.exam.entity.Utilisateur;
import tn.esprit.exam.service.IUtilisateurService;

import java.util.Date;
import java.util.List;

@Tag(name = "Web Services pour la gestion de Users")
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UtilisateurRestController {


    IUtilisateurService utilisateurService;


    @PostMapping("/add-user")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur u) {
        Utilisateur utilisateur = utilisateurService.ajouterUtilisateur(u);
        return utilisateur;
    }

    @PostMapping("/add-program-channel")
    public Programme ajouterProgrammeEtChaine(@RequestBody Programme p) {
        Programme programme = utilisateurService.ajouterProgrammeEtChaine(p);
        return programme;
    }

    @PostMapping("/add-program-assign-channel/{ch-id}")
    public Programme ajouterUtilisateur(@RequestBody Programme p, @PathVariable("ch-id") Long chId) {
        Programme programme = utilisateurService.ajouterProgrammeEtAffecterChaine(p, chId);
        return programme;
    }

    @PutMapping("/assign-program-user/{pr-nom}/{usr-nom}")
    public void affecterProgrammeAUtilisateur(@PathVariable("pr-nom") String prNom, @PathVariable("usr-nom") String usrNom) {

        utilisateurService.affecterProgrammeAUtilisateur(prNom, usrNom);

    }

    @GetMapping("/get-users/{p}/{d}/{t}")
    public List<Utilisateur> listerUtilisateurs(@PathVariable("p") Profession p, @PathVariable("d") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date d, @PathVariable("t") Thematique t) {

        return utilisateurService.recupererUtilisateurs(p, d, t);

    }

    /*@GetMapping("/get-users/{usr-id}")
    public List<Programme> listerProgrammes(@PathVariable("usr-id") Long usrId) {

        return utilisateurService.recupererProgrammesInteressants(usrId);

    }*/

    @PutMapping("/unassign-program-user/{pr-nom}/{usr-nom}")
    public void desaffecterProgrammeAUtilisateur(@PathVariable("pr-nom") String prNom, @PathVariable("usr-nom") String usrNom) {

        utilisateurService.desaffecterProgrammeDeUtilisateur(prNom, usrNom);

    }

}
