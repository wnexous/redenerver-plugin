package org.redenever.Commands;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ProfileCommand implements CommandsInterface {

    @Override
    public String getCommandText() {
        return "perfil";
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

//        cast current player
        Player currentPlayer = (Player) commandSender;

//        get target player
        String targetPlayerName = strings[0];
        Player targetPlayer = Bukkit.getPlayer(targetPlayerName);


        if (targetPlayer.isOnline()) {
            currentPlayer.sendMessage(ChatColor.DARK_PURPLE + "Voce ta abrindo o inventario de: " + targetPlayerName);
            targetPlayer.sendMessage(ChatColor.LIGHT_PURPLE + "Seu inventario foi abrido por: " + currentPlayer.getName());

            //  add potion effect on player
            targetPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 3));

            //        show profile
            Inventory createdInventory = Bukkit.createInventory(null, 45, ChatColor.DARK_RED + "Inventario de: " + targetPlayer.getName());
            Inventory targetPlayerInventory = targetPlayer.getInventory();

            ItemStack targetArmorHelmet = targetPlayer.getInventory().getHelmet();
            ItemStack targetArmorChestplate = targetPlayer.getInventory().getChestplate();
            ItemStack targetArmorLeggings = targetPlayer.getInventory().getLeggings();
            ItemStack targetArmorBoots = targetPlayer.getInventory().getBoots();

            for (int inventoryIndex = 0; inventoryIndex < 36; inventoryIndex++) {
                ItemStack targetInventoryItem = targetPlayerInventory.getItem(35 - inventoryIndex);
                createdInventory.setItem(inventoryIndex, targetInventoryItem);
            }

//            set armor
            createdInventory.setItem(44, targetArmorBoots);
            createdInventory.setItem(43, targetArmorLeggings);
            createdInventory.setItem(42, targetArmorChestplate);
            createdInventory.setItem(41, targetArmorHelmet);

            currentPlayer.openInventory(createdInventory);

        } else currentPlayer.sendMessage(ChatColor.RED + "esse cara ai nao ta online mano :(");

        return true;
    }
}


