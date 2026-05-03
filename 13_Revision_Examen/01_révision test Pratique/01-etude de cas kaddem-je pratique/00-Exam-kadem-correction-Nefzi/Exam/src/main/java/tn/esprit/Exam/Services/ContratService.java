package tn.esprit.Exam.Services;

import org.springframework.scheduling.annotation.Scheduled;

public class ContratService implements IContratService {

    @Scheduled(cron = "0 0 13 */15 * *") // Tous les 15 jours à 13h
    public String retrieveStatusContrat() {
        // Logique pour trouver contrats finissant dans 15 jours, log sur console
        System.out.println("Contrats à vérifier : ...");
        return "Status checked";
    }
}
