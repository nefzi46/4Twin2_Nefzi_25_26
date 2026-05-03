package tn.esprit.Exam.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.Exam.Entity.Universite;
import tn.esprit.Exam.Services.IUniversiteService;

public class UniveristeRestController {
    private final IUniversiteService universiteService;

    @PostMapping(/"add")
    public String addUniversite(@RequestBody Universite universite) {
        return universiteService.addorUpdateUniversite(universite);
    }

}
