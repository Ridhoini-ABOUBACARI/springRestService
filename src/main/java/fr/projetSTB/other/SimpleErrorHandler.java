package fr.projetSTB.other;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SimpleErrorHandler implements ErrorHandler{
	
	private boolean hasError;
	
	public SimpleErrorHandler(){
		this.hasError = false;
	}

	public void warning(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		this.hasError = true;
	}

	public void error(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		this.hasError = true;
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		this.hasError = true;
	}

	public boolean hasError() {
		return hasError;
	}

}
