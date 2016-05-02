package fr.projetSTB.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "exigence")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "exigenceFonctionnelle")
public class ExigenceFonctionnelle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "identifiant", nullable = false)
	@XmlElement(required = true)
	private String identifiant;
	
	@Column(name = "priorite", nullable = false)
	@XmlElement(required = true)
	private int priorite;
	
	@Column(name = "description", nullable = false, columnDefinition="TEXT")
	@XmlElement(required = true)
	private String description;

	public ExigenceFonctionnelle(String identifiant, int priorite, String description) {
		this.identifiant = identifiant;
		this.priorite = priorite;
		this.description = description;
	}

	public ExigenceFonctionnelle() {
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ExigenceFonctionnelle [id=" + id + ", identifiant=" + identifiant
				+ ", priorite=" + priorite + ", description=" + description + "]";
	}
	
}
