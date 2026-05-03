package tn.esprit.exam.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.exam.entity.Projet;
import tn.esprit.exam.repository.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProjetServiceImpl implements IProjetService {

    ProjetRepository projetRepository;


    //@Scheduled(fixedDelay = 10000)
    public List<Projet> retrieveAllProjets() {

        //log.info("In Method : retrieveAllProjets ");

        List<Projet> listProjets = projetRepository.findAll();
        for (Projet projet : listProjets) {
            log.info("j'affiche un prjet : " + projet);
        }

        //log.info("Out of Method : retrieveAllProjets ");

        return listProjets;

    }

    public Projet retrieveProjet(Long projetId) {
        return projetRepository.findById(projetId).get();
    }

    public Projet addProjet(Projet p) {
        return projetRepository.save(p);
    }

    public void removeProjet(Long projetId) {
        projetRepository.deleteById(projetId);
    }

    public Projet modifyProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    // Projet et ProjetDeail ne sont pas encore créés (cascade) :
    // Dans le JSON on met le Projet et le Projet Detail
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        return projetRepository.save(projet);
    }


}
