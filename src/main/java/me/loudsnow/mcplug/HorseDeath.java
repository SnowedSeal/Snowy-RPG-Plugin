package me.loudsnow.mcplug;

import org.bukkit.Material;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import static me.loudsnow.mcplug.Main.horsealive;
import static me.loudsnow.mcplug.Main.horseowner;


public class HorseDeath implements Listener {
    @EventHandler
    public void onHorseDeath(EntityDeathEvent e){
        if (e.getEntity() instanceof Horse) {
            Entity horse = e.getEntity();
            if (horse instanceof Horse){
                AnimalTamer p = ((Horse) horse).getOwner();
                horseowner.remove(p.getUniqueId().toString());
                horsealive.remove(p.getUniqueId().toString());
                e.getDrops().clear();

            }
        }
    }
}
