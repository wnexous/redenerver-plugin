package org.redenever.Setups;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class EconomySetup implements SetupsInterface {

    public Economy economy = null;

    public boolean EconomySetup(JavaPlugin javaPlugin) {
        RegisteredServiceProvider<Economy> economyProvider = javaPlugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return economy != null;
    }
}
