package me.septicraft.mcplug.armor.aetherarmor;

import me.septicraft.mcplug.system.Util;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.UUID;

public class AetherArmorListener implements Listener {
    @EventHandler
    public void onPlayerCrouch (PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        if (p.isSneaking()) {
            if (p.getInventory().getBoots() != null && p.getInventory().getBoots().getItemMeta().getDisplayName().equals("" + ChatColor.WHITE + ChatColor.BOLD + "Aether Boots")) {
                if (e.getPlayer().isOnGround()) {
                    Util.cooldown(p, p.getInventory().getBoots(), "Aether Boots", 100);
                }
            }
        }
    }
}
