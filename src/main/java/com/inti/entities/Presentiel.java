package com.inti.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("presentiel")
public class Presentiel extends Cours implements Serializable{
	
	private String salle;

	public Presentiel() {}
	
	public Presentiel(String salle) {
		super();
		this.salle = salle;
	}

	public Presentiel(String nomCours, String nomMatiere, Double nbrHeure, byte[] fichierCours, String salle) {
		super(nomCours, nomMatiere, nbrHeure, fichierCours);
		this.salle = salle;
	}

	public String getLienZoom() {
		return salle;
	}

	public void setLienZoom(String salle) {
		this.salle = salle;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}
	
	
}
