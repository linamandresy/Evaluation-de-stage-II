package com.lina.controller;

import java.sql.Date;

import com.lina.service.EmployeService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins="*")
@RequestMapping("employe")
public class EmployeController {
	
	@GetMapping(value="")
	public Response getListEmploye() throws Exception{
		return EmployeService.getListEmploye();
	}
	@PostMapping(value="")
	public Response postEmploye(@RequestHeader(name="Authorization") String token,String nom, String prenom,  Date naissance, Date embauche,String finContrat, int idCategorie) throws Exception{
		return EmployeService.insertEmploye(token, nom, prenom, naissance, embauche, finContrat, idCategorie);
	}
	@GetMapping(value="/{id}")
	public Response getEmploye(@PathVariable int id) throws Exception{	
		return EmployeService.findById(id);
	}
	@PutMapping(value="/{id}")
	public Response putEmploye(@RequestHeader(name="Authorization") String token,@PathVariable int id, String nom, String prenom, String matricule, Date naissance, Date embauche,String finContrat, int idCategorie) throws Exception{
		return EmployeService.updateEmploye(token, id, nom, prenom, matricule, naissance, embauche, finContrat, idCategorie);
	}
}
