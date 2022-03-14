package me.loudsnow.mcplug;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static me.loudsnow.mcplug.Main.player;
import static org.bukkit.Bukkit.getServer;


class TestHashCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage();
            if (player.get(p.getUniqueId().toString()) !=null) {
                String uuid = p.getUniqueId().toString();
                String stri = player.get(p.getUniqueId().toString());
                int inte = Integer.parseInt(stri);
                inte = inte++;
                String strin = String.valueOf(inte);

                player.put(p.getUniqueId().toString(), strin);

                p.sendMessage(player.toString());
            } else {
                player.put(p.getUniqueId().toString(), "0");
            }
        }
    return true;
    }
}
