package fr.marcjus.punisher;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CustomMenu {
	
	private Inventory inv;
	
	public CustomMenu(String name, int size) {
		Inventory inv = Bukkit.createInventory(null, size, name);
		this.inv = inv;
	}
	
	@SuppressWarnings("deprecation")
	public void createMenuPlayers(){
		for(Player player : Bukkit.getOnlinePlayers()){
			ItemStack it = new ItemStack(Material.SKULL_ITEM, 1, (byte)3);
			SkullMeta meta = (SkullMeta) it.getItemMeta();
			meta.setDisplayName("§e"+player.getName());
			meta.setLore(Arrays.asList("§3Punir le joueur"));
			meta.setOwner(player.getName());
			it.setItemMeta(meta);
			inv.addItem(it);
		}
	}
	
	public void createMenuPunisher(){
		
		ItemStack npb = new ItemStack(Material.STONE);
		ItemMeta npbm = npb.getItemMeta();
		npbm.setDisplayName("§9Le joueur ne peut plus placer de bloc");
		npb.setItemMeta(npbm);
		
		ItemStack nopvp = new ItemStack(Material.STONE_SWORD);
		ItemMeta npvpm = nopvp.getItemMeta();
		npvpm.setDisplayName("§1Le joueur ne peut combattre");
		nopvp.setItemMeta(npvpm);
		
		ItemStack sky = new ItemStack(Material.FEATHER);
		ItemMeta skym = sky.getItemMeta();
		skym.setDisplayName("§3Envoie le joueur dans le ciel");
		sky.setItemMeta(skym);
		
		ItemStack autodamage = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta adm = autodamage.getItemMeta();
		adm.setDisplayName("§2Le joueur prend les degats qu'il a donne");
		autodamage.setItemMeta(adm);
		
		ItemStack poison = new ItemStack(Material.POTION);
		PotionMeta poisonm = (PotionMeta) poison.getItemMeta();
		poisonm.addCustomEffect(new PotionEffect(PotionEffectType.HARM, 9999, 2), true);
		poisonm.setDisplayName("§eDonne un effet de poison pendant 20 secondes");
		poisonm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		poison.setItemMeta(poisonm);
		
		ItemStack nopickup = new ItemStack(Material.DIRT);
		ItemMeta npmeta = nopickup.getItemMeta();
		npmeta.setDisplayName("§6Le joueur ne peut plus ramasser d'item au sol");
		nopickup.setItemMeta(npmeta);
		
		ItemStack noopenchest = new ItemStack(Material.CHEST);
		ItemMeta nocmeta = noopenchest.getItemMeta();
		nocmeta.setDisplayName("§cLe joueur ne peut plus ouvrir son inventaire");
		noopenchest.setItemMeta(nocmeta);
		
		inv.addItem(npb, nopvp, sky, autodamage, poison, nopickup, noopenchest);
		
	}

	public void openMenu(Player player){
		player.openInventory(inv);
	}
}
