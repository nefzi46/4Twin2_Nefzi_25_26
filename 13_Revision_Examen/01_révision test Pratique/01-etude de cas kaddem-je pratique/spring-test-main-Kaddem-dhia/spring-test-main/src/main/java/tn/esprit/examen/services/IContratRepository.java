package tn.esprit.examen.services;

import tn.esprit.examen.entities.Contrat;

import java.util.List;

public interface IContratRepository {
    List<Contrat> getAllContrats();
    Contrat addContrat(Contrat contrat);
    Contrat getContratById(Integer idContrat);
    Contrat updateContrat(Contrat contrat);
    void deleteContrat(Integer idContrat);

}
