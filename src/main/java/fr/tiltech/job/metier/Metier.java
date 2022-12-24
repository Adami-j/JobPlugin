package fr.tiltech.job.metier;

import fr.tiltech.job.Job;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.PluginEvent;
import org.bukkit.event.server.ServerEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public class Metier extends JavaPlugin implements CommandExecutor {

    private ArrayList<Metier> jobs = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(command.getName().equalsIgnoreCase("job")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Please specify a job.");
                return true;
            }
            if (args.length == 1) {
                p.sendMessage("C'est ok");
                return false;
            }
            if (args.length >= 2) {
                p.sendMessage(ChatColor.RED + "Too much arguments");
                return true;
            }
        }
        return false;
    }
}
