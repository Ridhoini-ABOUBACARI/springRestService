package fr.projetSTB.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "membre")
@XmlAccessorType(XmlAccessType.NONE)
public class Personne implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Transient
	@XmlElement(required = true)
	private Nom nom;
	
	@Column(name = "prenom", nullable = false)
	@XmlElement(required = true)
	private String prenom;
	
	@Column(name = "nom", nullable = false)
	private String name;
	
	@Column(name = "gender", nullable = false)
	private boolean gender;

	public Personne(boolean gender, String nom, String prenom) {
		super();
		this.nom = new Nom(gender, nom);
		this.prenom = prenom;
	}

	public Personne() {
		super();
	}

	public Nom getNom() {
		return nom;
	}

	public void setNom(Nom nom) {
		this.nom = nom;
		this.name = nom.getNom();
		this.gender = nom.isGender();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.nom.setNom(name);
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
		this.nom.setGender(gender);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", name=" + name
				+ ", gender=" + gender + "]";
	}
	
	
}
