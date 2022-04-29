package me.septicraft.mcplug.mobs;

import me.septicraft.mcplug.Main;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;


public class HorseDeath implements Listener {
    @EventHandler
    public void onHorseDeath(EntityDeathEvent e){
        if (e.getEntity() instanceof Horse) {
            Entity horse = e.getEntity();
            if (horse instanceof Horse){
                AnimalTamer p = ((Horse) horse).getOwner();
                Main.horseowner.remove(p.getUniqueId().toString());
                Main.horsealive.remove(p.getUniqueId().toString());
                e.getDrops().clear();

            }
        }
    }
}
