package fr.tiltech.job.Command;

import fr.tiltech.job.Job;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ReloadCommand implements CommandExecutor {

    private final Job plugin;
    private final FileConfiguration config;

    public ReloadCommand(Job plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                config.options().copyDefaults(true);
                plugin.saveConfig();
                sender.sendMessage(ChatColor.GREEN + "Configuration reloaded.");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Usage: /jp reload");
                return false;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You must be a console to use this command.");
            return false;
        }
    }
}
