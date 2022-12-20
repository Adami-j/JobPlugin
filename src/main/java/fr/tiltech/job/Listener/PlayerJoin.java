package fr.tiltech.job;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tiltech.job.Main;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.isOp()) {
            player.sendMessage(ChatColor.GREEN + "[3iLTechServ] Bienvenue " + player.getName());
            if (!player.hasPermission("") {
                player.sendMessage("§cTu n'as pas de métier ! Choisis-en un parmi la liste :");
                player.sendMessage("§7- §aMineur");
                player.sendMessage("§7- §aGuerrier");
                player.sendMessage("§7- §aChimiste");
                player.sendMessage("§7- §aFermier");
                player.sendMessage("§cClique sur le métier que tu voudrais exercer.");
            }
        }
    }
}
