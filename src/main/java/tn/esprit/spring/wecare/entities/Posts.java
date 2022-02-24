package tn.esprit.spring.wecare.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Posts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long PostId;
	
	private String TitlePost;
	private int NbReact;
	private int NbComment;
	private LocalDateTime DatePost;
	private String ImagePost;
	public Posts(String titlePost, int nbReact, int nbComment, String imagePost) {
		super();
		TitlePost = titlePost;
		NbReact = nbReact;
		NbComment = nbComment;
		ImagePost = imagePost;
	}
	
	
	@ManyToOne
	User user; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="posts")
	@JsonIgnore
	public List<CommentPost> commentposts ; 
	
}
