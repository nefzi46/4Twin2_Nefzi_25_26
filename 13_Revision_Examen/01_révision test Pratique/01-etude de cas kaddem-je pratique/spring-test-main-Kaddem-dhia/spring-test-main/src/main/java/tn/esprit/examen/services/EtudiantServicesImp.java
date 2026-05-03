package tn.esprit.examen.services;

import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Departement;
import tn.esprit.examen.entities.Etudiant;
import tn.esprit.examen.repositories.DepartementRepository;
import tn.esprit.examen.repositories.EquipeRepository;
import tn.esprit.examen.repositories.EtudiantRepository;

import java.util.List;

@Service
@RequiredArgConstructor
public class EtudiantServicesImp implements IEtudiantServices {
    private EtudiantRepository etuRepo;
    private DepartementRepository depRepo;

    @Override
    public Etudiant addEtudiant(Etudiant et) {
        return etuRepo.save(et);
    }

    @Override
    public Etudiant getEtudiantById(Integer idEtudiant) {
        return etuRepo.findById(Long.valueOf(idEtudiant)).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etuRepo.findAll();
    }

    @Override
    public void removeEtudiantById(Integer idEtudiant) {
        etuRepo.deleteById(Long.valueOf(idEtudiant));
    }

    public Etudiant assignEtudiantToDep( Integer idEtudiant, Integer idDepart) {
        Etudiant etudiant = etuRepo.findById(Long.valueOf(idEtudiant)).orElse(null);
        Departement dep = depRepo.findById(idDepart).orElse(null);
        etudiant.setDepartement(dep);
        return etuRepo.save(etudiant);
    }
    }

