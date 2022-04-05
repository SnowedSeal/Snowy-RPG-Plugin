package me.loudsnow.mcplug.mobdeaths;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static me.loudsnow.mcplug.Main.instance;

public class lvl1death implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent ev) {
        NamespacedKey namespacedKey = new NamespacedKey(instance, "level");
        PersistentDataContainer levels = ev.getEntity().getPersistentDataContainer();
        if (levels.has(namespacedKey, PersistentDataType.STRING)) {
            if (levels.get(namespacedKey, PersistentDataType.STRING).contains("1")) {
                Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                    @Override
                    public void run() {
                        World world = ev.getEntity().getWorld();
                        int xmax = 229;
                        int xmin = 97;
                        int zmax = 130;
                        int zmin = -50;

                        int xrandom = (int)Math.floor(Math.random()*(xmax-xmin+1)+xmin);
                        int zrandom = (int)Math.floor(Math.random()*(zmax-zmin+1)+zmin);
                        while (xrandom > 108 && xrandom < 196 && zrandom > 1 && zrandom < 92){
                            xrandom = (int) Math.floor(Math.random() * (xmax - xmin + 1) + xmin);
                            zrandom = (int)Math.floor(Math.random()*(zmax-zmin+1)+zmin);
                        }
                        //  if (world.getHighestBlockAt(xrandom, zrandom).getBlockData().getMaterial().equals(Material.WATER) || world.getHighestBlockAt(xrandom, zrandom).getBlockData().getMaterial().equals(Material.AZALEA_LEAVES)){
                        // } else {
                        final double[] count = {7};
                        int finalXrandom1 = xrandom;
                        int finalZrandom1 = zrandom;
                        int locy = world.getHighestBlockAt(finalXrandom1, finalZrandom1).getY() + 1;
                        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
                            @Override
                            public void run() {
                                if (world.getHighestBlockAt(finalXrandom1, finalZrandom1).getBlockData().getMaterial().equals(Material.WATER) || world.getHighestBlockAt(finalXrandom1, finalZrandom1).getBlockData().getMaterial().equals(Material.AZALEA_LEAVES)|| world.getHighestBlockAt(finalXrandom1, finalZrandom1).getY() >= 115){
                                } else {
                                    count[0] = count[0] - 0.5;
                                    Location entityloc = new Location(world, finalXrandom1, world.getHighestBlockAt(finalXrandom1, finalZrandom1).getY() + count[0], finalZrandom1);
                                    world.spawnParticle(Particle.SMOKE_LARGE, entityloc, 10, 0, 0, 0, 0.1);
                                }
                            }
                        }, 5, 2);
                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            @Override
                            public void run() {
                                int i = 0;
                                double locysblock = world.getHighestBlockAt(finalXrandom1, finalZrandom1).getY();
//                                Block block = world.getHighestBlockAt(finalXrandom1, finalZrandom1);
//                                while (!block.getBlockData().getMaterial().equals(Material.GRASS_BLOCK) || !block.getBlockData().getMaterial().equals(Material.DIRT) || !block.getBlockData().getMaterial().equals(Material.WATER)) {
//                                    i++;
//                                    locysblock = block.getLocation().getY() - i;
//                                    block = world.getBlockAt(finalXrandom1, (int) locysblock, finalZrandom1);
//                                    if (i >= 20){
//                                        Bukkit.broadcastMessage(ChatColor.RED + "Failed to find suitible spawning location! Error at: "  + finalXrandom1 + ", " + finalZrandom1);
//                                        break;
//                                    }
//                                }
                                if (world.getHighestBlockAt(finalXrandom1, finalZrandom1).getBlockData().getMaterial().equals(Material.WATER) || world.getHighestBlockAt(finalXrandom1, finalZrandom1).getBlockData().getMaterial().equals(Material.AZALEA_LEAVES)){
                                } else {
                                    Location loc = new Location(world, finalXrandom1, locy, finalZrandom1);
                                    Zombie mob = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
                                    PersistentDataContainer levels = mob.getPersistentDataContainer();
                                    levels.set(namespacedKey, PersistentDataType.STRING, "1");
                                    AttributeInstance health = mob.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                                    health.setBaseValue(40.0D);
                                    mob.setRemoveWhenFarAway(false);
                                    mob.setHealth(40.0D);
                                    AttributeInstance strength = mob.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
                                    mob.setCustomNameVisible(true);
                                    strength.setBaseValue(10.0D);
                                    int healthrounded = (int) Math.round(mob.getHealth());
                                    int maxhealthrounded = (int) Math.round(mob.getMaxHealth());
                                    mob.setCustomName("" + ChatColor.RED + ChatColor.BOLD + healthrounded + "/" + maxhealthrounded);
                                    mob.setPersistent(true);
                                    mob.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                                    mob.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                                    world.spawnParticle(Particle.DRAGON_BREATH, mob.getLocation(), 50, 0, 0, 0, 0.05);
                                }
                            }
                        }, 27);
                    }
                }, 20);
            }
        }
    }
}