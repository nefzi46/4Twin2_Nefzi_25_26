package tn.esprit.exam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usrId;

    private String usrNom;
    private Date usrDateInscription;

    @Enumerated(EnumType.STRING)
    private Profession profession;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    @JsonIgnore
    private Set<Programme> programmes;

}
