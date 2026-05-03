package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Evenement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String libelle;
	String description;
	@Temporal(TemporalType.DATE)
	Date dateEvent;
	Long nbParticipants;

	@OneToMany(mappedBy = "evenement")
	@JsonIgnore
	List<Activite> activities = new ArrayList<Activite>();

	// en tant que responsable
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	User userR;

	// en tant que participant
	@ManyToMany(mappedBy = "evenementsP")
	@JsonIgnore
	Set<User> usersP = new HashSet<User>();

}
