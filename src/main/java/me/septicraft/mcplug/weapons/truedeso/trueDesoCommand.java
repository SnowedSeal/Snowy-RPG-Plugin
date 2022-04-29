package me.septicraft.mcplug.weapons.truedeso;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class trueDesoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            ItemStack truedesolation = new ItemStack(Material.GOLDEN_SWORD, 1);
            Player p = (Player) sender;
            ItemMeta meta = truedesolation.getItemMeta();
            meta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Awakened Desolation");
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),  "generic.attackSpeed", 100, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(),  "generic.attackSpeed", -3.55, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));

            meta.addEnchant(Enchantment.SWEEPING_EDGE , 5,true);
            meta.addEnchant(Enchantment.FIRE_ASPECT , 3,true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
            meta.isUnbreakable();
            List<String> lore = new ArrayList<>();
            lore.add(""+ChatColor.DARK_RED+"The sword that precedes time itself. Its true power has");
            lore.add(""+ChatColor.DARK_RED+"finally been unleashed.");
            meta.setLore(lore);

            truedesolation.setItemMeta(meta);
            p.getInventory().addItem(truedesolation);

            return true;

        }
        return false;
    }
}
