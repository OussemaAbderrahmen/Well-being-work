package tn.esprit.spring.wecare.entities;



import javax.persistence.Entity;
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
