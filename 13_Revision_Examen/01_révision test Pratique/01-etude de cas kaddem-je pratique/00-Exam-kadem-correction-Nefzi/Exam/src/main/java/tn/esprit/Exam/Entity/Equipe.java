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

public class Equipe implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idEquipe;
	String nomEquipe;
	@Enumerated(EnumType.STRING)
	Niveau niveau;

	@JsonIgnore
	@ManyToMany(mappedBy = "departement", cascade = CascadeType.ALL)
	private List<Etudiant> etudiants;

	@OneToOne(mappedBy = "equipe")
	Equipe equipe;



}
