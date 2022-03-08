package tn.esprit.spring.wecare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Connection;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {

}
