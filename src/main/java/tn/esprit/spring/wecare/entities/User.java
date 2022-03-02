package tn.esprit.spring.wecare.entities;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long UserId;
	
	private String email;
	private String FirstName;
	private String LastName;
	private int NbPoints;
	private String Password;
	private Date BirthDate;
	private boolean Locked;
	private boolean Enabled;
	private boolean Deleted;
	private Timestamp CreatedAt;
	private Timestamp ModifiedAt;
	private Timestamp DeletedAt;
	private String Image;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Posts> posts; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Quizz> quizz; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Promotions> promotions; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Publication> publications ; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Collaboration> collaborations ; 
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	public List<Complaint> complaints ;
	
	@ManyToOne
	@JsonIgnore
	Departement departement; 

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Offer> offers ;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="users")
	public List<Role> roles ;
	
	@OneToMany (cascade = CascadeType.ALL, mappedBy="user")
	public List<Donation> donations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Notification> notifications;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Invitation> invitations ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Participationevent> participationevents ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Dates> dates;

	

	
}


