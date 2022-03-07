package tn.esprit.spring.wecare.entities;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

 @ManyToMany(cascade = CascadeType.ALL, mappedBy="activities")
 public List<Event> events; 
  
  @ManyToMany
 public List<User> user; 
  
  @ManyToMany
 public List<Favoris> favoris; 
  
}
