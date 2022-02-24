package tn.esprit.spring.wecare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.Cagnotte;
import tn.esprit.spring.wecare.services.CagnotteServiceImpl;

@RestController
@RequestMapping("/cagnotte")
public class CagnotteController {
@Autowired
CagnotteServiceImpl cagServ;

    //http://localhost:8089/wecare/cagnotte/add-cagnotte
	@PostMapping("/add-cagnotte") 
	public Cagnotte addCagnotte(@RequestBody Cagnotte cagnotte)
	 {
		
		return cagServ.addCagnotte(cagnotte);
	}
	//http://localhost:8089/wecare/cagnotte/update-cagnotte
	@PutMapping("/update-cagnotte")
	public Cagnotte updateCagnotte(@RequestBody Cagnotte cagnotte){
		
		cagServ.updateCagnotte(cagnotte);
		return cagnotte;
	}
	//http://localhost:8089/wecare/cagnotte/get-all-cagnottes
	@GetMapping("/get-all-cagnottes")
	public List<Cagnotte> getAll(){
		List<Cagnotte> listCagnotte = cagServ.getAllCagnotte();
		return listCagnotte;
	}
	
	//http://localhost:8089/wecare/cagnotte/get-cagnotte-by-id/2
	@GetMapping("/get-cagnotte-by-id/{cagnotte-id}")
	public Cagnotte getCagnotteById(@PathVariable("cagnotte-id") Long id){
		Cagnotte c= cagServ.getCagnotteById(id);
		return c;
	}
	//http://localhost:8089/wecare/cagnotte/delete-cagnotte/2
	@DeleteMapping("/delete-cagnotte/{cagnotte-id}")
	public void deleteCagnotte(@PathVariable("cagnotte-id")Long id) {
		cagServ.deleteCagnotteById(id);
	}
	
	
		
		


}
