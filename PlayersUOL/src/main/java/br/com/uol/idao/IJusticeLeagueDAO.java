package br.com.uol.idao;

import java.util.List;

public interface IJusticeLeagueDAO {
	void addListHeroes(List<String> listHeroes);
	List<String> getAllCodinames();
	String getCodename();

}
