package tn.esprit.spring.wecare.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/monitor")
public class GrafanaController {

	@GetMapping("/monitor")
	public String monitor(){
		try{
			boolean condition = true;
			while(condition){
				Runnable r = () ->{
					while(true){
						
					}
				};
				new Thread(r).start();
				Thread.sleep(5000);}
		}catch(Exception e){}
		return "cpo dead";
	}
}
