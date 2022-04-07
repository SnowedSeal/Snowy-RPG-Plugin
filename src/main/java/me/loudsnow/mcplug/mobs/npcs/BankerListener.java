package me.loudsnow.mcplug.mobs.npcs;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class BankerListener implements Listener {
    @EventHandler
    public void onBankerOpen (InventoryDragEvent event) {
        final Player player = (Player) event.getWhoClicked();

        if(event.getInventory().equals(player.getEnderChest())){
            if (!event.getCursor().hasItemMeta()) {
                event.setCancelled(true);
            }

        }

    }
}
