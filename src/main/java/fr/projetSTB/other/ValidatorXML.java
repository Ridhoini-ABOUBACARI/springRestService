package fr.projetSTB.other;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import fr.projetSTB.model.Stb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class ValidatorXML {
	
	public boolean validateSTB(Stb stb){
		File xsd = new File(getClass().getClassLoader().getResource("projetWeb.xsd").getPath());
		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		Schema schema = null;
		try {
			schema = schemaFactory.newSchema(xsd);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JAXBContext jc = null;
		try {
			jc = JAXBContext.newInstance(Stb.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Marshaller marshaller = null;
		try {
			marshaller = jc.createMarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		marshaller.setSchema(schema);
		try {
			marshaller.marshal(stb, new DefaultHandler());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
		return true;
	}
}
