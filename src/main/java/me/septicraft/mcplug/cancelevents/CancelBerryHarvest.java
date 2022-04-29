package me.septicraft.mcplug.cancelevents;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.net.http.WebSocket;

public class CancelBerryHarvest implements Listener {
    @EventHandler
    public void onBerryHarvest(PlayerInteractEvent e){
        if (e.getClickedBlock() != null && e.getClickedBlock().getType().equals(Material.SWEET_BERRY_BUSH)) {
            e.setCancelled(true);
        }
    }
}
