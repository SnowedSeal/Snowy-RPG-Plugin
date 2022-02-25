package me.loudsnow.mcplug;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class NPC implements Listener {
    @EventHandler
    public void onNpcClick(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        String uuid = entity.getUniqueId().toString();
        Bukkit.broadcastMessage(uuid);
        if (uuid.equals("14df8b0e-0bd7-27d4-81c6-e59fb8f0b208")){
            Bukkit.broadcastMessage("It works!");
        }




    }
}



