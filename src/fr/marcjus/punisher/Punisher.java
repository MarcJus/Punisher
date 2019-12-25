package fr.marcjus.punisher;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.marcjus.punisher.listeners.InventoryListeners;
import fr.marcjus.punisher.listeners.Join;
import fr.marcjus.punisher.listeners.Pvp;

public class Punisher extends JavaPlugin {
	
	private static ArrayList<Player> players = new ArrayList<>();
	private static HashMap<Player, PlayerManager> managers = new HashMap<>();
	
	@Override
	public void onEnable() {
		getCommand("punisher").setExecutor(new CommandPunisher());
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new InventoryListeners(), this);
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Pvp(), this);
		for(Player player : Bukkit.getOnlinePlayers()){
			players.add(player);
		}
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static ArrayList<Player> getPlayers(){
		return players;
	}

	public static HashMap<Player, PlayerManager> getManagers() {
		return managers;
	}

}
