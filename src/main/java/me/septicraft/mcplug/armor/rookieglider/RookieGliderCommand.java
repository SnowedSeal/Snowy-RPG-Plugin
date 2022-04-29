package me.septicraft.mcplug.armor.rookieglider;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class RookieGliderCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            ItemStack rookieglider = new ItemStack(Material.ELYTRA, 1);
            Player p = (Player) sender;
            ItemMeta meta = rookieglider.getItemMeta();
            meta.setDisplayName("" + ChatColor.GREEN + ChatColor.BOLD + "Rookie Glider");
            meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL , 3,true);
            meta.addEnchant(Enchantment.THORNS , 1,true);
            meta.isUnbreakable();
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.DARK_PURPLE + "30 Second Cooldown");
            lore.add(""+ChatColor.YELLOW + ChatColor.BOLD+"DOUBLE JUMP to activate sky launch!");
            lore.add(""+ChatColor.YELLOW + "Launches you in the air allowing you to fly.");
            meta.setLore(lore);

            rookieglider.setItemMeta(meta);
            p.getInventory().addItem(rookieglider);

            return true;

        }
        return false;
    }
}