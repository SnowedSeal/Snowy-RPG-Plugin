package me.loudsnow.mcplug.cancelevents;

import com.mongodb.internal.operation.ChangeStreamOperation;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

public class CancelHorseRide implements Listener {
    @EventHandler
    public void onHorseRide(EntityMountEvent e){
        Player pl = (Player) e.getEntity();
        Horse horse = (Horse) e.getMount();
        if (horse.getOwner() == (pl)){

        } else {
            pl.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "This isn't your horse!");
            e.setCancelled(true);
        }


    }
}
