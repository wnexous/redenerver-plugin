package org.redenever.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class RedeNeverListener {

    Listener[] listenersArray = {new onPlayerMessage()};

    public RedeNeverListener(JavaPlugin javaPlugin) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "starting listeners");

        for (Listener eventListener : listenersArray)
            Bukkit.getServer().getPluginManager().registerEvents(eventListener, javaPlugin);
    }
}
