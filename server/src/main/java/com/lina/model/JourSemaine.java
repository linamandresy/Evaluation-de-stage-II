package com.lina.model;

public class JourSemaine {
	private int idJourSemaine;
	private String nomJour;
	private int idMajoration;

	public JourSemaine(String nomJour, int idMajoration) {
		this.nomJour = nomJour;
		this.idMajoration = idMajoration;
	}

	public JourSemaine(int idJourSemaine, String nomJour, int idMajoration) {
		this.idJourSemaine = idJourSemaine;
		this.nomJour = nomJour;
		this.idMajoration = idMajoration;
	}

	public JourSemaine() {
	}

	public int getIdJourSemaine() {
		return idJourSemaine;
	}

	public int getIdMajoration() {
		return idMajoration;
	}

	public String getNomJour() {
		return nomJour;
	}

	public void setIdJourSemaine(int idJourSemaine) {
		this.idJourSemaine = idJourSemaine;
	}

	public void setIdMajoration(int idMajoration) {
		this.idMajoration = idMajoration;
	}

	public void setNomJour(String nomJour) {
		this.nomJour = nomJour;
	}
}
