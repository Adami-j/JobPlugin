package fr.tiltech.job.Command;

import fr.tiltech.job.Job;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.chat.TextComponent;
import org.checkerframework.checker.units.qual.C;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;

public class JobCommand implements CommandExecutor {

    private final Job plugin;
    public JobCommand(Job plugin) {
        this.plugin = plugin;
    }

    ArrayList<ChatColor> colors = new ArrayList<>(Arrays.asList(
            ChatColor.GOLD,
            ChatColor.RED,
            ChatColor.YELLOW,
            ChatColor.LIGHT_PURPLE));

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
                p.sendMessage("§4» §7§oHere the list of jobs:");
                for (String string : plugin.getConfig().getConfigurationSection("jobs").getKeys(false)) {
                    String s = plugin.getConfig().getConfigurationSection("jobs").getString(string + ".name");
                    TextComponent tc1 = new TextComponent(" §4"+(i+1)+". §l");
                    TextComponent tc2 = new TextComponent(ChatColor.RED+s);
                    tc2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7§oClick to choose the job of "+s)));
                    tc2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "job "+s));
                    tc1.addExtra(tc2);
                    p.spigot().sendMessage(tc1);
                    i++;
                }
                p.sendMessage("§4» §7§oChoose a job by clicking on it.");
                return true;
            }
            return true;
        }
        return false;
    }

    public int getSalary(String str) {
        return plugin.getConfig().getInt("jobs."+str+".salary");
    }

    public double getMinValue(String str) {
        return plugin.getConfig().getInt("jobs."+str+".min_value");
    }

    public double getMaxValue(String str) {
        return plugin.getConfig().getInt("jobs."+str+".max_value");
    }
}