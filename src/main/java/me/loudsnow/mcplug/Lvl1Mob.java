package me.loudsnow.mcplug;

import lombok.Builder;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static me.loudsnow.mcplug.Main.instance;

public class Lvl1Mob implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        int i;
        int n;

        Player p = (Player) sender;
        World world = p.getWorld();
        NamespacedKey namespacedKey = new NamespacedKey(instance, "level");

        for (Entity e : world.getEntities()){
            if (e instanceof Zombie){
                PersistentDataContainer levels = e.getPersistentDataContainer();
                if (levels.has(namespacedKey, PersistentDataType.STRING)){
                    if (levels.get(namespacedKey, PersistentDataType.STRING).contains("1")){
                        e.remove();
                        /*
                        String level = levels.get(namespacedKey, PersistentDataType.STRING);
                    if (e.getCustomName() != null && e.getCustomName().equals("" + ChatColor.GRAY + ChatColor.BOLD + "Level 1")){
                        */
                    }
                }
            }
        }
        p.sendMessage(ChatColor.GREEN + "Starting Spawn...");
        for (i = 0; i < 75; i++){
            int xmax = 229;
            int xmin = 97;
            int zmax = 130;
            int zmin = -50;
            int xrandom = (int)Math.floor(Math.random()*(xmax-xmin+1)+xmin);
            int zrandom = (int)Math.floor(Math.random()*(zmax-zmin+1)+zmin);

            if (xrandom < 108 && xrandom > 196 && zrandom < 1 && zrandom > 92) {
                final double[] count = {7};
                int finalXrandom = xrandom;
                int finalZrandom = zrandom;
                int locy = world.getHighestBlockAt(xrandom, zrandom).getY() + 1;
                Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
                    @Override
                    public void run() {
                        count[0] = count[0] - 0.5;
                        Location entityloc = new Location(world, finalXrandom, locy + count[0], finalZrandom);
                        world.spawnParticle(Particle.SMOKE_LARGE, entityloc, 10, 0, 0, 0, 0.5);
                    }
                }, 5, 2);
                int finalXrandom1 = xrandom;
                int finalZrandom1 = zrandom;
                Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                    @Override
                    public void run() {
                        Location loc = new Location(world, finalXrandom1, locy, finalZrandom1);
                        Zombie mob = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
                        PersistentDataContainer levels = mob.getPersistentDataContainer();
                        levels.set(namespacedKey, PersistentDataType.STRING, "1");
                        AttributeInstance health = mob.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                        health.setBaseValue(40.0D);
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


                        world.spawnParticle(Particle.SPELL_WITCH, mob.getLocation(), 50, 0, 0, 0, 0);
                    }
                }, 24);


            }

            while (xrandom < 108 && xrandom > 196){
                xrandom = (int) Math.floor(Math.random() * (xmax - xmin + 1) + xmin);
                if (xrandom > 108 && xrandom < 196 && zrandom > 1 && zrandom < 92) {
                } else {
                    if (world.getHighestBlockAt(xrandom, zrandom).getBlockData().getMaterial().equals(Material.WATER) || world.getHighestBlockAt(xrandom, zrandom).getBlockData().getMaterial().equals(Material.AZALEA_LEAVES)){
                    } else {
                        int locy = world.getHighestBlockAt(xrandom, zrandom).getY() + 1;
                        final double[] count = {7};
                        int finalXrandom = xrandom;
                        int finalZrandom = zrandom;
                        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
                            @Override
                            public void run() {
                                count[0] = count[0] - 0.5;
                                Location entityloc = new Location(world, finalXrandom, locy + count[0], finalZrandom);
                                world.spawnParticle(Particle.SMOKE_LARGE, entityloc, 10, 0, 0, 0, 0.5);
                            }
                        }, 5, 2);
                        int finalXrandom1 = xrandom;
                        int finalZrandom1 = zrandom;
                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            @Override
                            public void run() {
                                Location loc = new Location(world, finalXrandom1, locy, finalZrandom1);
                                Zombie mob = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
                                PersistentDataContainer levels = mob.getPersistentDataContainer();
                                levels.set(namespacedKey, PersistentDataType.STRING, "1");
                                AttributeInstance health = mob.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                                health.setBaseValue(40.0D);
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
                                float radius = 0.3f;
                                Location location1 = mob.getEyeLocation();
                                Location location2 = mob.getEyeLocation();
                                Location location3 = mob.getEyeLocation();
                                world.spawnParticle(Particle.SPELL_WITCH, mob.getLocation(), 50, 0, 0, 0, 0);
                            }
                        }, 24);


                    }
                }
            }
            while (zrandom > 1 && zrandom < 92){
                zrandom = (int)Math.floor(Math.random()*(zmax-zmin+1)+zmin);
                if (xrandom > 108 && xrandom < 196 && zrandom > 1 && zrandom < 92) {
                } else {
                    if (world.getHighestBlockAt(xrandom, zrandom).getBlockData().getMaterial().equals(Material.WATER) || world.getHighestBlockAt(xrandom, zrandom).getBlockData().getMaterial().equals(Material.AZALEA_LEAVES)){
                    } else {
                        final double[] count = {7};
                        int finalXrandom = xrandom;
                        int finalZrandom = zrandom;
                        int locy = world.getHighestBlockAt(xrandom, zrandom).getY() + 1;
                        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
                            @Override
                            public void run() {
                                count[0] = count[0] - 0.5;
                                Location entityloc = new Location(world, finalXrandom, locy + count[0], finalZrandom);
                                world.spawnParticle(Particle.SMOKE_LARGE, entityloc, 10, 0, 0, 0, 0.5);
                            }
                        }, 5, 2);
                        int finalXrandom1 = xrandom;
                        int finalZrandom1 = zrandom;
                        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                            @Override
                            public void run() {
                                Location loc = new Location(world, finalXrandom1, locy, finalZrandom1);
                                Zombie mob = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
                                PersistentDataContainer levels = mob.getPersistentDataContainer();
                                levels.set(namespacedKey, PersistentDataType.STRING, "1");
                                AttributeInstance health = mob.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                                health.setBaseValue(40.0D);
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
                                world.spawnParticle(Particle.SPELL_WITCH, mob.getLocation(), 50, 0, 0, 0, 0);
                            }
                        }, 24);

                    }
                }
            }
        }
        return true;
    }
}