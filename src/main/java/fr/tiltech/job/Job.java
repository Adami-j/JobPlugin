package fr.tiltech.job;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import fr.tiltech.job.Listener.PlayerJoin;

import java.io.File;
import java.io.IOException;

public final class Job extends JavaPlugin {
    FileConfiguration config = getConfig();
    private File customConfigFile;
    private FileConfiguration customConfig;

    private static boolean papiEnabled = false;

    @Override
    public void onEnable() {
        // Enable Configuration
        createCustomConfig();
        config.options().copyDefaults(true);
        saveConfig();


        System.out.println(ChatColor.GREEN + "Enable plugin");
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            this.getLogger().info("PlaceholderAPI detected.");
            Job.papiEnabled = true;
        } else {
            this.getLogger().info("PlaceholderAPI not detected.");
        }

    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.RED + "Disable plugin");
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "custom.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("custom.yml", false);
        }

        customConfig = new YamlConfiguration();

        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
