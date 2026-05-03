package tn.esprit.exam.entity;

import lombok.*;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Programme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prId;

    private String prNom;

    @ManyToMany(mappedBy = "programmes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    private Set<Utilisateur> utilisateurs;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Chaine chaine;

}
