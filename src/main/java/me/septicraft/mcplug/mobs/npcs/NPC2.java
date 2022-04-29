package me.septicraft.mcplug.mobs.npcs;

import com.google.gson.JsonObject;
import me.septicraft.mcplug.Main;
import me.septicraft.mcplug.system.mongodb.MongoDBUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class NPC2 implements Listener {
    @EventHandler
    public void onNpc2Click(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        NamespacedKey namespacedKey = new NamespacedKey(Main.instance, "balance");
        PersistentDataContainer pbalance = p.getPersistentDataContainer();
        if (e.getHand() == EquipmentSlot.HAND) {
            Entity entity = e.getRightClicked();
            String uuid = entity.getUniqueId().toString();
            if (uuid.equals("519e3c07-903e-2f02-b10e-bc4453f6f637")) {
                if (Main.bank.containsKey(p.getUniqueId().toString())) {
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
                    meta5.setDisplayName(" ");
                    voids.setItemMeta(meta5);
                    JsonObject num1 = MongoDBUtil.readData("_id", p.getUniqueId());
                    int num = Integer.parseInt(num1.get("balance").toString());
                    ItemStack balance = new ItemStack(Material.GOLD_BLOCK);
//                    pbalance.set(namespacedKey, PersistentDataType.INTEGER, 1);

                    ItemMeta meta7 = balance.getItemMeta();
                    meta7.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Balance: " + num);
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
                } else {
                    p.sendMessage(ChatColor.GREEN + "Creating new bank account...");
                    Main.bank.put(p.getUniqueId().toString(), 0);
                    pbalance.set(namespacedKey, PersistentDataType.INTEGER, 0);
                }
            }
        }
    }
}
