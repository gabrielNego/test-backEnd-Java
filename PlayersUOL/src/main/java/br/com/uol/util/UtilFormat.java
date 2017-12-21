package br.com.uol.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

public class UtilFormat {

	public static List<?> getObjectXML(String xml, Class<?> klass) {
		JacksonXmlModule module = new JacksonXmlModule();
		JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();

		module.setDefaultUseWrapper(false);
		XmlMapper xmlMapper = new XmlMapper(module);
		xmlMapper.registerModule(jaxbAnnotationModule);
		TypeFactory typeFactory = xmlMapper.getTypeFactory();

		List<?> someClass = null;

		try {
			someClass = xmlMapper.readValue(xml, typeFactory.constructCollectionType(List.class, klass));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return someClass;
	}

	public static List<?> getListJSON(String json, Class<?> klass) {
		ObjectMapper objectMapper = new ObjectMapper();
		TypeFactory typeFactory = objectMapper.getTypeFactory();
		List<?> someClassList = null;
		try {
			someClassList = objectMapper.readValue(json,  typeFactory.constructCollectionType(List.class, klass));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return someClassList;
	}

}
