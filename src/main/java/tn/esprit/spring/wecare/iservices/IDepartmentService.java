package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Departement;

public interface IDepartmentService {
   public Departement createDepartement(Departement d);
   public Departement updateDepartement(Departement d,Long id);
   public List<Departement> getAllDepartement();
   public void deleteDepartement(Long id);
}
