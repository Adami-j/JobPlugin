package fr.tiltech.job.Listener;

import fr.tiltech.job.Command.JobCommand;
import fr.tiltech.job.Config.Config;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
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
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class PlayerJoin implements Listener {

    private static Job plugin;

    public PlayerJoin(Job plugin) {
        this.plugin = plugin;
    }

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

        if (!plugin.getJobs().isEmpty()) {
            for (String s : plugin.getJobs()) {
                p.sendMessage(s + "test");
            }
        } else {
            p.sendMessage("Le truc est vide");
        }



        if(!plugin.getCustomConfig().contains("players."+p.getName())) {
            plugin.getCustomConfig().set("players."+p.getName(), p.getName());
        }
    }
}
