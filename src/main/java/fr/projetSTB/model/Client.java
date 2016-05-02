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
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "client")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "client")
public class Client implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "entite", nullable = false)
	@XmlElement(required = true)
	private String entite;
	
	@Transient
	@XmlElement(required = true)
	private Personne contact;
	
	/* élément pour la base */
	
	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Column(name = "prenom", nullable = false)
	private String prenom;
	
	@Column(name = "gender", nullable = false)
	private boolean gender;
	
	@Column(name = "codePostal", nullable = false)
	@XmlElement(required = true)
	private String codePostal;

	public Client(String entite, Personne contact, String codePostal) {
		this.entite = entite;
		this.contact = contact;
		this.codePostal = codePostal;
	}

	public Client() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEntite() {
		return entite;
	}

	public void setEntite(String entite) {
		this.entite = entite;
	}

	public Personne getContact() {
		return contact;
	}

	public void setContact(Personne contact) {
		this.contact = contact;
		this.nom = contact.getNom().getNom();
		this.prenom = contact.getPrenom();
		this.gender = contact.getNom().isGender();
	}

	public String getNom() {
		return nom;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
		this.contact.setGender(gender);
	}

	public void setNom(String nom) {
		this.nom = nom;
		this.contact.setName(nom);
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
		this.contact.setPrenom(prenom);
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", entite=" + entite + ", contact=" + contact + ", nom=" + nom
				+ ", prenom=" + prenom + ", gender=" + gender + ", codePostal=" + codePostal + "]";
	}
	

}
