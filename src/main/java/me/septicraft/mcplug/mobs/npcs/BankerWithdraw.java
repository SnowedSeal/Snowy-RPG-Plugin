package me.septicraft.mcplug.mobs.npcs;

import com.google.gson.JsonObject;
import me.septicraft.mcplug.Main;
import me.septicraft.mcplug.system.mongodb.MongoDBUtil;
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
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class BankerWithdraw implements Listener {
    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
/*        NamespacedKey namespacedKey = new NamespacedKey(Main.instance, "balance");
        PersistentDataContainer pbalance = player.getPersistentDataContainer();*/
        if (e.getView().getTitle().equalsIgnoreCase("§6§lBank")) {
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta() != null) {
                e.getCurrentItem().getItemMeta().getDisplayName();
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lWithdraw 16 Coins")) {
                    e.setCancelled(true);
                    if (Main.bank.containsKey(player.getUniqueId().toString())) {
                        JsonObject num1 = MongoDBUtil.readData("_id", player.getUniqueId());
                        int num = Integer.parseInt(num1.get("balance").toString());
                        if (num >= 16) {
                            int i = 2;
/*                            for(ItemStack is : player.getInventory().getContents()) {
                                Inventory inv = player.getInventory();
                                if (is == null){
                                    if (is.get)
                                    i++;
                                }
                            }*/
                            MongoDBUtil.updateData("_id", player, "balance", num - 16);
                            num = num - 16;
                            ItemStack sunflower = new ItemStack(Material.SUNFLOWER, 16);
                            player.getInventory().addItem(sunflower);
                            ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                            ItemMeta meta7 = balance.getItemMeta();
                            meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num);
                            ArrayList<String> lore = new ArrayList();
                            lore.add("");
                            //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to withdraw!");
                            meta7.setLore(lore);
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
                    if (Main.bank.containsKey(player.getUniqueId().toString())) {
                        String playerKey = player.getUniqueId().toString();
                        JsonObject num1 = MongoDBUtil.readData("_id", player.getUniqueId());
                        int num = Integer.parseInt(num1.get("balance").toString());
                        if (num >= 1) {
                            int i = 0;
                            for (ItemStack itemStack : player.getInventory()) {
                                if (itemStack == null) {
                                    i++;
                                }
                            }
                            if (i >= 0) {
                                MongoDBUtil.updateData("_id", player, "balance", num - 1);
                                num = num - 1;
                                ItemStack sunflower = new ItemStack(Material.SUNFLOWER);
                                player.getInventory().addItem(sunflower);
                                ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                                ItemMeta meta7 = balance.getItemMeta();
                                meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Balance: " + num);
                                ArrayList<String> lore = new ArrayList();
                                lore.add("");
                                //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to withdraw!");
                                meta7.setLore(lore);
                                balance.setItemMeta(meta7);
                                player.getOpenInventory().setItem(4, balance);
                            } else {
                                player.sendMessage(ChatColor.GREEN + "You don't have enough space! Please make sure you have at least 1 inventory slot open!");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your account!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lWithdraw 32 Coins")) {
                    e.setCancelled(true);
                    if (Main.bank.containsKey(player.getUniqueId().toString())) {
                        JsonObject num1 = MongoDBUtil.readData("_id", player.getUniqueId());
                        int num = Integer.parseInt(num1.get("balance").toString());
                        if (num >= 32) {
                            int i = 0;
                            for (ItemStack itemStack : player.getInventory()) {
                                if (itemStack == null) {
                                    i++;
                                }
                            }
                            if (i >= 0) {
                                MongoDBUtil.updateData("_id", player, "balance", num - 32);
                                num = num - 32;
                                ItemStack sunflower = new ItemStack(Material.SUNFLOWER, 32);
                                player.getInventory().addItem(sunflower);
                                ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                                ItemMeta meta7 = balance.getItemMeta();
                                meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Balance: " + num);
                                ArrayList<String> lore = new ArrayList();
                                lore.add("");
                                //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to withdraw!");
                                meta7.setLore(lore);
                                balance.setItemMeta(meta7);
                                player.getOpenInventory().setItem(4, balance);
                            } else {
                                player.sendMessage(ChatColor.GREEN + "You don't have enough space! Please make sure you have at least 1 inventory slot open!");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your account!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lWithdraw 64 Coins")) {
                    e.setCancelled(true);
                    if (Main.bank.containsKey(player.getUniqueId().toString())) {
                        JsonObject num1 = MongoDBUtil.readData("_id", player.getUniqueId());
                        int num = Integer.parseInt(num1.get("balance").toString());
                        if (num >= 64) {
                            int i = 0;
                            for (ItemStack itemStack : player.getInventory()) {
                                if (itemStack == null) {
                                    i++;
                                }
                            }
                            if (i >= 0) {
                                MongoDBUtil.updateData("_id", player, "balance", num - 64);
                                num = num - 64;
                                ItemStack sunflower = new ItemStack(Material.SUNFLOWER, 64);
                                player.getInventory().addItem(sunflower);
                                ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                                ItemMeta meta7 = balance.getItemMeta();
                                meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Balance: " + num);
                                ArrayList<String> lore = new ArrayList();
                                lore.add("");
                                //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to withdraw!");
                                meta7.setLore(lore);
                                balance.setItemMeta(meta7);
                                player.getOpenInventory().setItem(4, balance);
                            } else {
                                player.sendMessage(ChatColor.GREEN + "You don't have enough space! Please make sure you have at least 1 inventory slot open!");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough in your account!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "ERROR: CANNOT FIND BANK; PLEASE REPORT THIS");
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
 /*                   if (pbalance.get(namespacedKey, PersistentDataType.INTEGER) != null) {
                        num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                    } else {
                        p.sendMessage(ChatColor.RED + "There was an error when finding you're balance! Please report this!");
                        p.closeInventory();
                    }*/
                    ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
//                    pbalance.set(namespacedKey, PersistentDataType.INTEGER, 1);

                    ItemMeta meta7 = balance.getItemMeta();
                    meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Balance: " + num1);
                    ArrayList<String> lore = new ArrayList();
                    lore.add("");
                    //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to withdraw!");
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

                /*} else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("" + ChatColor.GOLD + ChatColor.BOLD + "Balance:")){
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "How many coins would you like to change? Use negative to withdraw. [Send Chat]");
                    Main.bank1.put(player.getUniqueId().toString(), true);*/
                }
            }
        }
    }
}