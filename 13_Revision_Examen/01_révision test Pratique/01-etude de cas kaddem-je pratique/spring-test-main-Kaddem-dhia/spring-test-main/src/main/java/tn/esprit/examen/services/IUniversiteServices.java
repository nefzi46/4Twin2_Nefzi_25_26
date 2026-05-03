package tn.esprit.examen.services;

import tn.esprit.examen.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> findAll();
    Universite findById(Integer idUniv);
    Universite add(Universite universite);
    Universite update(Universite universite);
    void delete(Integer idUniv);
}
