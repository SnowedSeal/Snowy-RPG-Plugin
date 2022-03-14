package me.loudsnow.mcplug.cancelevents;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class CancelHorseDamage implements Listener {
    @EventHandler
    public void onHorseDamage(EntityDamageByEntityEvent e){
        Entity entity = e.getDamager();
        Entity entity1 = e.getEntity();
        if (entity1 instanceof Horse){
            if (entity instanceof Player) {
                e.setCancelled(true);
            }
        }
    }
}
