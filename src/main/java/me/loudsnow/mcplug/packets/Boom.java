package me.loudsnow.mcplug.packets;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;

public class Boom implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        /*ProtocolManager manager = ProtocolLibrary.getProtocolManager();
        Player p = (Player) sender;
        p.getLineOfSight(null, 50).stream()
                .filter(block -> block.getType() != Material.AIR)
                .forEach(block -> {
                    Location blockLocation = block.getLocation();
                    PacketContainer packet = manager.createPacket(PacketType.Play.Server.EXPLOSION);
                    packet.getDoubles().write(0, blockLocation.getX());
                    packet.getDoubles().write(1, blockLocation.getY());
                    packet.getDoubles().write(2, blockLocation.getZ());
                    packet.getFloat().write(0, 10.0f);
                    packet.getFloat().write(1, 0f);
                    packet.getFloat().write(2, 3.0f);
                    packet.getFloat().write(3, 0f);
                    try {
                        manager.sendServerPacket(p, packet);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                });*/
        return true;
    }
}