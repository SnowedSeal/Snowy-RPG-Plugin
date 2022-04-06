package me.loudsnow.mcplug.accessories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
// found you!
public class Menu implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) sender;
//        ItemStack item = new ItemStack(Material.PUT_MATERIAL);
        Inventory inv = Bukkit.createInventory(null, 27);
        return false;
    }
}
