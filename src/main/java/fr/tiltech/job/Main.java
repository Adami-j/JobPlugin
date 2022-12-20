package fr.tiltech.job;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import fr.tiltech.job.Listener.PlayerJoin;

public final class Main extends JavaPlugin {
    FileConfiguration config = getConfig();

    private static boolean papiEnabled = false;

    @Override
    public void onEnable() {
        // Enable Configuration
        config.options().copyDefaults(true);
        saveConfig();


        System.out.println(ChatColor.GREEN + "Enable plugin");
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            this.getLogger().info("PlaceholderAPI detected.");
            Main.papiEnabled = true;
        } else {
            this.getLogger().info("PlaceholderAPI not detected.");
        }

    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "Disable plugin");
    }

}
