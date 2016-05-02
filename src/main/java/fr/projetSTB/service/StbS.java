package fr.projetSTB.service;

import java.util.List;

import fr.projetSTB.model.Stb;


public interface StbS {
	public Stb findById(int id);
	public void saveStb(Stb stb);
	public List<Stb> findAllStb();
}
