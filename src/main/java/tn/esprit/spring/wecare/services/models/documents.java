package tn.esprit.spring.wecare.services.models;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class documents {

	private String id;
	private String sentiment;
	private List<Object> sentences;
	private List<Object> warnings;	
	private confidenceScores confidenceScores;
	
}
