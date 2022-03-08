package tn.esprit.spring.wecare.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long EventId;
	private String EventName;
	private Date StartDate;
	private Date EndDate;
	private int NbPerson;
	private boolean Full;
	private int NbPlaceDisponible;
	private String Images;
	private String type;
	private int note;
	private Boolean isAccepted;
	private float price;
	private float depenses;
	private float profit;
	

	@JsonIgnore
	@ManyToMany
	public List<User> user;
	
	@JsonIgnore
	@ManyToMany
	
	public List<Activities> activities; 
	
}
