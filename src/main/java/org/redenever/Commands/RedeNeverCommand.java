package org.redenever.Commands;


import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class RedeNeverCommand {

    CommandsInterface[] commandsArray = {new ProfileCommand()};

    public RedeNeverCommand(JavaPlugin javaplugin) {
        for (CommandsInterface cExec : commandsArray) {
            javaplugin.getCommand(cExec.getCommandText()).setExecutor(cExec);
        }
    }
}


