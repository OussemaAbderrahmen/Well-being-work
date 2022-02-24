package tn.esprit.spring.wecare.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Entity
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Entreprise {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long EntrepriseId;
	private String FiscalNumber;
	private String Adress;
	private int ContactNumber;
	private Date CreationDate;
	private int EmployeeNumber;
	private String Logo;
	
	@Enumerated(EnumType.STRING)
	private Domaine DomaineEntreprise;

	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="entreprise")
	public List<Collaboration> collaborations ;

}
