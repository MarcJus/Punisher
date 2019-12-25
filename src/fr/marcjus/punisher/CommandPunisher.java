package fr.marcjus.punisher;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPunisher implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			CustomMenu menu = new CustomMenu("§2Joueurs", 54);
			menu.createMenuPlayers();
			menu.openMenu(player);
		}
		return false;
	}

}
