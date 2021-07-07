package com.lina.model;

public class Pointage {
	public int idPointage;
	public int idJourSemaine;
	public int idEmploye;
	public double dureeJour;
	public double dureeNuit;
	public double dureeFerier;
	
	public Pointage(int idJourSemaine, int idEmploye, double dureeJour, double dureeNuit, double dureeFerier) throws Exception{
		this.setIdJourSemaine(idJourSemaine);
		this.setIdEmploye(idEmploye);
		this.setDureeJour(dureeJour);
		this.setDureeNuit(dureeNuit);
		this.setDureeFerier(dureeFerier);
	}
	public Pointage(int idPointage, int idJourSemaine, int idEmploye, double dureeJour, double dureeNuit,
			double dureeFerier)throws Exception {
		this.setIdPointage(idPointage);
		this.setIdJourSemaine(idJourSemaine);
		this.setIdEmploye(idEmploye);
		this.setDureeJour(dureeJour);
		this.setDureeNuit(dureeNuit);
		this.setDureeFerier(dureeFerier);
	}
	public Pointage() {
	}
	public void setIdPointage(int idPointage){
		this.idPointage=idPointage;
	}
	public void setIdJourSemaine(int idJourSemaine){
		this.idJourSemaine=idJourSemaine;
	}
	public void setIdEmploye(int idEmploye){
		this.idEmploye=idEmploye;
	}
	public void setDureeJour(double dureeJour)throws Exception{
		if(dureeJour>17)throw new Exception("Valeur impossible");
		this.dureeJour=dureeJour;
	}
	public void setDureeNuit(double dureeNuit)throws Exception{
		if(dureeNuit>7)throw new Exception("Valeur impossible");
		this.dureeNuit=dureeNuit;
	}
	public void setDureeFerier(double dureeFerier){
		this.dureeFerier=dureeFerier;
	}
	

	public int getIdPointage(){
		return this.idPointage;
	}
	public int getIdJourSemaine(){
		return this.idJourSemaine;
	}
	public int getIdEmploye(){
		return this.idEmploye;
	}
	public double getDureeJour(){
		return this.dureeJour;
	}
	public double getDureeNuit(){
		return this.dureeNuit;
	}
	public double getDureeFerier(){
		return this.dureeFerier;
	}
}
