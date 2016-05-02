package fr.projetSTB.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.NONE)
public class Nom {
	@XmlAttribute(required = true)
	private boolean gender;
	
	@XmlValue
	private String nom;

	public Nom() {
	}

	public Nom(boolean gender, String nom) {
		this.gender = gender;
		this.nom = nom;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Nom [gender=" + gender + ", nom=" + nom + "]";
	}
	
	
}
