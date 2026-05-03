package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	Long id;
	String nom;
	String prenom;
	Long numTelephone;
	@Enumerated(EnumType.STRING)
	Role role;
	
	//en tant que responsable
	@OneToMany(mappedBy = "userR",fetch = FetchType.EAGER)
	List<Evenement> evenementsR= new ArrayList<Evenement>();
	
	// en tant que participant
	@ManyToMany
	Set<Evenement> evenementsP= new HashSet<Evenement>();
	
	
	
	
	

}
