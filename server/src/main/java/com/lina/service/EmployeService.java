package com.lina.service;

import com.lina.model.label.EmployeLabel;

public class EmployeService {
	public static Response getListEmploye()throws Exception{
		try{
			return new Response(200,EmployeLabel.find());
		}catch(Exception ex){
			return new Response(400,ex.getMessage());
		}
	}
}
