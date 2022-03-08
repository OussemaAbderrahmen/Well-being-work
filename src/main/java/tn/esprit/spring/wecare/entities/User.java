package tn.esprit.spring.wecare.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
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
@ToString
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private Boolean active;
	private Boolean locked;
	private boolean deleted;	
	private String image;
	private int warningNum;
	private int nbconnexion;
	private Date SendWarningDate;
	private String Role;
	

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
	Departement Departement; 

	
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
	
}


