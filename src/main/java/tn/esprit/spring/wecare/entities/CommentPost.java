package tn.esprit.spring.wecare.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentPost {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long CommId;
	private String Comment;
	private Date CommentDate;
	
	

	
	public CommentPost(String comment, Date commentDate) {
		super();
		Comment = comment;
		CommentDate = commentDate;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private Posts posts; 
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private User user;
	
	
	@ManyToMany
	@JsonIgnore
	Set<User> userCommentLikes;
	
	@ManyToMany
	@JsonIgnore
	Set<User> userCommentDislikes;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "Response",cascade = CascadeType.ALL)

	private Set<CommentPost> CommentResponses;
	
	@ManyToOne
	@JsonIgnore
	private CommentPost Response;

}
