package me.loudsnow.mcplug.npcs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

import static me.loudsnow.mcplug.Main.bank;

public class BankerDeposit implements Listener {
    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("§6§lBank")) {
            e.setCancelled(true);
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta() != null) {
                e.getCurrentItem().getItemMeta().getDisplayName();
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 16 Coins")) {
                    Player player = (Player) e.getWhoClicked();
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 16)) {
                            player.sendMessage("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Depositing Coins");
                            bank.put(playerKey, bank.get(playerKey) + 16);
                            player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 16)});
                            int num1 = bank.get(playerKey);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 1 Coin")) {
                    Player player = (Player) e.getWhoClicked();
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 1)) {
                            player.sendMessage("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Depositing Coins");
                            bank.put(playerKey, bank.get(playerKey) + 1);
                            player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 1)});
                            int num1 = bank.get(playerKey);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 32 Coins")) {
                    Player player = (Player) e.getWhoClicked();
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 32)) {
                            player.sendMessage("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Depositing Coins");
                            bank.put(playerKey, bank.get(playerKey) + 32);
                            player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 32)});
                            int num1 = bank.get(playerKey);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 64 Coins")) {
                    Player player = (Player) e.getWhoClicked();
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 64)) {
                            player.sendMessage("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Depositing Coins");
                            bank.put(playerKey, bank.get(playerKey) + 64);
                            player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 64)});
                            int num1 = bank.get(playerKey);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
                    }
                }
            }
        }
    }
}

