package me.loudsnow.mcplug.npcs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

public class NPC5 implements Listener {
    @EventHandler
    public void onNpc5Click(PlayerInteractEntityEvent event) {
        Player p = (Player) event.getPlayer();
        if (event.getHand() == EquipmentSlot.HAND) {
            Entity entity = event.getRightClicked();
            String uuid = entity.getUniqueId().toString();
            Bukkit.broadcastMessage(uuid);
            if (uuid.equals("5e4c7b5b-117d-258e-b7d2-f0fa211b4041")) {
                p.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "Coming soon!");

            }

        }


    }
}
