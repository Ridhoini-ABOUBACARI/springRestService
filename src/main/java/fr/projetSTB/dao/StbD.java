package fr.projetSTB.dao;

import java.util.List;

import fr.projetSTB.model.Stb;


public interface StbD {
	public Stb findById(int id);
	public void saveStb(Stb stb);
	public List<Stb> findAllStb();
}
