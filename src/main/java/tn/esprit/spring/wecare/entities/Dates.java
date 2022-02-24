package tn.esprit.spring.wecare.entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long DatesId;
	
	private Date Datesend;
	private Date Daterecieve;
	
	@ManyToOne
	User user;
	@ManyToOne
	Messages message;

}
