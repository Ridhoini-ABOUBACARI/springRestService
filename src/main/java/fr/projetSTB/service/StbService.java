package fr.projetSTB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.projetSTB.dao.StbDAO;
import fr.projetSTB.model.Stb;


@Service("stbService")
@Transactional
public class StbService implements StbS{
	@Autowired
    private StbDAO dao;

	public Stb findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	public void saveStb(Stb stb) {
		// TODO Auto-generated method stub
		dao.persist(stb);
	}

	public List<Stb> findAllStb() {
		// TODO Auto-generated method stub
		return dao.findAllStb();
	}
}
