package tn.esprit.spring.wecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Collaboration;

@Repository
public interface CollaborationRepository extends JpaRepository<Collaboration, Long>{

}
