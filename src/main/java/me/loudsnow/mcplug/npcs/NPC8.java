package me.loudsnow.mcplug.npcs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class NPC8 implements Listener {
    @EventHandler
    public void onNpcClick(PlayerInteractEntityEvent event) {
        Player p = (Player) event.getPlayer();
        if (event.getHand() == EquipmentSlot.HAND) {
            Entity entity = event.getRightClicked();
            String uuid = entity.getUniqueId().toString();
            if (uuid.equals("2ec04197-27f2-22df-9e09-2eb852f29bd2")) {
                Inventory inv;
                    inv = Bukkit.createInventory(null, 9, "" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Horse Shop");
                    ItemStack buyhorse = new ItemStack(Material.SUNFLOWER);
                    ItemStack voids = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                    ItemMeta meta1 = voids.getItemMeta();
                    meta1.setDisplayName("");
                    ItemMeta meta = buyhorse.getItemMeta();
                    meta.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Buy a horse");
                    List<String> lore = new ArrayList<>();
                    lore.add("");
                    lore.add("" + ChatColor.GRAY + ChatColor.BOLD + "128 Coins for 1 horse. Color is randomized.");
                    meta.setLore(lore);
                    buyhorse.setItemMeta(meta);
                    inv.setItem(4, buyhorse);
                    inv.setItem(0, voids);
                    inv.setItem(1, voids);
                    inv.setItem(2, voids);
                    inv.setItem(3, voids);
                    inv.setItem(5, voids);
                    inv.setItem(6, voids);
                    inv.setItem(7, voids);
                    inv.setItem(8, voids);

                    p.openInventory(inv);

            }

        }


    }
}
