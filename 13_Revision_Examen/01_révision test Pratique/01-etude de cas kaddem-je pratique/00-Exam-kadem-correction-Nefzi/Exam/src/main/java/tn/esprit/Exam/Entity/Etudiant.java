package tn.esprit.Exam.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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



public class Etudiant implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idEtudiant;
	String prenomE;
	String nomE;
	@Enumerated(EnumType.STRING)
	Option option;

	// en tant que participant
	@JsonIgnore
	@OneToMany(mappedBy="etudiant")
	private List<Contrat> contrats;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Departement departement;

	@JsonIgnore
	@ManyToMany ( cascade = CascadeType.ALL)
	private List<Equipe> equipes;

}
