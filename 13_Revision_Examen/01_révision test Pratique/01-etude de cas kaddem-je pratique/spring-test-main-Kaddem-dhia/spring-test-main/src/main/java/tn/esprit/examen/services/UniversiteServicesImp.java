package tn.esprit.examen.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.entities.Universite;
import tn.esprit.examen.repositories.UniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UniversiteServicesImp implements IUniversiteServices {

    private UniversiteRepository repoUni;
    @Override
    public List<Universite> findAll() {
        return repoUni.findAll();
    }

    @Override
    public Universite findById(Integer idUniv) {
        return repoUni.findById(idUniv).get();
    }

    @Override
    public Universite add(Universite universite) {
        return repoUni.save(universite);
    }

    @Override
    public Universite update(Universite universite) {
        return repoUni.save(universite);
    }

    @Override
    public void delete(Integer idUniv) {
        repoUni.deleteById(idUniv);

    }
}
