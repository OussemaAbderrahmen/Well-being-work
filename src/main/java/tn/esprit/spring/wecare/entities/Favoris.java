package tn.esprit.spring.wecare.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

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

public class Favoris {

		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long FavoriId;
		private String nomActivite;
		
		@ManyToMany(cascade = CascadeType.ALL, mappedBy="favoris")
		public List<Activities> activities;
		
		@OneToOne
		User user;
}
