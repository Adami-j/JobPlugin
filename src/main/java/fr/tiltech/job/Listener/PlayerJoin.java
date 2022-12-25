package fr.tiltech.job.Listener;

import fr.tiltech.job.Command.JobCommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import fr.tiltech.job.Job;

public class PlayerJoin implements Listener {

    private static Job plugin;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (!p.isOp()) {
            if (!p.hasPermission("jobplugin.job")) {
                p.sendMessage("§4» §cYou don't have a job!");
                p.performCommand("jobs");
            }
        } else {
            p.sendMessage("§cHello operator. You already have a §ojob.");
        }
    }
}
