package br.com.uol.idao;

import java.util.List;

import br.com.uol.model.Player;

public interface IPlayerDAO {
	
	List<Player> getAllPlayer();
	Boolean AddPlayer(Player player);
	Boolean RemovePlayer(Player player);
	Boolean UpdatePlayer(Player player, int index);
	
}
