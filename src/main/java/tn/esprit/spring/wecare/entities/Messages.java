package tn.esprit.spring.wecare.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Messages {
	
	
	@Id
	@GeneratedValue 
	private Long MesageId;
	private String Message;
	private Boolean status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="message")
	public List<tn.esprit.spring.wecare.entities.Dates> dates;

}
