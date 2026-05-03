package tn.esprit.Exam.Entity;
import java.io.Serializable;

import javax.persistence.*;

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

public class Departement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idDepart;
	String nomDepart;

	@Enumerated(EnumType.STRING)
	Specialite specialite;

}
