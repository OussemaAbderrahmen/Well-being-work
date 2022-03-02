package tn.esprit.spring.wecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Departement;
@Repository
public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
