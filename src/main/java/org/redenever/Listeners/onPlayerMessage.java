package org.redenever.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onPlayerMessage implements Listener {

    public onPlayerMessage() {
        Bukkit.getConsoleSender().sendMessage("Starting OnPlayerMessage listener");
    }

    @EventHandler
    public void onEvent(AsyncPlayerChatEvent event) {

    }
}
