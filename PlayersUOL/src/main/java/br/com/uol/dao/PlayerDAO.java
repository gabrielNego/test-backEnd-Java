package br.com.uol.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.uol.idao.IPlayerDAO;
import br.com.uol.model.Player;

public class PlayerDAO implements IPlayerDAO{
	
	private static List<Player> listPlayer = new ArrayList<Player>(0);

	public List<Player> getAllPlayer() {
		return PlayerDAO.listPlayer;
	}

	public Boolean AddPlayer(Player player) {
		int initialSize = PlayerDAO.listPlayer.size();
		PlayerDAO.listPlayer.add(player);
		return PlayerDAO.listPlayer.size() > initialSize;
	}

	public Boolean RemovePlayer(Player player) {
		int initialSize = PlayerDAO.listPlayer.size();
		PlayerDAO.listPlayer.remove(player);
		return PlayerDAO.listPlayer.size() < initialSize;
	}

	public Boolean UpdatePlayer(Player player, int index) {
		Player tempPlayer = PlayerDAO.listPlayer.get(index);
		tempPlayer.setCodeName(player.getCodeName());
		tempPlayer.setEmail(player.getEmail());
		tempPlayer.setGroup(player.getGroup());
		tempPlayer.setName(player.getName());
		tempPlayer.setPhone(player.getPhone());
		
		return PlayerDAO.listPlayer.indexOf(player) >= 0;
	}
	
	
	
	

}
