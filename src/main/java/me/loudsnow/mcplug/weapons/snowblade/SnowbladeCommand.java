package me.loudsnow.mcplug.weapons.snowblade;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SnowbladeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            ItemStack snowblade = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = snowblade.getItemMeta();
            meta.setDisplayName("" + ChatColor.AQUA + ChatColor.BOLD + "Snowblade");
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.isUnbreakable();
            ArrayList<String> lore = new ArrayList();
            lore.add("30 Second Cooldown");
            lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "Right click to activate " + ChatColor.AQUA + "FREEZE" + ChatColor.YELLOW + "!");
            lore.add("" + ChatColor.YELLOW + "Freezes all entities within 5 blocks!");
            meta.setLore(lore);
            meta.setUnbreakable(true);
            snowblade.setItemMeta(meta);
            p.getInventory().addItem(snowblade);
            return true;

        }
        return true;
    }
}
