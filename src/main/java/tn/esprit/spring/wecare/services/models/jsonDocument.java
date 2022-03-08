package tn.esprit.spring.wecare.services.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class jsonDocument {
	
	private List<documents> documents;
	private List<Object> errors;
	private String modelVersion;
}
