package me.loudsnow.mcplug.system;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.loudsnow.mcplug.Main.*;
import static org.bukkit.Bukkit.getServer;


public class TestHashCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;


            p.sendMessage(bank.toString());

        }
    return true;
    }
}
