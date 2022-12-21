package fr.tiltech.job.metier;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Metier extends JavaPlugin implements Listener {

    private int niveau;
    private Player player;

    public Metier(int niveau, Player player) {
        this.niveau = niveau;
        this.player = player.getPlayer();
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

    }

}
