package fr.tiltech.job.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface JobCommandInterface {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args);
    public boolean playerHasJob(Player p);
    public boolean playerHasJob(Player p, String job);

}
