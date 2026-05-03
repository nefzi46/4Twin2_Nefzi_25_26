package tn.esprit.exam.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Chaine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chId;

    private String chNom;

    @Enumerated(EnumType.STRING)
    private Thematique chTheme;


}
