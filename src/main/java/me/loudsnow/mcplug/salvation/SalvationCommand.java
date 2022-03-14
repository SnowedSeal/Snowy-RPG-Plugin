package me.loudsnow.mcplug.salvation;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;


public class SalvationCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            ItemStack salvation = new ItemStack(Material.GOLD_INGOT, 1);
            ItemMeta meta = salvation.getItemMeta();
            meta.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD +"Salvation");
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.isUnbreakable();
            List<String> lore = new ArrayList<>();
            lore.add("" + ChatColor.GOLD + ChatColor.BOLD +"A chalice forged by the angels. It's said");
            lore.add("" + ChatColor.GOLD + ChatColor.BOLD +"to have incredible healing powers.");
            lore.add("" + ChatColor.YELLOW +ChatColor.BOLD +"Use in offhand it gain buffs!");
            meta.setLore(lore);
            salvation.setItemMeta(meta);
            p.getInventory().addItem(salvation);
            return true;
        }
        return false;
    }
}