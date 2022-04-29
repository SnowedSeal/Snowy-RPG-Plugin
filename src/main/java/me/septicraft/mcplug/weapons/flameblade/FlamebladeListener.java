package me.septicraft.mcplug.weapons.flameblade;

import me.septicraft.mcplug.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class FlamebladeListener implements Listener {
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getHand() == (EquipmentSlot.HAND)) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Flameblade")) {

                    if (Main.cd8.containsKey(p.getUniqueId().toString())){
                        p.sendMessage(ChatColor.RED  + "This object is on cooldown!");
                    } else {
                        new BukkitRunnable() {
                            private int counter = 10;
                            float radius = 1f;

                            @Override
                            public void run() {
                                World world = p.getWorld();
                                Location location1 = p.getEyeLocation();
                                Location location2 = p.getEyeLocation();
                                Location location3 = p.getEyeLocation();
                                int particles = 50;
                                radius = radius + 0.3F;

                                for (int i = 0; i < particles; i++) {
                                    if (radius > 3.5f) {
                                        radius = 0.3f;
                                        this.cancel();
                                    }

                                    double angle, x, z;
                                    angle = 2 * Math.PI * i / particles;
                                    x = Math.cos(angle) * radius;
                                    z = Math.sin(angle) * radius;
                                    location1.add(x, 0, z);
                                    location2.add(x, -0.66, z);
                                    location3.add(x, -1.33, z);
                                    //world.spawnParticle(Particle.SMOKE_LARGE, location1, 0, 0, 0, 0, 1);
                                    //world.spawnParticle(Particle.SMOKE_LARGE, location2, 0, 0, 0, 0, 1);
                                    world.spawnParticle(Particle.CRIT_MAGIC, location3, 0, 0, 0, 0, 1);
                                    location1.subtract(x, 0, z);
                                    location2.subtract(x, -0.66, z);
                                    location3.subtract(x, -1.33, z);
                                }

                                this.counter--;
                            }
                        }.runTaskTimer(Main.instance, 0, 0);
                        Main.cd8.put(p.getUniqueId().toString(), 0);
                        p.sendMessage(ChatColor.GREEN + "Activated Flameblade!");
                        Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
                            @Override
                            public void run() {
                                Main.cd8.remove(p.getUniqueId().toString());
                                p.sendMessage(ChatColor.GREEN + "Flameblade is no longer on cooldown!");

                            }
                        }, 240);
                        for (Entity e1 : p.getNearbyEntities(4, 4, 4)) {
                            if (e1 instanceof Player) {


                            } else {
                                if (e1 instanceof LivingEntity) {
                                    LivingEntity nearby = (LivingEntity) e1;
                                    nearby.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 255));

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}