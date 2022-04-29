package me.septicraft.mcplug.system.discord;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DeathEvent implements Listener {
    public static void deathMessage(Player p){
        p.teleport(new Location(p.getWorld(), 149, 111, 31));
        p.sendTitle("" + ChatColor.RED + ChatColor.BOLD + "You Died", "", 10, 40, 10);
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 10, false));
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 10, false));
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        e.setCancelled(true);
    }
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e){

        if (e.getEntity() instanceof Player) {

            Player p = (Player) e.getEntity();
            if (p.getLastDamage() >= p.getHealth()) {
                e.setCancelled(true);
                p.setHealth(3);
                p.teleport(new Location(Bukkit.getWorld("world"), 149, 111, 31, 0, 0));
                EntityDamageEvent.@NotNull DamageCause dc = e.getEntity().getLastDamageCause().getCause();
                String name = p.getName();
                if (dc.equals(EntityDamageEvent.DamageCause.FLY_INTO_WALL)) {
                    Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + name + "'s brains are all over the wall!");
                    DeathEvent.deathMessage(p);
                } else if (dc.equals(EntityDamageEvent.DamageCause.DROWNING)) {
                    Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + name + " ran out of air.");
                    DeathEvent.deathMessage(p);
                } else if (dc.equals(EntityDamageEvent.DamageCause.FIRE)) {
                    Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + name + " was burned alive!");
                    DeathEvent.deathMessage(p);
                }else if (dc.equals(EntityDamageEvent.DamageCause.CUSTOM)) {
                    Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + name + " died!");
                    DeathEvent.deathMessage(p);
                } else if (dc.equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                    if (p.getLastDamageCause().getEntity().getType().equals(EntityType.ZOMBIE)) {
                        if (p.getVehicle() != null) {
                            Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + name + " died riding into zombies on a horse!");
                            DeathEvent.deathMessage(p);
                        }
                    } else {
                        Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + name + " died in a way that isn't implemented! Please report this!");
                        DeathEvent.deathMessage(p);
                    }
                } else {
                    Bukkit.broadcastMessage("" + ChatColor.RED + ChatColor.BOLD + name + " died in a way that isn't implemented! Please report this!");
                    DeathEvent.deathMessage(p);

                }
            }

        }
    }
}
