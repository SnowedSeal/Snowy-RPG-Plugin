package me.loudsnow.mcplug.packets;


import com.comphenix.packetwrapper.WrapperPlayServerEntityMetadata;
import com.comphenix.packetwrapper.WrapperPlayServerNamedEntitySpawn;
import com.comphenix.packetwrapper.WrapperPlayServerPlayerInfo;
import com.comphenix.packetwrapper.WrapperPlayServerSpawnEntity;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;

import com.comphenix.protocol.wrappers.*;
import me.loudsnow.mcplug.EasyMetadataPacket;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.serializer.Serializer;

import javax.swing.text.DefaultStyledDocument;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static me.loudsnow.mcplug.Main.instance;
import static me.loudsnow.mcplug.Main.manager;

public class PacketTest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        PacketContainer spawner = new PacketContainer(PacketType.Play.Server.NAMED_ENTITY_SPAWN);
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();
        Player p = (Player) sender;
        Location location = p.getLocation();
        PacketContainer packet = manager.createPacket(PacketType.Play.Server.SPAWN_ENTITY);
        packet.getIntegers().write(0, 1000);
        packet.getEntityTypeModifier().write(0, EntityType.ARMOR_STAND);
        packet.getUUIDs().write(0, UUID.randomUUID());
        packet.getDoubles().write(0, 170.0);
        packet.getDoubles().write(1, 113.0);
        packet.getDoubles().write(2, 69.0);

        PacketContainer metaData = manager.createPacket(PacketType.Play.Server.ENTITY_METADATA);
        //List<WrappedWatchableObject> list = new ArrayList<>();
        EasyMetadataPacket metadata = new EasyMetadataPacket(null);
        //WrappedWatchableObject object = new WrappedWatchableObject(new WrappedDataWatcher.WrappedDataWatcherObject(0, WrappedDataWatcher.Registry.get(Byte.class)), (byte) 0x20);
        //list.add(object);
        //metaData.getWatchableCollectionModifier().write(0, list);
        metaData.getIntegers().write(0, 1000);
        metadata.writeOptional(2, WrappedChatComponent.fromText("Test"));
        metaData.getWatchableCollectionModifier().write(0, metadata.export());

        try {
            manager.sendServerPacket(p, packet);
            manager.sendServerPacket(p, metaData);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return true;
    }
}
