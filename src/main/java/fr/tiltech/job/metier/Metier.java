package fr.tiltech.job.metier;

import org.bukkit.entity.Player;

public abstract class Metier {

    private int niveau;

    private Player player;

    public Metier(int niveau, Player player) {
        this.niveau = niveau;
        this.player = player.getPlayer();
    }



}
