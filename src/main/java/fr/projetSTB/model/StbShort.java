package fr.projetSTB.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "stb")
@XmlAccessorType(XmlAccessType.NONE)
public class StbShort implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute()
	private int id;
	
	@XmlElement(required = true)
	private String titre;
	
	@XmlElement(required = true)
	private String version;
	
	@XmlElement(required = true)
	private String date;
	
	@XmlElement(required = true)
	private String description;
	
	@XmlElement
	private String commentaire;
	
	public StbShort(){
		
	}
	
	public StbShort(Stb stb){
		this.id = stb.getIdentifiant();
		this.titre = stb.getTitre();
		this.version = stb.getVersion();
		this.date = stb.getDate();
		this.commentaire = stb.getCommentaire();
		String[] lines = stb.getDescription().split(System.getProperty("line.separator"));
		
		StringBuilder sb = new StringBuilder();
        sb.append(lines[0].toString()+"\r\n");
        if(lines.length > 1)
        	sb.append(lines[1].toString()+"\r\n");
        
        this.description = sb.toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
