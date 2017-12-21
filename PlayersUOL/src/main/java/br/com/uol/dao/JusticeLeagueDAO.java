package br.com.uol.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.uol.idao.IJusticeLeagueDAO;

public class JusticeLeagueDAO implements IJusticeLeagueDAO {
	private static final Logger logger = LoggerFactory.getLogger(IJusticeLeagueDAO.class);
	private static final List<String> listCodeNames = new ArrayList<String>(0);

	public void addListHeroes(List<String> listHeroes) {
		for (String codeName : listHeroes) {
			listCodeNames.add(codeName);
		}
	}

	public List<String> getAllCodinames() {
		return JusticeLeagueDAO.listCodeNames;
	}

	public String getCodename() {
		logger.info("listCodeNames size " + listCodeNames.size());
		return JusticeLeagueDAO.listCodeNames.size() > 0 ? JusticeLeagueDAO.listCodeNames.remove(0) : null;
	}
	
	

}
