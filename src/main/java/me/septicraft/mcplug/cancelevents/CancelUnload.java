package me.septicraft.mcplug.cancelevents;

import me.septicraft.mcplug.Main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.EntitiesUnloadEvent;

public class CancelUnload implements Listener {
    @EventHandler
    public void onChunkUnload(EntitiesUnloadEvent e){

        for(Entity entity : e.getEntities()) {
            if (entity instanceof Horse) {
                e.getChunk().load();
                if (((Horse) entity).getOwner() != null) {
                    Player owner = (Player) ((Horse) entity).getOwner();
                    owner.sendMessage(ChatColor.GREEN + "The chunk your horse was in got unloaded. Teleporting Horse...");
                    assert owner != null;

                    World world = owner.getWorld();
                    Block b = world.getHighestBlockAt(owner.getLocation());
                    if (!owner.isOnGround()) {
                        double intX = b.getX();
                        double intY = b.getY() + 1;
                        double intZ = b.getZ();
                        Location loc = new Location(world, intX, intY, intZ);
                        entity.teleport(loc);
                    } else {
                        entity.teleport(owner.getLocation());
                    }
                    Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
                        @Override
                        public void run() {
                            e.getChunk().unload();
                        }
                    }, 40L);
                }
            }
        }
    }
}
