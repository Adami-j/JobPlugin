package fr.tiltech.job.Listener;

import fr.tiltech.job.Command.JobCommand;
import fr.tiltech.job.Job;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class PlayerInteract implements Listener {

    private final Job plugin;
    private JobCommand jobs;

    public PlayerInteract(Job plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        Action action = e.getAction();
        ItemStack it = e.getItem();

        if(it!=null && it.getType() == Material.COMPASS && action == Action.RIGHT_CLICK_AIR ){

            Inventory gui = Bukkit.getServer().createInventory(player, 9, "Main");

            /*for(String s : jobs.getJobs()){
                ItemStack boussole1 = new ItemStack(Material.COMPASS);
                ItemMeta itemMeta = (ItemMeta) boussole1.getItemMeta();
                List<String> listTmp = new ArrayList<>();
                listTmp.add(s);
                itemMeta.setLore(listTmp);
                boussole1.setItemMeta(itemMeta);
                gui.addItem(boussole1);
            }*/
            player.openInventory(gui);


        }

    }

    @EventHandler
    public void onCompassOpen(InventoryClickEvent event) {
        if(event!=null && event.getClick().isRightClick()){
            event.getView().close();
        }
        if(event!=null
                && event.getClick().isLeftClick()
                && event.getCurrentItem()!=null
                && event.getCurrentItem().getItemMeta()!=null
                && event.getCurrentItem().getItemMeta().getAsString()!=null){

            switch (event.getCurrentItem().getItemMeta().getLore().toString()){
                case "[Miner]" :
                    event.getView().getPlayer().sendMessage("Tu es maintenant un mineur");
                    event.getView().close();
                    break;
                case "[Fighter]" :
                    event.getView().getPlayer().sendMessage("Tu es maintenant un combatant");
                    event.getView().close();
                    break;
                case "[Farmer]" :
                    event.getView().getPlayer().sendMessage("Tu es maintenant un fermier");
                    event.getView().close();
                    break;
                case "[Chemist]":
                    event.getView().getPlayer().sendMessage("Tu es maintenant un chimiste");
                    event.getView().close();
                    break;
            }
        }

    }
}
