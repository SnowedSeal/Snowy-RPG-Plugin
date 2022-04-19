package me.loudsnow.mcplug.system.discord;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static me.loudsnow.mcplug.Main.*;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("" + ChatColor.GREEN + ChatColor.BOLD + p.getName() + " joined the server!");
        TextChannel channel = jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new Color(0x00FF00));
        eb.setTitle("**" + p.getDisplayName() + " joined the server!**");
        eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
        channel.sendMessageEmbeds(eb.build()).queue();
        if (horseowner.containsKey(p.getUniqueId().toString())) {
            p.sendMessage(ChatColor.YELLOW + "Use /whistle to summon your horse!");

        }
        World world = Bukkit.getServer().getWorld("world");
        Location loc = new Location(world,201,120,-594);
        double locx = 201;
        double locy = 120;
        double locz = -594;
        Vector3d vec = new Vector3d(locx, locy, locz);

        WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(1001, Optional.of(UUID.randomUUID()), EntityTypes.WITHER, vec, (float) 0, (float) 0, 0, Optional.empty());
        java.util.List<EntityData> list = new ArrayList<>();
        List<EntityData> list1 = new ArrayList<>();
        EntityData name = new EntityData(2, EntityDataTypes.OPTIONAL_COMPONENT, Optional.of(Component.text("Queen Annabelle II", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD)));
        EntityData namevisible = new EntityData(3, EntityDataTypes.BOOLEAN, true);
        EntityData invul = new EntityData(19, EntityDataTypes.INT, 1);

        list.add(name);
        list.add(invul);
        list.add(namevisible);

        WrapperPlayServerEntityMetadata packet1 = new WrapperPlayServerEntityMetadata(1001, list);

        PacketEvents.getAPI().getPlayerManager().sendPacket(p, packet);

        PacketEvents.getAPI().getPlayerManager().sendPacket(p, packet1);
        p.sendTitle("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "Septicraft", "" + ChatColor.GREEN + ChatColor.BOLD + "Welcome!", 75, 100, 50);
        Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
            @Override
            public void run() {
                p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 100, 100);
            }
        }, 50);
        NamespacedKey namespacedKey = new NamespacedKey(instance, "quest1");
        PersistentDataContainer quest1 = p.getPersistentDataContainer();
        if (!p.hasPlayedBefore()){
            quest1.set(namespacedKey, PersistentDataType.INTEGER, 0);

        } else if (p.getName().equals("Loudbook")){
            quest1.set(namespacedKey, PersistentDataType.INTEGER, 0);
        }
        if (quest1.get(namespacedKey, PersistentDataType.INTEGER) == 0){
            p.sendMessage(ChatColor.GREEN + "Please find Gilbert in the yellow building to start your journey!");
        }
    }
}
