package tn.esprit.spring.wecare.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long NotificationId;
	private String TitleNotification;
	private Date DateDeNotification;
	private String Description;
	private String UserNotif;
	private Boolean Etat;
	
	
	
	
	
	
	
	
	@ManyToOne
	User user;
	

}
