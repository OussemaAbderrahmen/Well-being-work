package tn.esprit.spring.wecare.entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
public class Publication {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long PublicationId;
	private String PublicationTitle;
	private String PublicationDescription;
    private Date PublicationDate;
    private int Likes;
    private int Dislikes;
    private int NbViews;
    private String Image;
    
    @ManyToOne
    User user; 
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy="publication")
	public List<PublicationComments> publicationcomments ; 
    
}
