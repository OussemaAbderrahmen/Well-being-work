package tn.esprit.spring.wecare.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.DuplicateComplainers;
import tn.esprit.spring.wecare.entities.MostComplainer;
import tn.esprit.spring.wecare.entities.statComplaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	
	@Query(value="select users.first_name ,count(complaint.user_user_id) occ from complaint complaint"
			+ " left join user users on complaint.user_user_id =users.user_id"
			+ " group by complaint.user_user_id"
			+ " Order by occ"
			+ " DESC ",nativeQuery=true)
	
	public List<MostComplainer> mostComplainer();
	
	
	@Query(value="select count(complaint_id) as NbrType , complaint_Type from complaint "
			+ " where complaint_type='Others'"
			+ " Union"
			+ " select count(complaint_id) as NbrType ,complaint_Type from complaint "
			+ " where   complaint_type='Technical'"
			+ " union "
			+ "select count(complaint_id) as NbrType ,complaint_Type "
			+ "from complaint "
			+ " where   complaint_type='Social' ",nativeQuery=true)
	public Set<statComplaint> getStatComplaint(); 
	
//Règle de gestion pour avoir des utilisateur des employe satisait :(doublon de reclam ) on veut minimiser les reclamation de nos employe:

	@Query(value="select distinct users.email , count(cmp.complaint_id) as doublon from user users left join complaint cmp on users.user_id=cmp.user_user_id group by (cmp.complaint_id) ",nativeQuery=true)
	public List<DuplicateComplainers> getDuplicateComplainers();
}
