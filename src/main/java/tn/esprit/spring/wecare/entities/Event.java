package tn.esprit.spring.wecare.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	Participationevent participationevent;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="event")
	public List<Activityevent> activityevents; 

}
