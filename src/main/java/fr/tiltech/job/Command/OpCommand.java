package fr.tiltech.job.Command;

import fr.tiltech.job.Job;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpCommand implements CommandExecutor {

    private final Job plugin;

    public OpCommand(Job plugin) {
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
        if (command.getName().equalsIgnoreCase("")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(String.valueOf(p.getEffectivePermissions()));
                return true;
            }
            return true;
        }
        return false;
    }
}
