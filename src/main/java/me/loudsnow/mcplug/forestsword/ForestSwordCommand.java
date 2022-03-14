package me.loudsnow.mcplug.forestsword;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ForestSwordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            ItemStack forestsword = new ItemStack(Material.STONE_SWORD, 1);
            ItemMeta meta = forestsword.getItemMeta();
            meta.setDisplayName("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "Forest Sword");
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),  "generic.attackDamage", 5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.isUnbreakable();

            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add("" + ChatColor.GREEN + "A sword of the trees...");
            lore.add("");
            lore.add("" + ChatColor.DARK_GRAY + ChatColor.ITALIC + "It smells like trees?");
            meta.setLore(lore);
            forestsword.setItemMeta(meta);
            p.getInventory().addItem(forestsword);
        }
    return true;
    }
}
