package fr.tiltech.job.Listener;

import fr.tiltech.job.Command.JobCommand;
import fr.tiltech.job.Job;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerDestroy implements Listener {

    private final Job plugin;
    private final JobCommand jobc;

    public PlayerDestroy(Job plugin, JobCommand jobc) {
        this.plugin = plugin;
        this.jobc = jobc;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
    }

}
