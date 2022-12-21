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

        /*TextComponent testComp = new TextComponent("Test 1 premiere ligne");
        testComp.setColor(ChatColor.GOLD);
        TextComponent sub = new TextComponent("T'es un  ?");
        sub.setColor(ChatColor.AQUA);
        sub.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click mon reuf tqt c'est R")));
        sub.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.google.com/search?q=bite&rlz=1C1CHBD_frFR1004FR1004&sxsrf=ALiCzsZ_lz3PVJNBcByPTEnqa_VJM2s1Iw:1671651293572&source=lnms&tbm=isch&sa=X&ved=2ahUKEwidr6qsuov8AhVOasAKHeiwBacQ_AUoAXoECAEQAw&biw=3440&bih=1289&dpr=1"));
        testComp.addExtra(sub);
        testComp.addExtra("Rep ?");
        player.spigot().sendMessage(testComp);*/

        if (!player.isOp()) {
            //player.sendMessage("§3</§63iLTechServ§3> §6Bienvenue §3" + player.getName());
            if (!player.hasPermission("")) {
                player.sendMessage("§8> §cTu n'as pas de métier ! Choisis-en un parmi la liste :");
                /*player.sendMessage("§7- §aMineur");
                player.sendMessage("§7- §aGuerrier");
                player.sendMessage("§7- §aChimiste");
                player.sendMessage("§7- §aFermier\n");*/

                TextComponent min = new TextComponent("§8- ");
                TextComponent comb = new TextComponent("§8- ");
                TextComponent chim = new TextComponent("§8- ");
                TextComponent ferm = new TextComponent("§8- ");
                TextComponent sous_min = new TextComponent("§7Mineur");
                TextComponent sous_comb = new TextComponent("§cCombattant");
                TextComponent sous_chim = new TextComponent("§dChimiste");
                TextComponent sous_ferm = new TextComponent("§6Fermier");
                sous_min.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Choisir le métier de §oMineur")));
                sous_comb.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Choisir le métier de §oCombattant")));
                sous_chim.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Choisir le métier de §oChimiste")));
                sous_ferm.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Choisir le métier de §oFermier")));
                sous_min.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/im_min_rn"));
                sous_comb.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ""));
                sous_chim.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ""));
                sous_ferm.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ""));
                min.addExtra(sous_min);
                comb.addExtra(sous_comb);
                chim.addExtra(sous_chim);
                ferm.addExtra(sous_ferm);
                player.spigot().sendMessage(min);
                player.spigot().sendMessage(comb);
                player.spigot().sendMessage(chim);
                player.spigot().sendMessage(ferm);



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
