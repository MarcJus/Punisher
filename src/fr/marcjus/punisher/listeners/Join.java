package fr.marcjus.punisher.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.marcjus.punisher.PlayerManager;
import fr.marcjus.punisher.Punisher;

public class Join implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		if(!Punisher.getManagers().containsKey(player)){
			PlayerManager plm = new PlayerManager();
			Punisher.getManagers().put(player, plm);
		}
		
		if(!Punisher.getPlayers().contains(player)){
			Punisher.getPlayers().add(player);
		}
	}

}
