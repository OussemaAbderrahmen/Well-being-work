package tn.esprit.spring.wecare.entities;

import java.time.LocalDateTime;
import java.util.List;
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
public class Posts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long PostId;
	private String TitlePost;
	private String DescriptionPost;
	private int NbComment;
	private LocalDateTime DatePost;
	private String ImagePost;
	
	

	
	

	public Posts(String titlePost, String descriptionPost, LocalDateTime datePost, String imagePost) {
		super();
		TitlePost = titlePost;
		DescriptionPost = descriptionPost;
		DatePost = datePost;
		ImagePost = imagePost;
	}

	@ManyToOne(cascade=CascadeType.ALL)
    @JsonIgnore
	private User user; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="posts")
	@JsonIgnore
	public List<CommentPost> commentposts ; 
	
	@ManyToMany(cascade=CascadeType.ALL)
	public List<Departement> Departements;
	
	@ManyToMany
	@JsonIgnore
	Set<User> userLikes;
	
	@ManyToMany
	@JsonIgnore
	Set<User> userDislikes;

	
}
