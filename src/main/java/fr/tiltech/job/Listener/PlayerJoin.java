package fr.tiltech.job.Listener;

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

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (!player.isOp()) {
            if (!player.hasPermission("")) {

                player.sendMessage("§8> §cTu n'as pas de métier ! Choisis-en un parmi la liste :");

                player.sendMessage("§7- §aMineur");
                TextComponent min = new TextComponent("§8- ");
                TextComponent sous_min = new TextComponent("§7Mineur");
                sous_min.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Choisir le métier de §oMineur")));
                sous_min.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "job Mineur"));
                min.addExtra(sous_min);
                player.spigot().sendMessage(min);



                //player.sendMessage("§8> §cClique sur le métier que tu voudrais exercer.");
            }
        } else {
            player.sendMessage("Salut mke ekfkdsqdg");
        }
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
