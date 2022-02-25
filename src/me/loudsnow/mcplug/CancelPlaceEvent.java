package me.loudsnow.mcplug;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class CancelPlaceEvent implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if (player.getDisplayName().equals("RGolden")) {
        }
        else if (player.getDisplayName().equals("Loudbook")) {
        }
        else if (player.getDisplayName().equals("FabledLivid")) {
        }
        else {
            event.setCancelled(true);

        }
    }
}