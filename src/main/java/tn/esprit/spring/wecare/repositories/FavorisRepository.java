package tn.esprit.spring.wecare.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Favoris;

@Repository
public interface FavorisRepository extends CrudRepository<Favoris, Long> {

}
