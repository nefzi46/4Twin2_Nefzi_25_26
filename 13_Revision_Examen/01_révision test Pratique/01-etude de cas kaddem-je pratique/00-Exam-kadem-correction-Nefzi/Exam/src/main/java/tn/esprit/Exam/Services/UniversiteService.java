package tn.esprit.Exam.Services;

import tn.esprit.Exam.Entity.Universite;
import tn.esprit.Exam.Repository.UniversiteRepo;

import java.util.List;

public class UniversiteService implements IUniversiteService {
    private final IUniversiteService UniversiteRepo;

    List<Universite> retriveAllUniversites(){
        return tn.esprit.Exam.Repository.UniversiteRepo
    }
    Universite addOrUpdateUnivrsite(Universite u);

}
