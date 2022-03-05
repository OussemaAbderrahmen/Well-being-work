package tn.esprit.spring.wecare.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Dates {
	@Id
	@GeneratedValue 
	private Long DatesId;
	
	private java.util.Date Datesend;
	private java.util.Date Daterecieve;
	
	@ManyToOne
	User user;
	@ManyToOne
	Messages message;

}
