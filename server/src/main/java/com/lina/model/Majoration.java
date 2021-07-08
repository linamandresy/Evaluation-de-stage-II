package com.lina.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.lina.model.dao.DBConnect;

public class Majoration {
	private int idMajoration;
	private String nomMaj;
	private double pourcentage;

	public Majoration(String nomMaj, double pourcentage) {
		this.nomMaj = nomMaj;
		this.pourcentage = pourcentage;
	}

	public Majoration(int idMajoration, String nomMaj, double pourcentage) {
		this.idMajoration = idMajoration;
		this.nomMaj = nomMaj;
		this.pourcentage = pourcentage;
	}

	public Majoration() {
	}

	public int getIdMajoration() {
		return idMajoration;
	}

	public String getNomMaj() {
		return nomMaj;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setIdMajoration(int idMajoration) {
		this.idMajoration = idMajoration;
	}

	public void setNomMaj(String nomMaj) {
		this.nomMaj = nomMaj;
	}

	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}
	public static LinkedList<Majoration> find(Connection c)throws Exception{
		String sql="select * from majoration order by idmajoration";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = null;
		try{
			rs = pst.executeQuery();
			LinkedList<Majoration> result=new LinkedList<>();
			while(rs.next())
				result.add(new Majoration(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			return result;

		}catch(Exception ex){
			throw ex;
		}finally{
			if(rs!=null) rs.close();
		}
	}
	public static LinkedList<Majoration> find()throws Exception{
		Connection c = null;
		try{
			c = DBConnect.getDAO().connect();
			return find(c);
		}catch(Exception ex){
			throw ex;
		}finally{
			if(c!=null) c.close();
		}
	}
}