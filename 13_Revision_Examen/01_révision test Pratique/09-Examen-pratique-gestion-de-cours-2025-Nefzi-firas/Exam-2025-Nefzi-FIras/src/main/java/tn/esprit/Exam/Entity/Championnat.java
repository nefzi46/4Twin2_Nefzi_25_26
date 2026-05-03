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



public class Championnat implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idChampionnat;
	String libelleC;
	Integer annee;

	@Enumerated(EnumType.STRING)
	Categorie categorie;

	//

}



