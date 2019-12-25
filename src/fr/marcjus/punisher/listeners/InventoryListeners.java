package fr.marcjus.punisher.listeners;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.marcjus.punisher.CustomMenu;
import fr.marcjus.punisher.PlayerManager;
import fr.marcjus.punisher.Punisher;

public class InventoryListeners implements Listener {
	
	@EventHandler
	public void onClickPlayersMenu(InventoryClickEvent e){
		Inventory inv = e.getInventory();
		Player player = (Player) e.getWhoClicked();
		ItemStack it = e.getCurrentItem();
		if(inv != null && it != null && it.getType() != null){
			if(inv.getName().equals("§2Joueurs")){
				if(it.getType().equals(Material.SKULL_ITEM)){
					SkullMeta meta = (SkullMeta) it.getItemMeta();
					@SuppressWarnings("deprecation")
					Player target = Bukkit.getPlayer(meta.getOwner());
					CustomMenu menu = new CustomMenu("§a"+target.getName(), 27);
					menu.createMenuPunisher();
					menu.openMenu(player);
				}
			}
		}
	}
	
	@EventHandler
	public void onClickMenuPunisher(InventoryClickEvent e){
		Inventory inv = e.getInventory();
		Player player = (Player) e.getWhoClicked();
		ItemStack it = e.getCurrentItem();
		if(inv != null && it != null && it.getType() != null){
			if(Punisher.getPlayers().contains(Bukkit.getPlayer(inv.getName().replaceAll("§a", "")))){
				e.setCancelled(true);
				String playerName = inv.getName().replaceAll("§a", "");
				Player target = Bukkit.getPlayer(playerName);
				PlayerManager pm = new PlayerManager();
				if(Punisher.getManagers().get(target) != null){
					pm = Punisher.getManagers().get(target);
				}
				
				switch(it.getType()){
				
				case STONE:
					if(!pm.isNoPlaceBlock()){
						pm.setNoPlaceBlock(true);
						player.sendMessage("§aLe joueur ne peut plus placer de blocs !");
						target.sendMessage("§cVous ne pouvez plus placer de blocs !");
					}else{
						pm.setNoPlaceBlock(false);
						player.sendMessage("§aLe joueur peut placer des blocs !");
						target.sendMessage("§aVous pouvez placer des blocs !");
					}
					break;
				case STONE_SWORD:
					if(!pm.isNopvp()){
						pm.setNopvp(true);
						player.sendMessage("§aLe joueur ne peut plus combattre !");
						target.sendMessage("§cVous ne pouvez plus combattre !");
					}else{
						pm.setNopvp(false);
						player.sendMessage("§aLe joueur peut combattre !");
						target.sendMessage("§aVous pouvez combattre !");
					}
					break;
				case DIAMOND_SWORD:
					if(!pm.isAutodamage()){
						pm.setAutodamage(true);
						player.sendMessage("§aLe joueur subit les degats qu'il inflige !");
						target.sendMessage("§cVous subissez les degats que vous infligez !é");
					}else{
						pm.setAutodamage(false);
						player.sendMessage("§aLe joueur ne subit plus les degats qu'il inflige !");
						target.sendMessage("§aVous ne subissez plus les degats que vous infligez !");
					}
					break;
				case POTION:
					if(!player.hasPotionEffect(PotionEffectType.POISON)){
						target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 600, 1));
						target.sendMessage("§cVous avez un effet de poison !");
						player.sendMessage("§aLe joueur a un effet de poison !");
					}else{
						target.removePotionEffect(PotionEffectType.POISON);
						target.sendMessage("§aVous n'avez plus d'effet de poison !");
						player.sendMessage("§aLe joueur n'a plus d'effet de poison !");
					}
				case DIRT:
					if(!pm.isNopickup()){
						pm.setNopickup(true);
						player.sendMessage("§aLe joueur ne peut plus ramasser d'item !");
						target.sendMessage("§cVous ne pouvez plus ramasser d'item !");
					}else{
						pm.setNopickup(false);
						player.sendMessage("§aLe joueur peut ramasser des items !");
						target.sendMessage("§aVous pouvez ramasser des items !");
					}
					break;
				case CHEST:
					if(!pm.isNoopenchest()){
						pm.setNoopenchest(true);
						player.sendMessage("§aLe joueur ne peut plus ouvrir d'inventaire !");
						target.sendMessage("§cVous ne pouvez plus ouvrir d'inventaire !");
					}else{
						pm.setNoopenchest(false);
						player.sendMessage("§aLe joueur peut ouvrir son inventaire !");
						target.sendMessage("§aVous pouvez ramasser ouvrir votre inventaire !");
					}
					break;
				case FEATHER:
					player.sendMessage("§aLe joueur a ete envoye dans le ciel !");
					target.sendMessage("§cVous avez ete envoye dans le ciel !");
					target.teleport(new Location(target.getWorld(), target.getLocation().getBlockX(), 200, target.getLocation().getZ()));
					target.setGameMode(GameMode.SURVIVAL);
					target.setFlying(false);
					break;
				default:
					break;
				
				}
			}
		}
	}

}
