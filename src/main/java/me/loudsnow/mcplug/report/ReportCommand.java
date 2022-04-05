package me.loudsnow.mcplug.report;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.loudsnow.mcplug.Main.*;

public class ReportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cd9.containsKey(p.getUniqueId().toString())){
                p.sendMessage(ChatColor.RED + "You need to wait 2 minutes in between reports!");
            } else {
                cd9.put(p.getUniqueId().toString(), 0);
                Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                    @Override
                    public void run() {
                        cd9.remove(p.getUniqueId().toString());
                    }
                }, 2560);
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "Usage: /report bug/abuse/error/death");

                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("bug")) {
                        bugBoolean.put(p.getUniqueId().toString(), true);
                        p.sendMessage(ChatColor.GREEN + "Please provide more info in the chat!");
                    } else if (args[0].equalsIgnoreCase("abuse")) {
                        abuseBoolean.put(p.getUniqueId().toString(), true);
                        p.sendMessage(ChatColor.GREEN + "Please provide more info in the chat!");
                    } else if (args[0].equalsIgnoreCase("error")) {
                        errorBoolean.put(p.getUniqueId().toString(), true);
                        p.sendMessage(ChatColor.GREEN + "Please provide more info in the chat!");
                    } else if (args[0].equalsIgnoreCase("death")) {
                        deathBoolean.put(p.getUniqueId().toString(), true);
                        p.sendMessage(ChatColor.GREEN + "Please provide more info in the chat!");
                    }
                }
            }
        }
        return true;
    }
}
