package me.loudsnow.mcplug.weapons.meteorslam;

import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.List;

import static me.loudsnow.mcplug.Main.*;

public class MeteorSlamListener implements Listener {
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (event.getHand() == EquipmentSlot.HAND) {
            if (p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Meteor Slam")) {
                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (cd1.containsKey(p.getUniqueId().toString())) {
                        p.sendMessage(ChatColor.RED + "This object is on cooldown!");
                    } else {
                        p.setVelocity(new Vector(0, 2, 0));
                        hitground.remove(p.getUniqueId().toString());
                        cd1.put(p.getUniqueId().toString(), 0);
                        new BukkitRunnable() {
                            private int counter = 300;

                            @Override
                            public void run() {

                                if (hitground.containsKey(p.getUniqueId().toString())) {
                                    hitground.remove(p.getUniqueId().toString());
                                    this.cancel();
                                }
                                if (p.isOnGround()) {
                                    p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 100));
                                    // p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 0));
                                    Location location = p.getLocation();
                                    World world = p.getWorld();
                                    List<Entity> nearby = p.getNearbyEntities(4, 4, 4);
                                    for (Entity tmp : nearby)
                                        if (tmp instanceof Damageable)
                                            if (tmp instanceof Player || tmp instanceof Horse) {
                                                if (tmp.getUniqueId().toString().equals("56ff4351-bebe-2627-86b0-181cc8d4ff1c")) {
                                                    ((Damageable) tmp).damage(75, p);
                                                }
                                            } else {
                                                ((Damageable) tmp).damage(75, p);
                                            }
                                    world.spawnParticle(Particle.EXPLOSION_LARGE, location, 10, 1, 1, 1, 1);
                                    hitground.put(p.getUniqueId().toString(), 1);
                                    this.counter--;
                                }
                            }
                        }.runTaskTimer(instance, 10L, 0L);
                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            @Override
                            public void run() {
                                cd1.remove(p.getUniqueId().toString());
                                p.sendMessage(ChatColor.GREEN + "Meteor Slam is no longer on cooldown!");
                            }
                        }, 300);
                    }
                }

            }
        }
    }
}
