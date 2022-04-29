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

import java.util.ArrayList;
import java.util.Objects;

public class BankerDeposit implements Listener {
    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§6§lBank")) {
            e.setCancelled(true);
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta() != null) {
                e.getCurrentItem().getItemMeta().getDisplayName();
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 16 Coins")) {
                    JsonObject num1 = MongoDBUtil.readData("_id", player.getUniqueId());
                    int num = Integer.parseInt(num1.get("balance").toString());
                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 16)) {
                        MongoDBUtil.updateData("_id", player, "balance", num + 16);
                        num = num + 16;
                        player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 16)});
                        ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                        ItemMeta meta7 = balance.getItemMeta();
                        meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num);
                        ArrayList<String> lore = new ArrayList();
                        lore.add(" ");
                        //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to deposit!");
                        meta7.setLore(lore);
                        balance.setItemMeta(meta7);
                        player.getOpenInventory().setItem(4, balance);
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 1 Coin")) {
                    JsonObject num1 = MongoDBUtil.readData("_id", player.getUniqueId());
                    int num = Integer.parseInt(num1.get("balance").toString());
                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 1)) {
                        MongoDBUtil.updateData("_id", player, "balance", num + 1);
                        num = num + 1;
                        player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 1)});
                        ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                        ItemMeta meta7 = balance.getItemMeta();
                        meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num);
                        ArrayList<String> lore = new ArrayList();
                        lore.add("");
                        //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to deposit!");
                        meta7.setLore(lore);
                        balance.setItemMeta(meta7);
                        player.getOpenInventory().setItem(4, balance);
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 32 Coins")) {
                    JsonObject num1 = MongoDBUtil.readData("_id", player.getUniqueId());
                    int num = Integer.parseInt(num1.get("balance").toString());
                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 32)) {
                        MongoDBUtil.updateData("_id", player, "balance", num + 32);
                        num = num + 32;
                        player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 32)});
                        ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                        ItemMeta meta7 = balance.getItemMeta();
                        meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num);
                        ArrayList<String> lore = new ArrayList();
                        lore.add("");
                        //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to deposit!");
                        meta7.setLore(lore);
                        balance.setItemMeta(meta7);
                        player.getOpenInventory().setItem(4, balance);
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
                    }
                } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit 64 Coins")) {
                    JsonObject num1 = MongoDBUtil.readData("_id", player.getUniqueId());
                    int num = Integer.parseInt(num1.get("balance").toString());
                    if (player.getInventory().containsAtLeast(new ItemStack(Material.SUNFLOWER), 64)) {
                        MongoDBUtil.updateData("_id", player, "balance", num + 64);
                        player.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.SUNFLOWER, 64)});
                        ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                        ItemMeta meta7 = balance.getItemMeta();
                        num = num + 64;
                        meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num);
                        ArrayList<String> lore = new ArrayList();
                        lore.add("");
                        //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to deposit!");
                        meta7.setLore(lore);
                        balance.setItemMeta(meta7);
                        player.getOpenInventory().setItem(4, balance);
                    } else {
                        player.sendMessage(ChatColor.RED + "You don't have enough in your inventory!");
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
                    //int num1 = 0;
                    /*if (pbalance.get(namespacedKey, PersistentDataType.INTEGER) != null) {
                        num1 = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
                    } else {
                        p.sendMessage(ChatColor.RED + "There was an error when finding you're balance! Please report this!");
                        p.closeInventory();
                    }*/
                    ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
//                    pbalance.set(namespacedKey, PersistentDataType.INTEGER, 1);
                    JsonObject num1 = MongoDBUtil.readData("_id", player.getUniqueId());
                    int num = Integer.parseInt(num1.get("balance").toString());
                    ItemMeta meta7 = balance.getItemMeta();
                    meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Balance: " + num);
                    ArrayList<String> lore = new ArrayList();
                    lore.add("");
                    //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to deposit!");
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

