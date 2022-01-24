package com.inti.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Examen implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idExamen;
	private String nomExamen;
	private String duree; 
	@Temporal(TemporalType.DATE)
	private Date dateExamen;
	@Lob
	private byte[] fichierExamen; // IN
	@Lob
	private byte[] fichierReponseExamen; // OUT
	
	@ManyToOne
	@Transient
	@JoinColumn(name = "id_cours")
	private Cours cours;
	
	@OneToOne(mappedBy = "examen")
	@JoinColumn(name = "id_correction")
	private Correction correction;

	public Long getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}

	public String getNomExamen() {
		return nomExamen;
	}

	public void setNomExamen(String nomExamen) {
		this.nomExamen = nomExamen;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public Date getDateExamen() {
		return dateExamen;
	}

	public void setDateExamen(Date dateExamen) {
		this.dateExamen = dateExamen;
	}

	public byte[] getFichierExamen() {
		return fichierExamen;
	}

	public void setFichierExamen(byte[] fichierExamen) {
		this.fichierExamen = fichierExamen;
	}

	public byte[] getFichierReponseExamen() {
		return fichierReponseExamen;
	}

	public void setFichierReponseExamen(byte[] fichierReponseExamen) {
		this.fichierReponseExamen = fichierReponseExamen;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Correction getCorrection() {
		return correction;
	}

	public void setCorrection(Correction correction) {
		this.correction = correction;
	}

	public Examen(String nomExamen, String duree, Date dateExamen, byte[] fichierExamen, byte[] fichierReponseExamen) {
		
		this.nomExamen = nomExamen;
		this.duree = duree;
		this.dateExamen = dateExamen;
		this.fichierExamen = fichierExamen;
		this.fichierReponseExamen = fichierReponseExamen;
	}

	public Examen(String nomExamen, String duree, Date dateExamen, byte[] fichierExamen, byte[] fichierReponseExamen,
			Cours cours, Correction correction) {
		
		this.nomExamen = nomExamen;
		this.duree = duree;
		this.dateExamen = dateExamen;
		this.fichierExamen = fichierExamen;
		this.fichierReponseExamen = fichierReponseExamen;
		this.cours = cours;
		this.correction = correction;
	}

	public Examen() {
		
	}

	@Override
	public String toString() {
		return "Examen [idExamen=" + idExamen + ", nomExamen=" + nomExamen + ", duree=" + duree + ", dateExamen="
				+ dateExamen + ", fichierExamen=" + Arrays.toString(fichierExamen) + ", fichierReponseExamen="
				+ Arrays.toString(fichierReponseExamen) + ", cours=" + cours + ", correction=" + correction + "]";
	}
	
	
	
}
