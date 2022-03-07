package tn.esprit.spring.wecare.entities;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dictionary {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idWord;
	private String Word;
	
	@OneToMany
	@JsonIgnore
	public List<Posts> posts;
	
	@OneToMany
	@JsonIgnore
	public List<CommentPost> commentPosts;
	
	@OneToMany
	@JsonIgnore
	public List<Publication >publication;
	
	@OneToMany
	@JsonIgnore
	public List<PublicationComments> pubcoms;
}
