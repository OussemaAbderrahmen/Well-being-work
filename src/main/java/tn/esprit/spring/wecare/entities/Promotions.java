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

@AllArgsConstructor
@NoArgsConstructor
public class Promotions {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long PromotionId;
	private int UserReact;
	
	
	
	
	@ManyToOne
	User user;
	

}
