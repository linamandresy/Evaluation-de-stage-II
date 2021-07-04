package com.lina.model.label;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import com.lina.model.Employe;
import com.lina.model.dao.DBConnect;

public class EmployeLabel extends Employe {
	private String categorie;

	public EmployeLabel(){}
	public EmployeLabel(int idEmploye, String nom, String prenom, String matricule, Date naissance, Date embauche,
	Date finContrat, int idCategorie,String categorie){
		super(idEmploye, nom, prenom, matricule, naissance, embauche, finContrat, idCategorie);
		this.categorie=categorie;
	} 
	public String getCategorie() {
		return categorie;
	}

	public static LinkedList<EmployeLabel> find(Connection c)throws Exception{
		String sql="SELECT idemploye,nom,prenom,matricule,naissance,embauche,fincontrat,employe.idCategorie,categorie.nomcategorie FROM EMPLOYE join categorie on employe.idcategorie=categorie.idcategorie";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = null;
		try{
			rs = pst.executeQuery();
			LinkedList<EmployeLabel> result = new LinkedList<EmployeLabel>();
			while(rs.next())
				result.add(new EmployeLabel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getDate(7),rs.getInt(8),rs.getString(9)));
			return result;
		}catch(Exception ex){
			throw ex;
		}finally{
			if(rs!=null) rs.close();
		}
	}
	public static LinkedList<EmployeLabel> find()throws Exception{
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
