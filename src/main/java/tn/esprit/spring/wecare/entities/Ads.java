

package tn.esprit.spring.wecare.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@ToString
public class Ads {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long AdId;
	private Date AdDate;
	@Enumerated(EnumType.STRING)
	private TypeAd Type;
	private String AdDescription;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="ad")
	@JsonIgnore
	 List<Complaint> adcomplaints;
	@ManyToOne
	@JsonIgnore
	public User user; 

}
