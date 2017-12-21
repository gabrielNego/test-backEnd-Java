package br.com.uol.idao;

import java.util.List;

import br.com.uol.model.Heroe;

public interface IAvengersDAO {
	void addListHeroes(List<Heroe> listHeroes);
	List<String> getAllCodinames();
	String getCodename();
}
