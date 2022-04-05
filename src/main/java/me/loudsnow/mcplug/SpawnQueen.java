package me.loudsnow.mcplug;

import lombok.With;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.jetbrains.annotations.NotNull;

public class SpawnQueen implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        World world = Bukkit.getServer().getWorld("world");
        Location loc = new Location(world,201,120,-594);
        Wither wither = (Wither) world.spawnEntity(loc, EntityType.WITHER);
        wither.setAI(false);
        //wither.setAge(10);
        wither.setInvulnerableTicks(1);
        wither.setCustomNameVisible(true);
        wither.setCustomName("" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Queen Annabelle II");
        return true;
    }
}
