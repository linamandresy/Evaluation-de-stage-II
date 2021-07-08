package com.lina.model.label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.lina.model.dao.DBConnect;

public class EtatStatistique {
	private LinkedList<FichePaie> fichePaies;
	public LinkedList<FichePaie> getFichePaies() {
		return fichePaies;
	}
	private EtatStatistique(){}
	public double getSommeHeureJour(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getNbHeureJour();
		return result;
	}
	public double getSommeHeureNuit(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getNbHeureNuit();
		return result;
	}
	public double getSommeHeureDimanche(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getNbHeureDimanche();
		return result;
	}
	public double getSommeHeureFT(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getNbHeureFT();
		return result;
	}
	public double getSommeHeureF(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getNbHeureF();
		return result;
	}
	public double getSommeHeureSup30(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getNbHeureSup30();
		return result;
	}
	public double getSommeHeureSup50(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getNbHeureSup50();
		return result;
	}
	public double getSommeMontantJour(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getMontantJour();
		return result;
	}
	public double getSommeMontantNuit(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getMontantNuit();
		return result;
	}
	public double getSommeMontantDimanche(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getMontantDimanche();
		return result;
	}
	public double getSommeMontantHFT(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getMontantHFT();
		return result;
	}
	public double getSommeMontantF(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getMontantF();
		return result;
	}
	public double getSommeMontantHS30(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getMontantHS30();
		return result;
	}
	public double getSommeMontantHS50(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getMontantHS50();
		return result;
	}
	public double getSommeVraiTotal(){
		double result = 0;
		for(int i=0;i<fichePaies.size();i++)
			result+=fichePaies.get(i).getVraiTotal();
		return result;
	}
	public static EtatStatistique get(Connection c)throws Exception{
		String sql = "SELECT IDEMPLOYE FROM EMPLOYE";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = null;
		LinkedList<Integer> ids=new LinkedList<>();
		try {
			rs=pst.executeQuery();
			while(rs.next()) ids.add(rs.getInt(1));
		} catch (Exception e) {
			throw e;
		}finally{
			if(rs!=null) rs.close();
		}
		LinkedList<FichePaie> tempResult=new LinkedList<FichePaie>();
		for(int i=0;i<ids.size();i++)
			tempResult.add(FichePaie.findById(c, ids.get(i).intValue()));
		EtatStatistique result = new EtatStatistique();
		result.fichePaies=tempResult;
		return result;
	} 
	public static EtatStatistique get()throws Exception{
		Connection c = null;
		try{
			c = DBConnect.getDAO().connect();
			return get(c);
		} catch(Exception ex){
			throw ex;
		}finally{
			if(c!=null) c.close();
		}
	}
}
