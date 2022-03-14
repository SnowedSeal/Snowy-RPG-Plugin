package me.loudsnow.mcplug.cancelevents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import static me.loudsnow.mcplug.Main.instance;
/*
public class CancelDropEvent implements Listener {
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        ItemStack item = event.getItemDrop().getItemStack();
        Player p = event.getPlayer();
        event.setCancelled(true);
        NamespacedKey key = new NamespacedKey(instance, "dropper");
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, p.getUniqueId().toString());
        item.setItemMeta(meta);


    }
    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent e){

    }
}
*/