package com.lina.controller;

import com.lina.service.CategorieService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("categorie")
@CrossOrigin(origins = "*")
public class CategorieController {
	@PostMapping(value = "")
	public Response postCategorie(@RequestHeader(name = "Authorization") String token, String nomCategorie,
			double nbHeureN, double salaireHN, double indamnite) throws Exception {
		return CategorieService.insertCategorie(token, nomCategorie, nbHeureN, salaireHN, indamnite);
	}
	@GetMapping(value="")
	public Response getCategorie()throws Exception {
		return CategorieService.listCategorie();
	}
	@GetMapping(value="/{id}")
	public Response getCategorieById(@PathVariable int id)throws Exception {
		return CategorieService.findById(id);
	}
	@PutMapping(value="/{id}")
	public Response putCategorie(@RequestHeader(name="Authorization") String token ,@PathVariable int id ,String nomCategorie, double nbHeureN, double salaireHN, double indamnite) throws Exception{
		return CategorieService.updateCategorie(token, id, nomCategorie, nbHeureN, salaireHN, indamnite);
	}
}
