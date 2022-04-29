package me.septicraft.mcplug.system;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

import static me.septicraft.mcplug.Main.instance;

public class Util {
    public static HashMap<UUID, UUID> map = new HashMap<>();
    public static boolean cooldown(Player p, ItemStack item, String name, Integer cooldown){
        UUID itemName = UUID.fromString(ChatColor.stripColor(item.getLore().get(0)));
        if (map.get(itemName) != null) {
            p.sendMessage(ChatColor.RED + "This item is on cooldown!");
            return false;
        } else {
            map.put(itemName, p.getUniqueId());
            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                @Override
                public void run() {
                    map.remove(itemName);
                    p.sendMessage("§a" + name + " is no longer on cooldown!");
                }
            }, cooldown);
            return true;
        }
    }
}
