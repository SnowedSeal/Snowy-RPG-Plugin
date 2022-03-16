package me.loudsnow.mcplug.npcs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static me.loudsnow.mcplug.Main.bank;

public class BankerWithdraw implements Listener {
    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("§6§lBank")) {
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta() != null) {
                Player player = (Player) e.getWhoClicked();
                e.getCurrentItem().getItemMeta().getDisplayName();
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lWithdraw 16 Coins")) {
                    e.setCancelled(true);
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        int num = bank.get(playerKey);
                        if (num >= 16) {
                            bank.put(playerKey, num - 16);
                            int num1 = bank.get(playerKey);
                            player.sendMessage("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Withdrawing Coins");
                            ItemStack sunflower = new ItemStack(Material.SUNFLOWER, 16);
                            player.getInventory().addItem(sunflower);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your account!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK HASH; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lWithdraw 1 Coin")) {
                    e.setCancelled(true);
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        int num = bank.get(playerKey);
                        if (num >= 1) {
                            bank.put(playerKey, num - 1);
                            int num1 = bank.get(playerKey);
                            player.sendMessage("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Withdrawing Coins");
                            ItemStack sunflower = new ItemStack(Material.SUNFLOWER);
                            player.getInventory().addItem(sunflower);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your account!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lWithdraw 32 Coins")) {
                    e.setCancelled(true);
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        int num = bank.get(playerKey);
                        if (num >= 32) {
                            bank.put(playerKey, num - 32);
                            int num1 = bank.get(playerKey);
                            player.sendMessage("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Withdrawing Coins");
                            ItemStack sunflower = new ItemStack(Material.SUNFLOWER, 32);
                            player.getInventory().addItem(sunflower);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Balance: " + num1);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your account!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lWithdraw 64 Coins")) {
                    e.setCancelled(true);
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        int num = bank.get(playerKey);
                        if (num >= 64) {
                            bank.put(playerKey, num - 64);
                            int num1 = bank.get(playerKey);
                            player.sendMessage("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Withdrawing Coins");
                            ItemStack sunflower = new ItemStack(Material.SUNFLOWER, 64);
                            player.getInventory().addItem(sunflower);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Balance: " + num1);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your account!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
                    }
                }
            }
        }
    }
}