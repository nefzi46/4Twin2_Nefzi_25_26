package tn.esprit.examen.services;

import tn.esprit.examen.entities.Departement;
import tn.esprit.examen.repositories.DepartementRepository;

import java.util.List;

public class DepartementServiceImpl implements IDepartementServices{

    private DepartementRepository repoDep;
    @Override
    public List<Departement> getDepartements() {
        return repoDep.findAll();
    }

    @Override
    public Departement getDepartement(Integer idDepart) {
        return repoDep.findById(idDepart).get();
    }

    @Override
    public Departement addDepartement(Departement departement) {
        return repoDep.save(departement);
    }

    @Override
    public Departement updateDepartement(Departement departement) {
        return repoDep.save(departement);
    }

    @Override
    public void deleteDepartement(Integer idDepart) {
        repoDep.deleteById(idDepart);

    }
}
