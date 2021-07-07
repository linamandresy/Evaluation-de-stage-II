package com.lina.model.label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.lina.model.HeureSup;
import com.lina.model.dao.DBConnect;

public class FicheHorraire {
	private int idEmploye;
	private double nbHeureJour;
	private double nbHeureNuit;
	private double nbHeureDimanche;
	private double nbHeureFT;
	private double nbHeureF;
	private double nbHeureSup30;
	private double nBHeureSup50;
	private double hs;
	private List<HeureSup> heureSup;

	public List<HeureSup> getHeureSup() {
		return heureSup;
	}

	public FicheHorraire() {
	}

	public FicheHorraire(int idEmploye, double nbHeureJour, double nbHeureNuit, double nbHeureDimanche,
			double nbHeureFT, double nbHeureF, double hs, List<HeureSup> heuresup) {
		this.heureSup = heuresup;
		this.setIdEmploye(idEmploye);
		this.setNbHeureJour(nbHeureJour);
		this.setNbHeureNuit(nbHeureNuit);
		this.setNbHeureDimanche(nbHeureDimanche);
		this.setNbHeureFT(nbHeureFT);
		this.setNbHeureF(nbHeureF);
		this.setHs(hs);
	}

	public void setHeureSup(List<HeureSup> heureSup) {
		this.heureSup = heureSup;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public double getNbHeureDimanche() {
		return nbHeureDimanche;
	}

	public double getNbHeureF() {
		return nbHeureF;
	}

	public double getNbHeureFT() {
		return nbHeureFT;
	}

	public double getNbHeureJour() {
		return nbHeureJour;
	}

	public double getNbHeureNuit() {
		return nbHeureNuit;
	}

	public double getNbHeureSup30() {
		return nbHeureSup30;
	}

	public double getnBHeureSup50() {
		return nBHeureSup50;
	}

	public void setNbHeureDimanche(double nbHeureDimanche) {
		this.nbHeureDimanche = nbHeureDimanche;
	}

	public void setNbHeureF(double nbHeureF) {
		this.nbHeureF = nbHeureF;
	}

	public void setNbHeureFT(double nbHeureFT) {
		this.nbHeureFT = nbHeureFT;
	}

	public void setNbHeureJour(double nbHeureJour) {
		this.nbHeureJour = nbHeureJour;
	}

	public void setNbHeureNuit(double nbHeureNuit) {
		this.nbHeureNuit = nbHeureNuit;
	}

	public void setHs(double hs) {
		this.hs = hs;
		if (heureSup.get(1).getNbHeure() > hs) {
			nbHeureSup30 = hs;
			hs = 0;
		} else {
			nbHeureSup30=heureSup.get(1).getNbHeure();
			System.out.println(nbHeureSup30);
			hs -= heureSup.get(1).getNbHeure();
			if (heureSup.get(0).getNbHeure() > hs) {
				nBHeureSup50 = hs;
			} else {
				nBHeureSup50 = heureSup.get(0).getNbHeure();
			}
		}
	}

	public static List<FicheHorraire> find(Connection c) throws Exception {
		List<HeureSup> heureSups = DBConnect.getDAO().find(c, HeureSup.class);
		String sql = "SELECT * FROM V_HORRAIRE";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
			List<FicheHorraire> result = new LinkedList<FicheHorraire>();
			while (rs.next())
				result.add(new FicheHorraire(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4),
						rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), heureSups));
			return result;
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (rs != null)
				rs.close();
		}
	}

	public static List<FicheHorraire> find() throws Exception {
		Connection c = null;
		try {
			c = DBConnect.getDAO().connect();
			return find(c);
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (c != null)
				c.close();
		}
	}

	public static FicheHorraire findById(Connection c, int id) throws Exception {
		List<HeureSup> heureSups = DBConnect.getDAO().find(c, HeureSup.class);
		String sql = "SELECT * FROM V_HORRAIRE WHERE IDEMPLOYE=?";
		PreparedStatement pst = c.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = null;
		try {
			rs = pst.executeQuery();
			if (rs.next())
				return new FicheHorraire(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4),
						rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), heureSups);
			throw new Exception("Employée inexistant");
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (rs != null)
				rs.close();
		}
	}

	public static FicheHorraire findById(int id) throws Exception {
		Connection c = null;
		try {
			c = DBConnect.getDAO().connect();
			return findById(c, id);
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (c != null)
				c.close();
		}
	}
}
