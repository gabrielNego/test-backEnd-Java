package br.com.uol.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.uol.idao.IAvengersDAO;
import br.com.uol.model.Heroe;

public class AvengersDAO implements IAvengersDAO {
	private static final Logger logger = LoggerFactory.getLogger(IAvengersDAO.class);
	private static final List<String> listCodeNames = new ArrayList<String>(0);

	public void addListHeroes(List<Heroe> listHeroes) {
		for (Heroe heroe : listHeroes) {
			listCodeNames.add(heroe.getCodeName());
		}
	}

	public List<String> getAllCodinames() {
		return AvengersDAO.listCodeNames;
	}

	public String getCodename() {
		logger.info("listCodeNames size " + listCodeNames.size());
		return AvengersDAO.listCodeNames.size() > 0 ? AvengersDAO.listCodeNames.remove(0) : null;
	}
}
