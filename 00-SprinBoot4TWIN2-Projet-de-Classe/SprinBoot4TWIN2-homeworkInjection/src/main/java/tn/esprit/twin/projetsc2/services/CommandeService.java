package tn.esprit.twin.projetsc2.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.twin.projetsc2.entities.Client;
import tn.esprit.twin.projetsc2.entities.Commande;
import tn.esprit.twin.projetsc2.entities.Composant;
import tn.esprit.twin.projetsc2.entities.Menu;
import tn.esprit.twin.projetsc2.repository.ClientRepo;
import tn.esprit.twin.projetsc2.repository.CommandeRepo;
import tn.esprit.twin.projetsc2.repository.MenuRepo;

import java.time.LocalDate;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class CommandeService implements CommandeInterface {

    private CommandeRepo commandeRepo;
    private ClientRepo clientRepo;
    private MenuRepo menuRepo;
    private CommandeMapper commandeMapper;
    @Override
    public List<Commande> retrieveAllCommandes() {
        return commandeRepo.findAll();
    }

    @Override
    public Commande retrieveCommande(Long idCommande) {
        return commandeRepo.findById(idCommande).orElse(null);
    }

    @Override
    public Commande addCommande(Commande c) {
        return commandeRepo.save(c);
    }

    @Override
    public Commande updateCommande(Commande c, Long idCommande) {
        c.setIdCommande(idCommande);
        return commandeRepo.save(c);
    }

    @Override
    public void removeCommande(Long idCommande) {
        commandeRepo.deleteById(idCommande);
    }

    @Override
    public List<Commande> addCommandes(List<Commande> commandes) {
        return commandeRepo.saveAll(commandes);
    }

    @Override
    public List<Commande> getByClientIdClient(Long idClient) {
        return commandeRepo.findByClientIdClient(idClient);
    }

    @Override
    public List<Commande> getByClientIdClientAndDateCommandeBetween(Long idClient, LocalDate startDate, LocalDate endDate) {
        return commandeRepo.findByClientIdClientAndDateCommandeBetween(idClient, startDate, endDate);
    }

    @Override
    public List<Commande> getByDateCommandeBetweenOrderByNoteDesc(LocalDate startDate, LocalDate endDate) {
        return commandeRepo.findByDateCommandeBetweenOrderByNoteDesc(startDate, endDate);
    }

    @Override
    public void ajouterCommandeEtAffecterAClientEtMenu(Commande commande, String identifiant, String libelleMenu) {
        Client client = clientRepo.findByIdentifiant(identifiant);
        Menu menu = menuRepo.findByLibelleMenu(libelleMenu);
        if(client != null && menu != null){
            // Le total commande et le total remise est calculable selon le prix du menu envoyé et le
            //pourcentage de la remise
            float totalCommande = menu.getPrixTotal();
            commande.setTotalCommande(totalCommande);
            float totalRemise = (commande.getPourcentageRemise() / 100.0f) * totalCommande;
            commande.setTotalRemise(totalRemise);
            commande.setClient(client);
            commande.setMenu(menu);
            commandeRepo.save(commande);
        }
    }
    @Override
    @Scheduled(cron = "*/30 * * * * ?")
// Cette méthode s’exécute toutes les 30 secondes (utile pour tester rapidement pendant le développement
// En production, on pourrait la passer à une fois par jour (ex: "0 0 1 * * ?" → tous les jours à 01h00)
    public void findCurrentYearCommandesOrderByNote() {

        // On définit la période de l’année en cours : du 1er janvier au 31 décembre de l’année actuelle
        LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), 1, 1);
        LocalDate endDate   = LocalDate.of(LocalDate.now().getYear(), 12, 31);

        // Requête JPQL personnalisée dans CommandeRepository qui retourne toutes les commandes de l’année
        // triées par note décroissante (les meilleures notes en premier)
        List<Commande> commandes = commandeRepo.findByDateCommandeBetweenOrderByNoteDesc(startDate, endDate);

        // Parcours de la liste pour afficher un message clair dans les logs
        for (Commande c : commandes) {
            log.info("La commande faite le {} d'un montant global de {} DT a une note de {}/5",
                    c.getDateCommande(),
                    c.getTotalCommande(),
                    c.getNote());
        }

        // Résultat attendu dans la console :
        // La commande faite le 2025-06-15 d'un montant global de 145.0 DT a une note de 5/5
        // La commande faite le 2025-03-22 d'un montant global de 89.5 DT a une note de 4/5
        // ...
    }

    @Override
    @Scheduled(cron = "*/15 * * * * ?")
// Exécute cette tâche toutes les 15 secondes (très pratique pour voir le résultat immédiatement en dev)
// En environnement réel, on mettrait plutôt : "0 0 0 * * ?" → tous les jours à minuit
    public void menuPlusCommande() {

        // Requête JPQL qui retourne une liste d’Object[] contenant :
        // [0] → libellé du menu (String)
        // [1] → nombre de fois où ce menu a été commandé (Long)
        // Le tout trié par nombre de commandes décroissant (le 1er est le plus vendu)
        List<Object[]> results = commandeRepo.menuPlusCommande();

        if (!results.isEmpty()) {
            // On récupère uniquement le menu le plus commandé (premier de la liste)
            Object[] topMenu = results.get(0);
            String libelleMenu = (String) topMenu[0];
            Long   count       = (Long)   topMenu[1];

            log.info("Le menu le plus commandé dans votre restaurant est : \"{}\" → commandé {} fois cette année.",
                    libelleMenu, count);

            // Exemple d’affichage dans les logs :
            // Le menu le plus commandé dans votre restaurant est : "Pizza Margherita" → commandé 127 fois cette année.
        } else {
            log.info("Aucune commande trouvée dans la base de données pour le moment.");
        }
    }

    // liste des commandes correspondant à un client donné et un menu donné avec dto
    @Override
    public List<CommandeDTO> listeCommandesParClientEtMenu(String identifiant, String libelleMenu) {
        List<Commande> commandes= commandeRepo.findByClientIdentifiantAndMenuLibelleMenu(identifiant,libelleMenu);
        return commandeMapper.toDtoList(commandes);
    }

}
