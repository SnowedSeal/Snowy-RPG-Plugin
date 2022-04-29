package me.septicraft.mcplug.cancelevents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CancelPVP implements Listener {
    @EventHandler
    public void onPVP(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player){
            if (e.getDamager() instanceof Player) {
                e.setCancelled(true);
            }
        }
    }
}
