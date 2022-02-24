package tn.esprit.spring.wecare.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	


	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private long Roleid;


	    private String name;

	    private String description;
	    
	    
	    @ManyToMany
	    public List<User> users;

}
