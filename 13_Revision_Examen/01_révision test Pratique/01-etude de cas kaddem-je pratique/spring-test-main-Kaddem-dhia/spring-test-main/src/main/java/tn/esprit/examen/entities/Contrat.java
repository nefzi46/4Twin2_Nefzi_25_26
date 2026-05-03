package tn.esprit.examen.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrat;

    private Date dateDebutContrat;
    private Date dateFinContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private boolean archive;

    @ManyToOne
    private Etudiant etudiant;
}


