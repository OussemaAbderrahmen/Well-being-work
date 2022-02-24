package tn.esprit.spring.wecare.iservices;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import tn.esprit.spring.wecare.entities.Collaboration;

public interface ICollaborationService {

	public List<Collaboration> getAllCollaboration();
	public Collaboration getCollaborationById(Long id);
	public Collaboration createCollaborationAndAssignToEntreprise(Collaboration c,Long id);
	public Collaboration updateCollaboration( Collaboration c);
	public void deleteCollaboration(Long id);
}
