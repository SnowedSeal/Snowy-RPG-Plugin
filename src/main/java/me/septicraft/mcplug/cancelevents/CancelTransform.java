package me.septicraft.mcplug.cancelevents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTransformEvent;

public class CancelTransform implements Listener {
    @EventHandler
    public void onTransformEvent(EntityTransformEvent e){
        e.setCancelled(true);
    }
}
