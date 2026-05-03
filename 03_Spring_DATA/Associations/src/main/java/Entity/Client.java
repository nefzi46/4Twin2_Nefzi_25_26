package Entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "T_Client")
public class Client implements Serializable {  // 1. Ajout de "implements Serializable"

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 2. Correction orthographique
    @Column(name = "CLIENT_ID")
    private Long idClient;  // 3. Correction de "Private" en "private"

    @Column(name = "CLIENT_IDENTIFIANTr")  // 4. Correction du nom de colonne
    private String identifiant;

    @Column(name = "CLIENT_DATEPREMIEREVISITE")  // 5. Correction du nom
    @Temporal(TemporalType.DATE)  // 6. Ajout pour gérer les dates
    private Date datePremiereVisite;  // 7. Correction du type et nom

    @OneToMany(cascade = CascadeType.ALL)  // 8. Correction de "OnetoMany" en "OneToMany"
    private Set<Commande> commandes;  // 9. Correction du nom et type

    // 10. Ajout des constructeurs
    public Client() {
        // Constructeur par défaut obligatoire pour JPA
    }

    public Client(String identifiant, Date datePremiereVisite) {
        this.identifiant = identifiant;
        this.datePremiereVisite = datePremiereVisite;
    }
    // 11. Ajout des getters et setters
    public Long getId() {return idClient;}
    public void setId(Long id) {this.idClient = id;}
    public String getIdentifiant() {return identifiant;}
    public void setIdentifiant(String identifiant) {this.identifiant = identifiant;}
    public Date getDatePremiereVisite() {return datePremiereVisite;}
    public void setDatePremiereVisite(Date datePremiereVisite) {this.datePremiereVisite = datePremiereVisite;}
    public Set<Commande> getCommandes() {return commandes;}
    public void setCommandes(Set<Commande> commandes) {this.commandes = commandes;}
}