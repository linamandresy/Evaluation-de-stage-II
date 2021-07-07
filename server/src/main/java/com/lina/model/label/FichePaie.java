package com.lina.model.label;

import java.sql.Connection;
import java.util.List;

import com.lina.model.Categorie;
import com.lina.model.HeureSup;
import com.lina.model.Majoration;
import com.lina.model.dao.DBConnect;
import com.lina.service.HeureSupService;

public class FichePaie extends FicheHorraire {
	private EmployeLabel employe;
	private Categorie categorie;
	private List<Majoration> majorations;

	public EmployeLabel getEmploye() {
		return employe;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public List<Majoration> getMajorations() {
		return majorations;
	}

	public void setEmploye(EmployeLabel employe) {
		this.employe = employe;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setMajorations(List<Majoration> majorations) {
		this.majorations = majorations;
	}
	public double getSalaireUnitaire(){
		System.out.println(categorie.getSalaireHN());
		return categorie.getSalaireHN()/categorie.getNbHeureN();
	}
	public double getTauxHJour(){
		return getSalaireUnitaire()*majorations.get(3).getPourcentage()/100;
	}
	public double getMontantJour(){
		return getTauxHJour()*getNbHeureJour();
	}
	public double getTauxHNuit(){
		return getSalaireUnitaire()*majorations.get(0).getPourcentage()/100;
	}
	public double getMontantNuit(){
		return getTauxHNuit()*getNbHeureNuit();
	}
	public double getTauxHDimanche(){
		return getSalaireUnitaire()*majorations.get(1).getPourcentage()/100;
	}
	public double getMontantDimanche(){
		return getTauxHDimanche()*getNbHeureDimanche();
	}
	public double getTauxHFT(){
		return getSalaireUnitaire()*majorations.get(2).getPourcentage()/100;
	}
	public double getMontantHFT(){
		return getTauxHFT()*getNbHeureFT();
	}
	public double getTauxHF(){
		return getSalaireUnitaire()*majorations.get(3).getPourcentage()/100;
	}
	public double getMontantF(){
		return getTauxHF()*getNbHeureF();
	}
	public double getTauxHS30(){
		return getSalaireUnitaire()*(getHeureSup().get(1).getPourcentage()-100)/100;
	}
	public double getMontantHS30(){
		return getTauxHS30()*getNbHeureSup30();
	}
	public double getTauxHS50(){
		return getSalaireUnitaire()*(getHeureSup().get(0).getPourcentage()-100)/100;
	}
	public double getMontantHS50(){
		return getTauxHS50()*getnBHeureSup50();
	}

	public double getIndemnite(){
		return categorie.getSalaireHN()*28/100;
	}
	public double getTotalPayer(){
		return getMontantDimanche()+getMontantF()+getMontantHS30()+getMontantHS50()+getMontantJour()+getMontantNuit()+getMontantHFT();
	}
	public double getVraiTotal(){
		return getTotalPayer()+getIndemnite();
	}
	public FichePaie(EmployeLabel employe, Categorie categorie, List<Majoration> majorations, int idEmploye,
			double nbHeureJour, double nbHeureNuit, double nbHeureDimanche, double nbHeureFT, double nbHeureF,
			double hs, List<HeureSup> heuresup) {
		super(idEmploye, nbHeureJour, nbHeureNuit, nbHeureDimanche, nbHeureFT, nbHeureF, hs, heuresup);
		this.setEmploye(employe);
		this.setCategorie(categorie);
		this.setMajorations(majorations);
	}

	public FichePaie() {
	}

	public static FichePaie findById(Connection c, int id) throws Exception {
		FicheHorraire fh = FicheHorraire.findById(c, id);
		EmployeLabel emp = EmployeLabel.findById(c, id);
		Categorie cat = (Categorie) DBConnect.getDAO().findById(c, Categorie.class, emp.getIdCategorie());
		List<Majoration> maj = (List<Majoration>) DBConnect.getDAO().find(Majoration.class);
		FichePaie fiche = new FichePaie(emp, cat, maj, id, fh.getNbHeureJour(), fh.getNbHeureNuit(), fh.getNbHeureDimanche(), fh.getNbHeureFT(), fh.getNbHeureF(),fh.getNbHeureSup30()+fh.getnBHeureSup50(), fh.getHeureSup()); 
		return fiche;
	}

	public static FichePaie findById(int id) throws Exception {
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
