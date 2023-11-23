package org.redenever.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class LixoCommand implements CommandsInterface {
    @Override
    public String getCommandText() {
        return "lixo";
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player currentPlayer = (Player) commandSender;
        Inventory trashInventory = Bukkit.createInventory(null, 54, ChatColor.DARK_AQUA + "Deposite seu lixo aqui");
        currentPlayer.openInventory(trashInventory);
        return true;
    }
}
