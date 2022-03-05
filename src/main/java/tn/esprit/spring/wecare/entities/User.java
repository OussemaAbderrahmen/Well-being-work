package tn.esprit.spring.wecare.entities;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
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
public class User {
	@Id
	@GeneratedValue 
	private Long UserId;
	
	private String email;
	private String FirstName;
	private String LastName;
	private int NbPoints;
	private String Password;
	private Date BirthDate;
	private boolean Locked;
	private String Image;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<Posts> posts; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<Quizz> quizz; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<Promotions> promotions; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	public List<Publication> publications ; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	public List<PublicationComments>  Pubcomments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<Collaboration> collaborations ; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<Complaint> complaints ;
	
	@ManyToOne
	 @JsonIgnore
	Departement departement; 

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<Offer> offers ;
	

	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List <Donation> donations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<Notification> notifications;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<Invitation> invitations ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<Participationevent> participationevents ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	 @JsonIgnore
	public List<tn.esprit.spring.wecare.entities.Dates> dates;
	

	
	@Enumerated(EnumType.STRING)
	private Role Role;
	
}


