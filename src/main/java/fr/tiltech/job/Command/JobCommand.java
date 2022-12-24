package fr.tiltech.job.Command;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import fr.tiltech.job.metier.Jobs;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.chat.TextComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JobCommand implements CommandExecutor {

    ArrayList<ChatColor> colors = new ArrayList<>(Arrays.asList(ChatColor.GOLD, ChatColor.RED, ChatColor.YELLOW, ChatColor.LIGHT_PURPLE));

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
        if (command.getName().equalsIgnoreCase("job")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.sendMessage("" + ChatColor.BOLD + ChatColor.RED + "You must specify a job.");
                    return true;
                }
                if (args.length == 1) {

                }
                if (args.length >= 2) {
                    p.sendMessage("" + ChatColor.BOLD + ChatColor.RED + "Too much arguments.");
                    return true;
                }
                return true;
            }
            return true;
        }
        if (command.getName().equalsIgnoreCase("jobs")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                int i = 0;
                for (Jobs job : Jobs.values()) {
                    TextComponent tc_up = new TextComponent("§8- ");
                    TextComponent tc_down = new TextComponent(colors.get(i)+String.valueOf(job));
                    tc_down.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Choisir le métier "+ colors.get(i)+String.valueOf(job))));
                    tc_down.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "msg"));
                    tc_up.addExtra(tc_down);
                    p.spigot().sendMessage(tc_up);
                    i++;
                }
                return true;
            }
            return true;
        }
        return false;
    }
}