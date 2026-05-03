package tn.esprit.examen.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer idEquipe;
    String nomEquipe;
    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @ManyToMany(cascade = CascadeType.PERSIST)
    Set<Etudiant> etudiants;

    @OneToOne(mappedBy = "equipe",cascade =CascadeType.REMOVE)
    DetailEquipe detailEquipe;
}
