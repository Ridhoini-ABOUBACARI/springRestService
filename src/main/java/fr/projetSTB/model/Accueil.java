package fr.projetSTB.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "accueil")
@XmlAccessorType(XmlAccessType.NONE)
public class Accueil {
	
	@XmlElement(required = true)
	private String membre1;
	
	@XmlElement(required = true)
	private String membre2;
	
	@XmlElement(required = true)
	private int nbStb;

	public Accueil(String membre1, String membre2, int nbStb) {
		this.membre1 = membre1;
		this.membre2 = membre2;
		this.nbStb = nbStb;
	}

	public Accueil(){
		
	}

	public String getMembre1() {
		return membre1;
	}

	public void setMembre1(String membre1) {
		this.membre1 = membre1;
	}

	public String getMembre2() {
		return membre2;
	}

	public void setMembre2(String membre2) {
		this.membre2 = membre2;
	}

	public int getNbStb() {
		return nbStb;
	}

	public void setNbStb(int nbStb) {
		this.nbStb = nbStb;
	}
}
