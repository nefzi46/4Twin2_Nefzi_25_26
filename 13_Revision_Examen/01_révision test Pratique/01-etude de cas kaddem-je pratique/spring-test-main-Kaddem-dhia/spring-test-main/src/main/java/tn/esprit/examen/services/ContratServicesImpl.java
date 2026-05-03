package tn.esprit.examen.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Contrat;
import tn.esprit.examen.repositories.ContratRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ContratServicesImpl implements IContratRepository{

    private final ContratRepository repoCon;

    @Override
    public List<Contrat> getAllContrats() {
        return repoCon.findAll();
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return repoCon.save(contrat);

    }

    @Override
    public Contrat getContratById(Integer idContrat) {
        return repoCon.findById(idContrat).get();
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return repoCon.save(contrat);
    }

    @Override
    public void deleteContrat(Integer idContrat) {
        repoCon.deleteById(idContrat);

    }
}
