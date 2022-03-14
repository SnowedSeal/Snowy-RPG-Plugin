package me.loudsnow.mcplug;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.loudsnow.mcplug.Main.horse;
import static me.loudsnow.mcplug.Main.horsealive;

public class QuitEvent implements Listener {
    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent e){
        Player p = e.getPlayer();
        World world = p.getWorld();
        for(World w : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()){
                if (entity instanceof Horse) {
                    if (((Horse) entity).getOwner() != null) {
                        if (((Horse) entity).getOwner().equals(p)) {
                            entity.remove();
                            horsealive.remove(p.getUniqueId().toString());
                        }
                    }
                }
            }
        }
    }
}
