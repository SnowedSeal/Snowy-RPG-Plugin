package me.septicraft.mcplug.mobs;

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
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SpawnQueen implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        World world = Bukkit.getServer().getWorld("world");
        Location loc = new Location(world,201,120,-594);
        double locx = 201;
        double locy = 120;
        double locz = -594;
        Vector3d vec = new Vector3d(locx, locy, locz);

        WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(1001, Optional.of(UUID.randomUUID()), EntityTypes.WITHER, vec, (float) 0, (float) 0, 0, Optional.empty());
        List<EntityData> list = new ArrayList<>();
        List<EntityData> list1 = new ArrayList<>();

        Player p = (Player) sender;
        EntityData name = new EntityData(2, EntityDataTypes.OPTIONAL_COMPONENT, Optional.of(Component.text("Queen Annabelle II", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD)));
        EntityData namevisible = new EntityData(3, EntityDataTypes.BOOLEAN, true);
        EntityData invul = new EntityData(19, EntityDataTypes.INT, 1);

        list.add(name);
        list.add(invul);
        list.add(namevisible);

        WrapperPlayServerEntityMetadata packet1 = new WrapperPlayServerEntityMetadata(1001, list);

        PacketEvents.getAPI().getPlayerManager().sendPacket(p, packet);

        PacketEvents.getAPI().getPlayerManager().sendPacket(p, packet1);


        return true;
    }
}
