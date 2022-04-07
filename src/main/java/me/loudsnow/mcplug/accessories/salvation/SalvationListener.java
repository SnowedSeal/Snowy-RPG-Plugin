package me.loudsnow.mcplug.accessories.salvation;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class SalvationListener implements Listener {
    @EventHandler
    public void onDesolationAttack(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player){
            Player p = (Player) e.getDamager();
            Entity entity = e.getEntity();
            if (p.getInventory().getItemInOffHand().getItemMeta() != null && p.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Salvation")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 1));

            }
        } else {

        }
    }
}