package tn.esprit.spring.wecare.entities;

import java.util.Date;

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
public class Activities {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long ActivitieId;
 private String ActivitieName;
 private boolean Favorie;
 private String Image;
 
	@ManyToOne
	Activityevent activityevent;
}
