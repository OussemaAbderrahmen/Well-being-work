package tn.esprit.spring.wecare.entities;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import lombok.ToString;
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
private Long userId;
	
	private String email;
	private String firstName;
	private String lastName; 
	private int nbPoints;
	private String password;
	private String userName;
	private Date birthDate;
	private boolean active;
	private boolean locked;
	private boolean enabled;
	private boolean deleted;
	//private Timestamp createdAt;
	//private Timestamp modifiedAt;
	//private Timestamp deletedAt;
	private String image;
	private int warningNum;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch= FetchType.EAGER)
	private Set<Role> roles;
	
	
	
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


	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Offer> offers ;
	
	
	@JsonIgnore
	@OneToMany (cascade = CascadeType.ALL, mappedBy="user")
	public List<Donation> donations;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Notification> notifications;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Invitation> invitations ;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	public List<Dates> dates;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	public Departement Departement;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	public List<Posts> posts; 
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	public List<CommentPost> userComments;
}


