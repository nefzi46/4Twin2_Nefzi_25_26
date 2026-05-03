package tn.esprit.examen.services;

import tn.esprit.examen.entities.Departement;

import java.util.List;

public interface IDepartementServices {
    List<Departement> getDepartements();
    Departement getDepartement(Integer idDepart);
    Departement addDepartement(Departement departement);
    Departement updateDepartement(Departement departement);
    void deleteDepartement(Integer idDepart);
}
