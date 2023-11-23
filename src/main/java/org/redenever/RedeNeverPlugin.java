package org.redenever;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.redenever.Commands.RedeNeverCommand;
import org.redenever.Listeners.*;
import org.redenever.Setups.RedeNeverSetups;

import java.io.File;

public final class RedeNeverPlugin extends JavaPlugin {

//    FileConfiguration fileConfig = getFileConfig();

    @Override
    public void onEnable() {

//        String pluginName = fileConfig.getString("plugin-name");
//        // Plugin startup logic
//        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + String.format("starting %s", pluginName));

        new RedeNeverListener(this);
        new RedeNeverCommand(this);
        new RedeNeverSetups();

    }

    @Override
    public void onDisable() {
        //  Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "disabling rede-never plugin.");
    }

    public FileConfiguration getFileConfig() {
        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists()) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "config.yml file not exists. Saving a default file on plugins folder.");
            saveDefaultConfig();
        }
        return getConfig();
    }
}
