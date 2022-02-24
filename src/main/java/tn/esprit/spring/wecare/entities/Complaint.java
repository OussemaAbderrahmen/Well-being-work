package tn.esprit.spring.wecare.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Complaint {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ComplaintId;
	private Date ComplaintDate;
	private String ComplaintImage;
	private String ComplaintDescription;
	@Enumerated(EnumType.STRING)
	private Type ComplaintType;
	
	@ManyToOne
	User user; 
	
}
