package fr.tiltech.job.metier;

import org.bukkit.entity.Player;

public abstract class Metier {

    private String nomMetier;

    private int niveau;

    private Player player;

    public Metier(String nomMetier, int niveau, Player player) {
        this.nomMetier = nomMetier;
        this.niveau = niveau;
        this.player = player.getPlayer();
    }



}
