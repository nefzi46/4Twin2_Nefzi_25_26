package tn.esprit.Exam.Entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContrat;
    @Temporal(TemporalType.DATE)
    Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    Boolean archive;

    @ManyToOne
    Etudiant etudiant;

}
