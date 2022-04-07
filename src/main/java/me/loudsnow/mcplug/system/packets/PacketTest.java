package me.loudsnow.mcplug.system.packets;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.List;

public class PacketTest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) sender;
        Location loc = p.getLocation();
        double locx = p.getLocation().getX();
        double locy =p.getLocation().getY();
        double locz =p.getLocation().getZ();
        Vector3d vec = new Vector3d(locx, locy, locz);
        WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(1000, Optional.of(UUID.randomUUID()), EntityTypes.ARMOR_STAND, new Vector3d(locx, locy, locz), (float) 0, (float) 0, 0, Optional.empty());
        List<EntityData> list = new ArrayList<>();
        List<EntityData> list1 = new ArrayList<>();

        //EntityData visible = new EntityData(0, EntityDataTypes.BYTE, (byte) 0x20);
        //EntityData name = new EntityData(2, EntityDataTypes.OPTIONAL_COMPONENT, Component.text("test", NamedTextColor.GREEN, TextDecoration.BOLD));
        EntityData name = new EntityData(2, EntityDataTypes.OPTIONAL_COMPONENT, Optional.of(Component.text("Test", NamedTextColor.GREEN, TextDecoration.BOLD)));
        EntityData namevisible = new EntityData(3, EntityDataTypes.BOOLEAN, true);
        //list.add(visible);
        list1.add(name);
        list.add(namevisible);
        WrapperPlayServerEntityMetadata packet1 = new WrapperPlayServerEntityMetadata(1000, list);
        WrapperPlayServerEntityMetadata packet2 = new WrapperPlayServerEntityMetadata(1000, list1);

        PacketEvents.getAPI().getPlayerManager().sendPacket(p, packet);
        PacketEvents.getAPI().getPlayerManager().sendPacket(p, packet1);
        PacketEvents.getAPI().getPlayerManager().sendPacket(p, packet2);























        /*PacketContainer spawner = new PacketContainer(PacketType.Play.Server.NAMED_ENTITY_SPAWN);
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

*/
        return true;
    }
}
