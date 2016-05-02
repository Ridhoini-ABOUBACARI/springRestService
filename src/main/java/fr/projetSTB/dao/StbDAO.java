package fr.projetSTB.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import fr.projetSTB.model.Stb;


@Repository("stbDao")
public class StbDAO extends AbstractDao<Integer, Stb> implements StbD{    
	
	
	public void saveStb(Stb stb) {
        persist(stb);
    }
 
    @SuppressWarnings("unchecked")
    public List<Stb> findAllStb() {
        Criteria criteria = getSession().createCriteria(Stb.class);
        return (List<Stb>) criteria.list();
    }

	public Stb findById(int id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	
}
