package tn.esprit.examen.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldDefaults;
import tn.esprit.examen.entities.Option;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEtudiant;
    private String prenomE;
    private String nomE;

    @Enumerated(EnumType.STRING)
    private Option option;
    @JsonIgnore
    @OneToMany(mappedBy ="etudiant")
    Set<Contrat> contrats;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Departement departement;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnore
    Set<Equipe> equipes;





}

