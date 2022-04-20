package me.septicraft.mcplug.mobs;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class HealthBar implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent e){
        if (e.getEntity() instanceof Zombie) {
            Zombie entity = (Zombie) e.getEntity();
            int maxhealthrounded = (int) Math.round(entity.getMaxHealth());
            int damage = (int) Math.round(e.getDamage());
            int healthrounded = (int) Math.round(entity.getHealth()) - damage;
            if (healthrounded <= 0){
                entity.setCustomName("" + ChatColor.RED + ChatColor.BOLD +  "0/" + maxhealthrounded);
            } else{
                entity.setCustomName("" + ChatColor.RED + ChatColor.BOLD + healthrounded + "/" + maxhealthrounded);
            }
        }
    }
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e){
        Entity damager = e.getDamager();
        Entity en = e.getEntity();
        if (en instanceof LivingEntity) {
            if (e.getDamage() > ((LivingEntity) en).getHealth()){
                if (damager instanceof Player){
                    ((Player) damager).playSound(e.getEntity().getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 10, 10);
                }
            }
        }
    }
}
