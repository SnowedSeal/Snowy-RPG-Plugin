package me.septicraft.mcplug.accessories.glowingpendant;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class GlowingPendantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            ItemStack glowingpendant = new ItemStack(Material.BLAZE_POWDER, 1);
            ItemMeta meta = glowingpendant.getItemMeta();
            meta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Glowing Pendant");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Emits a life-like glow...");
            meta.setLore(lore);
            glowingpendant.setItemMeta(meta);
            p.getInventory().addItem(glowingpendant);

            return true;

        }
        return false;
    }
}
