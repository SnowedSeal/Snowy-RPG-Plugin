package me.loudsnow.mcplug;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.loudsnow.mcplug.Main.horsealive;
import static me.loudsnow.mcplug.Main.horseowner;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("" + ChatColor.GREEN + ChatColor.BOLD + p.getName() + " joined the server!");
        if (horseowner.containsKey(p.getUniqueId().toString())) {
            p.sendMessage(ChatColor.YELLOW + "Use /whistle to summon your horse!");

        }
    }
}
