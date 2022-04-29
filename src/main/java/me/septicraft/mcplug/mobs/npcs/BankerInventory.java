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


// wait i can see this on my own ide cant i yea? alr then
// what i here to do?
// follow me to a new class
// ok
// where u at
// accessories package at the top

public class BankerInventory implements Listener{
    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase("§6§lBank")) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            JsonObject num1 = MongoDBUtil.readData("_id", p.getUniqueId());
            int num = Integer.parseInt(num1.get("balance").toString());
            if (e.getCurrentItem().getItemMeta() != null){
                ItemStack back = new ItemStack(Material.ARROW);
                ItemMeta backmeta = back.getItemMeta();
                backmeta.setDisplayName("§cBack");
                back.setItemMeta(backmeta);
                if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lWithdraw Coins")) {

                        ItemStack voids = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemMeta meta5 = voids.getItemMeta();
                        meta5.setDisplayName(" ");
                        voids.setItemMeta(meta5);
                        String playerKey = p.getUniqueId().toString();
                        Inventory inv = Bukkit.createInventory(null, 9, "§6§lBank");

                        ItemStack with1 = new ItemStack(Material.CHEST_MINECART);
                        ItemMeta meta1 = with1.getItemMeta();
                        meta1.setDisplayName(""  + ChatColor.GRAY + ChatColor.BOLD + "Withdraw 1 Coin");
                        with1.setItemMeta(meta1);

                        ItemStack with2 = new ItemStack(Material.CHEST_MINECART);
                        ItemMeta meta2 = with2.getItemMeta();
                        meta2.setDisplayName("" + ChatColor.GRAY + ChatColor.BOLD + "Withdraw 16 Coins");
                        with2.setItemMeta(meta2);

                        ItemStack with3 = new ItemStack(Material.CHEST_MINECART);
                        ItemMeta meta3 = with3.getItemMeta();
                        meta3.setDisplayName("" + ChatColor.GRAY + ChatColor.BOLD+ "Withdraw 32 Coins");
                        with3.setItemMeta(meta3);

                        ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                        ItemMeta meta7 = balance.getItemMeta();
                        meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num);
                        ArrayList<String> lore = new ArrayList();
                        lore.add("");
                        //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + " to choose a specific amount to withdraw!");
                        meta7.setLore(lore);
                        balance.setItemMeta(meta7);

                        ItemStack with4 = new ItemStack(Material.CHEST_MINECART);
                        ItemMeta meta4 = with4.getItemMeta();
                        meta4.setDisplayName(""  + ChatColor.GRAY + ChatColor.BOLD + "Withdraw 64 Coins");
                        with4.setItemMeta(meta4);
                        inv.setItem(0, back);
                        inv.setItem(1, with1);
                        inv.setItem(2, voids);
                        inv.setItem(3, with2);
                        inv.setItem(4, balance);
                        inv.setItem(5, with3);
                        inv.setItem(6, voids);
                        inv.setItem(7, with4);
                        inv.setItem(8, voids);

                        p.openInventory(inv);

                    /*
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.BOLD + "Withdraw 1 Coin")) {
                        Player p = (Player) e.getWhoClicked();

                        ItemStack sunflower = new ItemStack(Material.SUNFLOWER);
                        p.getInventory().addItem(sunflower);
                        e.setCancelled(true);
                        */

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7§lDeposit Coins")) {


                        ItemStack voids = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemMeta meta5 = voids.getItemMeta();
                        meta5.setDisplayName(" ");
                        voids.setItemMeta(meta5);
                        String playerKey = p.getUniqueId().toString();
                        Inventory inv = Bukkit.createInventory(null, 9, "§6§lBank");

                        ItemStack with1 = new ItemStack(Material.HOPPER_MINECART);
                        ItemMeta meta1 = with1.getItemMeta();
                        meta1.setDisplayName("§7§lDeposit 1 Coin");
                        with1.setItemMeta(meta1);

                        ItemStack with2 = new ItemStack(Material.HOPPER_MINECART);
                        ItemMeta meta2 = with2.getItemMeta();
                        meta2.setDisplayName("§7§lDeposit 16 Coins");
                        with2.setItemMeta(meta2);

                        ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
                        ItemMeta meta7 = balance.getItemMeta();
                        meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD+ "Balance: " + num);
                        ArrayList<String> lore = new ArrayList();
                        lore.add("");
                        //lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "[CLICK] " + ChatColor.RESET + ChatColor.YELLOW + "to choose a specific amount to withdraw!");
                        meta7.setLore(lore);

                        balance.setItemMeta(meta7);

                        ItemStack with3 = new ItemStack(Material.HOPPER_MINECART);
                        ItemMeta meta3 = with3.getItemMeta();
                        meta3.setDisplayName("§7§lDeposit 32 Coins");
                        with3.setItemMeta(meta3);

                        ItemStack with4 = new ItemStack(Material.HOPPER_MINECART);
                        ItemMeta meta4 = with4.getItemMeta();
                        meta4.setDisplayName("§7§lDeposit 64 Coins");
                        with4.setItemMeta(meta4);

                        inv.setItem(0, back);
                        inv.setItem(1, with1);
                        inv.setItem(2, voids);
                        inv.setItem(3, with2);
                        inv.setItem(4, balance);
                        inv.setItem(5, with3);
                        inv.setItem(6, voids);
                        inv.setItem(7, with4);
                        inv.setItem(8, voids);

                        p.openInventory(inv);
                    }
                }
            }
        }
    }
}
