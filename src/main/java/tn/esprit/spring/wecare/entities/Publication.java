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



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Publication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long PublicationId;
	private String PublicationTitle;
	private String PublicationDescription;
	 @JsonFormat(pattern="yyyy-MM-dd")
    private Date PublicationDate;
    private String Image;
    @Enumerated(EnumType.STRING)
    private Theme theme ; 
    
    @ManyToMany
    @JsonIgnore
    Set<User> Likes ; 
    
	 @ManyToMany
	 @JsonIgnore
	 Set<User > Dislikes;
    
    @ManyToOne
    @JsonIgnore
    User user; 
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy="publication")
	@JsonIgnore
	public List<PublicationComments> publicationcomments ; 
	
	@ManyToOne
	@JsonIgnore
	Dictionary Dictionary;
	
	
}
