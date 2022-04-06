package me.loudsnow.mcplug;


import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.entity.data.EntityData;
import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.util.Vector3d;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Location;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class TrainingDummy implements Listener {
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        Entity entity = e.getEntity();
        String uuid = entity.getUniqueId().toString();
        if (uuid.equals("56ff4351-bebe-2627-86b0-181cc8d4ff1c")) {
            Player p = (Player) e.getDamager();
            List<Entity> nearby = entity.getNearbyEntities(1, 1, 1);
            WrapperPlayServerDestroyEntities remove = new WrapperPlayServerDestroyEntities(1000);
            PacketEvents.getAPI().getPlayerManager().sendPacket(p, remove);
            for (Entity tmp : nearby)
                if (tmp instanceof Damageable) {
                    if (!(tmp instanceof Player)) {
                        if (!(tmp instanceof Horse)){
                            tmp.remove();
                        }
                    }
                }
            e.setCancelled(true);
            if (e.getDamager() instanceof Player){
                Location loc = e.getEntity().getLocation();
                double locx = loc.getX();
                double locy = loc.getY();
                double locz = loc.getZ();
                double damage = e.getDamage();
                int damagerounded = (int) Math.round(damage);
                WrapperPlayServerSpawnEntity packet = new WrapperPlayServerSpawnEntity(1000, Optional.of(UUID.randomUUID()), EntityTypes.ARMOR_STAND, new Vector3d(locx, locy, locz), (float) 0, (float) 0, 0, Optional.empty());
                List<EntityData> list = new ArrayList<>();
                EntityData visible = new EntityData(0, EntityDataTypes.BYTE, (byte) 0x20);
                EntityData name = new EntityData(2, EntityDataTypes.OPTIONAL_COMPONENT, Optional.of(Component.text(damagerounded + " damage!", NamedTextColor.RED, TextDecoration.BOLD)));
                EntityData namevisible = new EntityData(3, EntityDataTypes.BOOLEAN, true);
                list.add(visible);
                list.add(name);
                list.add(namevisible);
                WrapperPlayServerEntityMetadata packet1 = new WrapperPlayServerEntityMetadata(1000, list);
                PacketEvents.getAPI().getPlayerManager().sendPacket(p, packet);
                PacketEvents.getAPI().getPlayerManager().sendPacket(p, packet1);
            }
        }
    }
}
