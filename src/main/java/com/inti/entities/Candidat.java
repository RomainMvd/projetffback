package com.inti.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@DiscriminatorValue("candidat")
public class Candidat extends Personne implements Serializable{
	
	@Lob
	private byte[] lettreMotivation;
	@Lob
	private byte[] cV;
	private String posteConvoite;

	public Candidat() {}

	public byte[] getLettreMotivation() {
		return lettreMotivation;
	}

	public void setLettreMotivation(byte[] lettreMotivation) {
		this.lettreMotivation = lettreMotivation;
	}

	public byte[] getcV() {
		return cV;
	}

	public void setcV(byte[] cV) {
		this.cV = cV;
	}

	public String getPosteConvoite() {
		return posteConvoite;
	}

	public void setPosteConvoite(String posteConvoite) {
		this.posteConvoite = posteConvoite;
	}

	@Override
	public String toString() {
		return super.toString() + "Candidat [lettreMotivation=" + Arrays.toString(lettreMotivation) + ", cV=" + Arrays.toString(cV)
				+ ", posteConvoite=" + posteConvoite + "]";
	}
	
}
