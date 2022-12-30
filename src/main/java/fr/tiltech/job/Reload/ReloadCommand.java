package fr.tiltech.job.Reload;

import fr.tiltech.job.Job;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand implements CommandExecutor {

    private static Job plugin;

    public ReloadCommand(Job plugin) {
        this.plugin = plugin;
    }

    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (command.getName().equalsIgnoreCase("jp")) {
            if (args.length == 0) {

            }

            if (args.length == 1) {
                if (p.isOp() && args[0].equalsIgnoreCase("reload")) {
                    plugin.onDisable();
                    plugin.onEnable();
                    Job.getInstance().reloadConfig();
                    p.sendMessage("Config reloaded.");
                    return true;
                }
                return true;
            }

            if (args.length >= 2) {
                p.sendMessage("" + ChatColor.BOLD + ChatColor.RED + "Too much arguments.");
                return true;
            }

            return true;
        }
        return false;
    }
}
