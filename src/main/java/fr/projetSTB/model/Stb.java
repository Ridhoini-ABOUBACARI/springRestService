package fr.projetSTB.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "stb")
@XmlRootElement (name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
public class Stb implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlAttribute()
	private int id;
	
	@Column(name = "titre", nullable = false)
	@XmlElement(required = true)
	private String titre;
	
	@Column(name = "version", nullable = false)
	@XmlElement(required = true)
	private String version;
	
	@Column(name = "date", nullable = false)
	@XmlElement(required = true)
	private String date;
	
	@Column(name = "description", nullable = false, columnDefinition="TEXT")
	@XmlElement(required = true)
	private String description;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@XmlElement(required = true)
	private Client client;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@XmlElement(required = true)
	private Equipe equipe;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@XmlElement(required = true)
	private Fonctionnalites fonctionnalites;
	
	@Column(name = "commentaire", nullable = true)
	@XmlElement
	private String commentaire;

	public Stb(int identifiant, String titreDuProject, String version, String date, String description, Client client,
			Equipe equipe, Fonctionnalites fonctionnalites, String commentaire) {
		this.id = identifiant;
		this.titre = titreDuProject;
		this.version = version;
		this.date = date;
		this.description = description;
		this.client = client;
		this.equipe = equipe;
		this.fonctionnalites = fonctionnalites;
		this.commentaire = commentaire;
	}

	public Stb() {
	}

	public int getIdentifiant() {
		return id;
	}

	public void setIdentifiant(int identifiant) {
		this.id = identifiant;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Fonctionnalites getFonctionnalites() {
		return fonctionnalites;
	}

	public void setFonctionnalites(Fonctionnalites fonctionnalites) {
		this.fonctionnalites = fonctionnalites;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public String toString() {
		return "Stb [id=" + id + ", titre=" + titre + ", version=" + version + ", date=" + date + ", description="
				+ description + ", client=" + client + ", equipe=" + equipe + ", fonctionnalites=" + fonctionnalites
				+ ", commentaire=" + commentaire + "]";
	}
	
	
}
