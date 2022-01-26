package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("etudiant")
public class Etudiant extends Personne implements Serializable{
	
	private Double moyenne;

	public Etudiant() {}
	
	public Etudiant(Double moyenne) {
		super();
		this.moyenne = moyenne;
	}

	public Etudiant(String nomPersonne, String prenomPersonne, Date dateNaissancePersonne, String username,
			String password, String email, boolean enabled, byte[] photoProfil, Double moyenne) {
		super(nomPersonne, prenomPersonne, dateNaissancePersonne, username, password, email, enabled, photoProfil);
		this.moyenne = moyenne;
	}

	public Double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}

	@Override
	public String toString() {
		return super.toString() + "Etudiant [moyenne=" + moyenne + "]";
	}
	
	

}
