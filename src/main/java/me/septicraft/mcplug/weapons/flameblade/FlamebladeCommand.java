package me.septicraft.mcplug.weapons.flameblade;
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

public class FlamebladeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player) {
            Player p = (Player) sender;
            ItemStack flameblade = new ItemStack(Material.WOODEN_SWORD, 1);
            ItemMeta meta = flameblade.getItemMeta();
            meta.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Flameblade");
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            meta.isUnbreakable();
            meta.addEnchant(Enchantment.FIRE_ASPECT , 1,true);

            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add("" + ChatColor.DARK_PURPLE + "12 Second Cooldown");
            lore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "RIGHT CLICK to activate stun ability!");
            lore.add("" + ChatColor.YELLOW + "Stuns all entities within a 4 block radius.");
            meta.setLore(lore);
            flameblade.setItemMeta(meta);
            p.getInventory().addItem(flameblade);
        }
        return true;
    }
}
