package tn.esprit.spring.wecare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.iservices.FavorisIService;

@RestController
@RequestMapping("/favoris")
public class FavorisRestController {
	@Autowired
	FavorisIService favorisIService;

	// http://localhost:8089/wecare/favoris/add-favoris-act/{idActivity}/{idFavoris}/{idUser}
	@ResponseBody
	@PostMapping("/add-favoris-act/{idActivity}/{idFavoris}/{idUser}")
	public void addFavorisActivity(long idActivity, long idFavoris, long idUser) {
		favorisIService.addFavorisActivity(idActivity, idFavoris, idUser);
	}
	

}
