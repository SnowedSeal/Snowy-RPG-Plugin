package me.septicraft.mcplug.cancelevents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class CancelSandFall implements Listener {
    @EventHandler
    public void onFallingBlockLand(EntityChangeBlockEvent ev){
        ev.setCancelled(true);
    }
}
