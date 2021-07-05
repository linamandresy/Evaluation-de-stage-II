package com.lina.controller;

import com.lina.service.HeureSupService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("heuresup")
public class HeureSupController {
	@GetMapping(value="")
	public Response getHS() {
		return HeureSupService.getHeureSup();
	}
	@PostMapping(value="")
	public Response postHS(@RequestHeader(name="Authorization") String token,String nomHS,int nbHeure, int idHSPrec,double pourcentage) throws Exception{
		return HeureSupService.insertHeureSup(token, nomHS, nbHeure, idHSPrec,pourcentage);
	}
	@GetMapping(value="/{id}")
	public Response getHS(@PathVariable int id){
		return HeureSupService.findHeureSupById(id);
	}		
	@PutMapping(value="/{id}")
	public Response putMethodName(@RequestHeader(name="Authorization")String token,@PathVariable int id,String nomHS, int nbHeure, int idHSPrec, double pourcentage) throws Exception{
		return HeureSupService.updateHeureSup(token, id, nomHS, nbHeure, idHSPrec, pourcentage);
	}
}
