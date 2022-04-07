package me.loudsnow.mcplug.mobs.npcs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Objects;

import static me.loudsnow.mcplug.Main.*;

public class BankerDeposit implements Listener {
    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        NamespacedKey namespacedKey = new NamespacedKey(instance, "balance");
        PersistentDataContainer pbalance = player.getPersistentDataContainer();
        if (e.getView().getTitle().equalsIgnoreCase("§6§lBank")) {
            e.setCancelled(true);
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta() != null) {
                e.getCurrentItem().getItemMeta().getDisplayName();
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 16 Coins")) {
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        int num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                        String playerKey = player.getUniqueId().toString();
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 16)) {
                            pbalance.set(namespacedKey, PersistentDataType.INTEGER, num1 + 16);
                            player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 16)});
                            num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            ArrayList<String> lore = new ArrayList();
                            lore.add(" ");
                            lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "me to choose a specific amount to deposit!");
                            meta7.setLore(lore);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK ACCOUNT; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 1 Coin")) {
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        int num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 1)) {
                            pbalance.set(namespacedKey, PersistentDataType.INTEGER, num1 + 1);
                            player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 1)});
                            num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            ArrayList<String> lore = new ArrayList();
                    lore.add(" ");
                    lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "me to choose a specific amount to deposit!");
                    meta7.setLore(lore);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK ACCOUNT; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 32 Coins")) {
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        int num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 32)) {
                            pbalance.set(namespacedKey, PersistentDataType.INTEGER, num1 + 32);
                            player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 32)});
                            num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            ArrayList<String> lore = new ArrayList();
                            lore.add(" ");
                            lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "me to choose a specific amount to deposit!");
                            meta7.setLore(lore);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK ACCOUNT; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 64 Coins")) {
                    if (bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        int num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                        if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 64)) {
                            pbalance.set(namespacedKey, PersistentDataType.INTEGER, num1 + 64);
                            num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                            player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 64)});
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num1);
                            ArrayList<String> lore = new ArrayList();
                            lore.add(" ");
                            lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "me to choose a specific amount to deposit!");
                            meta7.setLore(lore);
                            balance.setItemMeta(meta7);
                            player.getOpenInventory().setItem(4, balance);
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK ACCOUNT; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cBack")) {
                    Player p = (Player) e.getWhoClicked();
                    Inventory inv = Bukkit.createInventory(null, 9, "§6§lBank");

                    ItemStack withdraw = new ItemStack(Material.CHEST_MINECART);
                    ItemMeta meta = withdraw.getItemMeta();
                    meta.setDisplayName("§6§lWithdraw Coins");
                    withdraw.setItemMeta(meta);

                    ItemStack deposit = new ItemStack(Material.HOPPER_MINECART);
                    ItemMeta meta1 = deposit.getItemMeta();
                    meta1.setDisplayName("§7§lDeposit Coins");
                    deposit.setItemMeta(meta1);
                    ItemStack voids = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemMeta meta5 = voids.getItemMeta();
                    meta5.setDisplayName("");
                    int num1 = 0;
                    if (pbalance.get(namespacedKey, PersistentDataType.INTEGER) != null) {
                        num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                    } else {
                        p.sendMessage(ChatColor.RED + "There was an error when finding you're balance! Please report this!");
                        p.closeInventory();
                    }
                    ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
//                    pbalance.set(namespacedKey, PersistentDataType.INTEGER, 1);

                    ItemMeta meta7 = balance.getItemMeta();
                    meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Balance: " + num1);
                    ArrayList<String> lore = new ArrayList();
                    lore.add(" ");
                    lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "me to choose a specific amount to deposit!");
                    meta7.setLore(lore);
                    balance.setItemMeta(meta7);
                    inv.setItem(0, voids);
                    inv.setItem(1, voids);
                    inv.setItem(2, withdraw);
                    inv.setItem(3, voids);
                    inv.setItem(4, balance);
                    inv.setItem(5, voids);
                    inv.setItem(6, deposit);
                    inv.setItem(7, voids);
                    inv.setItem(8, voids);

                    p.openInventory(inv);

                } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("" + ChatColor.GOLD + ChatColor.BOLD + "Balance:")){
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "How many coins would you like to deposit? [Send Chat]");
                    bank1.put(player.getUniqueId().toString(), true);
                }
            }
        }
    }
}

