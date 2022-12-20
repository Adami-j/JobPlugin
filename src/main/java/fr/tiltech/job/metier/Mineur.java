package fr.tiltech.job.metier;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class Mineur extends Metier{

    public Mineur(int niveau, Player player) {
        super(niveau, player);
    }

    @Override
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Salut t'es un mineur");
    }


}
