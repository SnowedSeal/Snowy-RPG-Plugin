package me.loudsnow.mcplug.cancelevents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.HorseInventory;

public class CancelSaddle implements Listener {
    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory() instanceof HorseInventory) {
            e.setCancelled(true);
        }
    }
}
// getTitle().equalsIgnoreCase("" + ChatColor.GOLD + ChatColor.BOLD + p.getName().toString() + ChatColor.YELLOW + ChatColor.BOLD + "'s horse")