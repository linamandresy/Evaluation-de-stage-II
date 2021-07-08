package com.lina.controller;

import java.text.*;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.lina.helper.FichePaiePDFExporter;
import com.lina.model.dao.DBConnect;
import com.lina.model.label.FichePaie;
import com.lina.service.FichePaieService;
import com.lina.service.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("fichepaie")
@CrossOrigin(origins="*")
public class FichePaieController {
	@GetMapping(value="/{id}")
	public Response getFiche(@PathVariable int id) throws Exception{
		return FichePaieService.findById(id);
	}
	@GetMapping(value="pdf/{id}")
	public void putMethodName(@PathVariable int id, HttpServletResponse response) throws Exception{
		FichePaie fiche = FichePaie.findById(id);
		FichePaiePDFExporter pdf = new FichePaiePDFExporter(fiche);
		response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date(System.currentTimeMillis()));
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=fiche_paie_"+fiche.getEmploye().getNom()+"_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
         
        pdf.export(response);
	}
}
