package me.loudsnow.mcplug.cancelevents;

import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;

public class CancelFire implements Listener {
    @EventHandler
    public void onEntityCombust(EntityCombustEvent e){
        if (e.getEntity() instanceof Zombie){
            e.setCancelled(true);
        }
    }
}
