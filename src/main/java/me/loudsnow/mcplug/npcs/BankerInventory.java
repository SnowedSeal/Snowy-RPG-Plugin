package me.loudsnow.mcplug.npcs;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.loudsnow.mcplug.Main.bank;


public class BankerInventory implements Listener{
    @EventHandler
    public void onPlayerClickInventory(InventoryClickEvent e) {
        if(e.getView().getTitle().equalsIgnoreCase("§6§lBank")) {
            e.setCancelled(true);

            if (e.getCurrentItem().getItemMeta() != null){
                if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lWithdraw Coins")) {
                        Player p = (Player) e.getWhoClicked();

                        ItemStack voids = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemMeta meta5 = voids.getItemMeta();
                        meta5.setDisplayName(" ");
                        voids.setItemMeta(meta5);
                        String playerKey = p.getUniqueId().toString();
                        int num = bank.get(playerKey);
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
                        balance.setItemMeta(meta7);

                        ItemStack with4 = new ItemStack(Material.CHEST_MINECART);
                        ItemMeta meta4 = with4.getItemMeta();
                        meta4.setDisplayName(""  + ChatColor.GRAY + ChatColor.BOLD + "Withdraw 64 Coins");
                        with4.setItemMeta(meta4);
                        inv.setItem(0, voids);
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
                        Player p = (Player) e.getWhoClicked();
                        ItemStack voids = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemMeta meta5 = voids.getItemMeta();
                        meta5.setDisplayName(" ");
                        voids.setItemMeta(meta5);
                        String playerKey = p.getUniqueId().toString();
                        int num = bank.get(playerKey);
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
                        balance.setItemMeta(meta7);

                        ItemStack with3 = new ItemStack(Material.HOPPER_MINECART);
                        ItemMeta meta3 = with3.getItemMeta();
                        meta3.setDisplayName("§7§lDeposit 32 Coins");
                        with3.setItemMeta(meta3);

                        ItemStack with4 = new ItemStack(Material.HOPPER_MINECART);
                        ItemMeta meta4 = with4.getItemMeta();
                        meta4.setDisplayName("§7§lDeposit 64 Coins");
                        with4.setItemMeta(meta4);

                        inv.setItem(0, voids);
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
