package fr.tiltech.job.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import fr.tiltech.job.Job;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.isOp()) {
            player.sendMessage("§3</§63iLTechServ§3> §6Bienvenue §3" + player.getName());
            if (!player.hasPermission("")) {
                player.sendMessage("§8> §cTu n'as pas de métier ! Choisis-en un parmi la liste :");
                player.sendMessage("§7- §aMineur");
                player.sendMessage("§7- §aGuerrier");
                player.sendMessage("§7- §aChimiste");
                player.sendMessage("§7- §aFermier\n");
                player.sendMessage("§8> §cClique sur le métier que tu voudrais exercer.");
            }
        } else {
            player.sendMessage("Salut mke ekfkdsqdg");
        }
    }
}
