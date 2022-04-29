package me.septicraft.mcplug.mobs.npcs;

import me.septicraft.mcplug.Main;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class HorseListener implements Listener {
    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Horse Shop")) {
            e.setCancelled(true);


            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("" + ChatColor.GOLD + ChatColor.BOLD + "Buy a horse")) {
                        Player p = (Player) e.getWhoClicked();
                        e.setCancelled(true);
                        if (!Main.cd3.containsKey(p.getUniqueId().toString())){


                            if (p.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 128)) {

                                if (!Main.horse.containsKey(p.getUniqueId().toString())) {
                                    Location location = p.getLocation();
                                    p.playSound(location, Sound.BLOCK_NOTE_BLOCK_GUITAR, 5.0F, 0.5F);
                                    Main.horse.put(p.getUniqueId().toString(), 0);
                                    p.sendMessage(ChatColor.RED + "Are you sure you would like to buy a horse for 128 coins?");
                                    Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
                                        @Override
                                        public void run() {
                                            Main.horse.remove(p.getUniqueId().toString());

                                        }
                                    }, 60);
                                } else {
                                    if (!Main.horseowner.containsKey(p.getUniqueId().toString())) {
                                        if (!Main.horsealive.containsKey(p.getUniqueId().toString())) {
                                            Main.horseowner.put(p.getUniqueId().toString(), "true");
                                            p.sendMessage(ChatColor.GREEN + "Successfully purchased Horse!");
                                            Main.horse.remove(p.getUniqueId().toString());
                                            Location location = p.getLocation();
                                            p.playSound(location, Sound.BLOCK_NOTE_BLOCK_FLUTE, 5.0F, 0.5F);
                                            p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 128)});

                                            Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
                                            horse.setCustomNameVisible(true);
                                            horse.setCustomName("" + ChatColor.GOLD + ChatColor.BOLD + p.getName() + "'s " + ChatColor.YELLOW + ChatColor.BOLD + "horse");
                                            horse.setOwner(p);
                                            horse.isAdult();
                                            horse.setColor(Horse.Color.WHITE);
                                            horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
                                            horse.setJumpStrength(0.8);
                                            horse.setHealth(14);
                                            horse.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.3);
                                            horse.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(14);

                                            Main.horsealive.put(p.getUniqueId().toString(), 0);
                                            Main.cd3.put(p.getUniqueId().toString(), 0);
                                            Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
                                                @Override
                                                public void run() {
                                                    Main.cd3.remove(p.getUniqueId().toString());
                                                }
                                            }, 10L);
                                        }

                                    } else {
                                        p.sendMessage(ChatColor.RED + "You already own a horse!");
                                    }
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "You can't afford this...");
                                Location location = p.getLocation();
                                p.playSound(location, Sound.BLOCK_AMETHYST_BLOCK_BREAK, 5.0F, 5.0F);
                            }
                        }
                    }
                }
            }
        }
    }
}
