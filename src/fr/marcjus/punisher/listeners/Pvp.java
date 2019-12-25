package fr.marcjus.punisher.listeners;

import java.util.HashMap;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.marcjus.punisher.PlayerManager;
import fr.marcjus.punisher.Punisher;

public class Pvp implements Listener {
	
	private HashMap<Player, PlayerManager> pm = Punisher.getManagers();
	
	@EventHandler
	public void onPvp(EntityDamageByEntityEvent e){
		
		Entity ent = e.getEntity();
		Entity damager = e.getDamager();
		if(damager instanceof Player){
			Player d = (Player) damager;
			if(pm.get(d).isNopvp()){
				e.setCancelled(true);
				d.sendMessage("§cVous n'avez pas le droit de combattre !");
			}else if(pm.get(d).isAutodamage()){
				d.damage(e.getDamage());
				e.setCancelled(true);
				d.sendMessage("§cVous prenez vos dégats !");
			}
		}
		
	}
	
}
