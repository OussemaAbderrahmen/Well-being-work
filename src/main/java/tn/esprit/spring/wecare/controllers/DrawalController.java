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
import tn.esprit.spring.wecare.entities.WithDrawal;
import tn.esprit.spring.wecare.services.DrawalServiceImpl;

@RestController
@RequestMapping("/drawal")
public class DrawalController {
	@Autowired
	DrawalServiceImpl dserv;

	// http://localhost:8089/wecare/drawal/add-drawal/1
	@PostMapping("/add-drawal/{idCagnotte}")
	public String addDrawal(@RequestBody WithDrawal u, @PathVariable("idCagnotte") Long idCagnotte) {
		return dserv.addDrawal(u, idCagnotte);
	}

	// http://localhost:8089/wecare/drawal/update-drawal
	@PutMapping("/update-drawal")
	public String updateDrawal(@RequestBody WithDrawal u) {
		dserv.UpdateDrawal(u);
		return "With Drawal was updated successfuly ";
	}

	// http://localhost:8089/wecare/drawal/get-all-drawals
	@GetMapping("/get-all-drawals")
	public List<WithDrawal> getAll() {
		List<WithDrawal> listDrawal = dserv.ListDrawal();
		return listDrawal;
	}

	// http://localhost:8089/wecare/drawal/delete-drawal/2
	@DeleteMapping("/delete-drawal/{drawal-id}")
	public String deleteDrawal(@PathVariable("drawal-id") Long id) {
		dserv.deleteDrawal(id);
		return "With Drawal was deleted !";
	}

}

