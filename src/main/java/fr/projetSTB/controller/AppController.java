package fr.projetSTB.controller;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.projetSTB.model.Accueil;
import fr.projetSTB.model.ListStb;
import fr.projetSTB.model.Personne;
import fr.projetSTB.model.Stb;
import fr.projetSTB.model.StbShort;
import fr.projetSTB.other.ValidatorXML;
import fr.projetSTB.service.StbS;



@RestController
@RequestMapping("/")
public class AppController {

	@Autowired
	StbS service;
	private ValidatorXML validator;
	
	

	@RequestMapping(value = "/")
    public @ResponseBody Accueil index() {
        Accueil accueil = new Accueil("Hajar ZEROUAL", "Ridhoini ABOUBACARI", service.findAllStb().size());
        
        return accueil;
    }
	
	/**
	 * Renvoie la liste des toutes les STB
	 * @return
	 */
	@RequestMapping(value = "/resume")
    public @ResponseBody ResponseEntity<ListStb> getAllSTB() {
		ListStb stbs = new ListStb();
		for(Stb stb: service.findAllStb()){
			stbs.addStb(new StbShort(stb));
		}
        
        return new ResponseEntity<ListStb>(stbs, HttpStatus.FOUND);
    }
	
	/**
	 * Retourne la STB dont le numéro est passer en paramètre
	 * @return
	 */
	@RequestMapping(value = "/resume/{id}")
    public @ResponseBody ResponseEntity<Stb> getStb(@PathVariable("id") int id) {
		Stb res = service.findById(id);
		if(res != null)
			return new ResponseEntity<Stb>(res, HttpStatus.FOUND);
		
		return new ResponseEntity<Stb>(HttpStatus.NOT_FOUND);
    }
	
	@RequestMapping(value = "/depot", method=RequestMethod.POST)
    public ResponseEntity<Void> addSTB(@RequestBody Stb stb) {
        validator = new ValidatorXML();
        
        HttpHeaders headers = new HttpHeaders();
        
        if(validator.validateSTB(stb)){
        	//Pour mettre a jour les champs spécial de la base de données
        	stb.getClient().setContact(stb.getClient().getContact());
        	for(Personne p: stb.getEquipe().getMembre()){
        		p.setNom(p.getNom());
        	}
        	
        	Logger.getLogger ("AppController").log(Level.INFO, "stb : " + stb);
        	
        	service.saveStb(stb);
        	
        	return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }
        
        return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
    }

}
