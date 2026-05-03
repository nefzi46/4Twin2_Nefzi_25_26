package tn.esprit.examen.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.entities.Universite;
import tn.esprit.examen.services.IUniversiteServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Kaddem/university")
public class UniversiteRestController {

    private final IUniversiteServices universiteServices;

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteServices.add(universite);
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteServices.update(universite);
    }

    @GetMapping("/get/{id}")
    public Universite getUniversite(@PathVariable Integer id) {
        return universiteServices.findById(id);
    }

    @GetMapping("/all")
    public List<Universite> getAllUniversites() {
        return universiteServices.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUniversite(@PathVariable Integer id) {
        universiteServices.delete(id);
    }
}
