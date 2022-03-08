package tn.esprit.spring.wecare.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long DepartementId;
	private String DepartementName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Departement")
	@JsonIgnore
	public List<User> Users;
	
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="Departements")
	@JsonIgnore
	public List<Posts> Posts;

}
