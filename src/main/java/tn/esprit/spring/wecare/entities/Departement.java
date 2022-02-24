package tn.esprit.spring.wecare.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Departement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long DepartementId;
	private String DepartmentName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
	public List<User> users ; 
	
	
}
