package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employe implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String nom;
	String prenom;
	@Temporal(TemporalType.DATE)
	Date dateNaissance;
	@Enumerated(EnumType.STRING)
	Sexe sexe;

	//***************Associations**************
	@OneToOne
	Contrat contrat;
	

}