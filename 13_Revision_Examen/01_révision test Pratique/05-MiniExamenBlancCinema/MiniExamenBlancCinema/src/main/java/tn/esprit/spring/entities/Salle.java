package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
public class Salle implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String nom;
	int capacite;
	
	//***************Associations**************
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Cinema cinema;
	
	@JsonIgnore
	@ManyToMany
	List<Film> films;
}
