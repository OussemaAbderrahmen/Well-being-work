package tn.esprit.spring.wecare.entities;


import java.sql.Time;
import java.sql.Timestamp;
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
import javax.persistence.ManyToMany;
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
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long UserId;
	
	private String email;
	private String FirstName;
	private String LastName;
	private int NbPoints;
	private String Password;
	private String UserName;
	
	@Column(name="verification_code",length=64)
	private String verfication_code;

	private Date BirthDate;
	private boolean Locked;
	private boolean Enabled;
	private boolean Deleted;
	private Timestamp CreatedAt;
	private Timestamp ModifiedAt;
	private Timestamp DeletedAt;
	private String Image;
	@Enumerated(EnumType.STRING)
	private Role Role;
	
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
	public List<Complaint> complaints ;
	
	@ManyToOne
	Departement departement; 

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Offer> offers ;
	
	
	
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


