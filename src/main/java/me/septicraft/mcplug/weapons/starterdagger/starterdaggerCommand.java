package me.septicraft.mcplug.weapons.starterdagger;

import org.bukkit.inventory.ItemFlag;
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
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class starterdaggerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            ItemStack basicdagger = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = basicdagger.getItemMeta();
            meta.setDisplayName("Basic Dagger");
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),  "generic.attackDamage", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(),  "generic.attackSpeed", 2.25, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.isUnbreakable();
            List<String> lore = new ArrayList<>();
            lore.add("It's a solid starter weapon!");
            meta.setLore(lore);
            basicdagger.setItemMeta(meta);
            p.getInventory().addItem(basicdagger);
            Team team = p.getScoreboard().getTeam("Player");
            team.addPlayer(p);
            return true;

        }
        return false;
    }
}

