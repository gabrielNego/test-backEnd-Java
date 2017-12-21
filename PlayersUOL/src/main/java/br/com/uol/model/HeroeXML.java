package br.com.uol.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class HeroeXML {

	@XmlElement(name="codinome")
	private List<String> codeNames;

	public List<String> getCodeNames() {
		return codeNames;
	}

	public void setCodeNames(List<String> codeNames) {
		this.codeNames = codeNames;
	}
}
