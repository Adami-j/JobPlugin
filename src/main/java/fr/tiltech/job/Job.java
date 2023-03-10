package fr.tiltech.job;

import fr.tiltech.job.Command.JobCommand;
import fr.tiltech.job.Command.ReloadCommand;
import fr.tiltech.job.Listener.PlayerInteract;
import fr.tiltech.job.Listener.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Job extends JavaPlugin {
    FileConfiguration config = getConfig();
    FileConfiguration customConfig;
    File customConfigFile;
    private static boolean papiEnabled = false;

    public static Job getInstance() {
        return getPlugin(Job.class);
    }

    @Override
    public void onEnable() {
        // Enable Configuration
        config.options().copyDefaults(true);
        saveConfig();
        createCustomConfig();


        System.out.println(ChatColor.GREEN + "Enable plugin");
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(this), this);
        getCommand("job").setExecutor(new JobCommand(this));
        getCommand("jobs").setExecutor(new JobCommand(this));
        //getCommand("infolvl").setExecutor(new JobCommand(this));
        //getCommand("warptool").setExecutor(new JobCommand(this));
        //getCommand("perms").setExecutor(new OpCommand(this));
        getCommand("jp").setExecutor(new ReloadCommand(this));

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

    public void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "players.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("players.yml", false);
        }
        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<String> getJobs() {
        return new ArrayList<>(this.getConfig().getConfigurationSection("jobs").getKeys(false));
    }

}
