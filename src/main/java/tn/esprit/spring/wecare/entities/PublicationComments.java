package tn.esprit.spring.wecare.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
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
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class PublicationComments {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long CommentId;
	
	private String Comment;
	private Date CommentDate;

	private String CommentImage;
	
	
	 @ManyToMany
	 @JsonIgnore
	    Set<User> Likes ; 
	 @ManyToMany
	 @JsonIgnore
	 Set<User > Dislikes;
	
	@ManyToOne
	@JsonIgnore
	Publication publication;
	
	@ManyToOne
	User user;
	
	@ManyToOne
	@JsonIgnore
	Dictionary Dictionary;
	
}
