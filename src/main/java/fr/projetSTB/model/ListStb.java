package fr.projetSTB.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="stbs")
public class ListStb implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<StbShort> stb = new ArrayList<StbShort>();

	public List<StbShort> getStb() {
		return stb;
	}

	public void setStb(List<StbShort> stb) {
		this.stb = stb;
	}
	
	public boolean addStb(StbShort s){
		return stb.add(s);
	}
	
	public boolean removeStb(StbShort s){
		for(StbShort stb: this.stb){
			if(s.equals(stb))
				return this.stb.remove(stb);
		}
		return false;
	}
}
