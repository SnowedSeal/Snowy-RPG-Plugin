package me.loudsnow.mcplug.cancelevents;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import static me.loudsnow.mcplug.Main.drop;

public class CancelItemPickup implements Listener {
    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        drop.put(e.getItemDrop().getUniqueId(), p.getUniqueId());

    }
    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent e){
        Player p = e.getPlayer();

        if (drop.containsKey(e.getItem().getUniqueId())){
            if (drop.get(e.getItem().getUniqueId()).equals(p.getUniqueId())) {

            } else {
                e.setCancelled(true);
            }
        } else {
            e.setCancelled(true);
        }
    }
}
