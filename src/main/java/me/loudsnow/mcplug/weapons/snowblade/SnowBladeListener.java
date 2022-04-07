package me.loudsnow.mcplug.weapons.snowblade;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

import static me.loudsnow.mcplug.Main.instance;

public class SnowBladeListener implements Listener {
    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName().equals("" + ChatColor.AQUA + ChatColor.BOLD + "Snowblade")) {
                List<Block> blocks = new ArrayList<>();
                Location location = p.getLocation();
                int radius = 5;
                for (int x = -radius; x <= radius; x++) {
                    for (int y = -radius; y <= radius; y++) {
                        for (int z = -radius; z <= radius; z++) {
                            blocks.add(p.getLocation().getBlock().getRelative(x, y, z));
                        }
                    }
                }
                for (Block b : blocks){
                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        @Override
                        public void run() {
                            if (b.getBlockData().getMaterial() == Material.GRASS_BLOCK){p.sendBlockChange(b.getLocation(), b.getType(), (byte) 0);}
                            if (b.getBlockData().getMaterial() == Material.GRASS){p.sendBlockChange(b.getLocation(), b.getType(), (byte) 0);}
                            if (b.getBlockData().getMaterial() == Material.DIRT){p.sendBlockChange(b.getLocation(), Material.DIRT, (byte) 0);}
                            if (b.getBlockData().getMaterial() == Material.BROWN_CONCRETE_POWDER){p.sendBlockChange(b.getLocation(), Material.BROWN_CONCRETE_POWDER, (byte) 0);}
                            if (b.getBlockData().getMaterial() == Material.COARSE_DIRT){p.sendBlockChange(b.getLocation(), Material.COARSE_DIRT, (byte) 0);}



                        }
                    }, 200);
                    if (b.getType() == Material.GRASS_BLOCK)
                        p.sendBlockChange(b.getLocation(), Material.SNOW_BLOCK, (byte) 0);
                    if (b.getType() == Material.GRASS)
                        p.sendBlockChange(b.getLocation(), Material.SNOW, (byte) 0);
                    if (b.getType() == Material.DIRT)
                        p.sendBlockChange(b.getLocation(), Material.WHITE_CONCRETE_POWDER, (byte) 0);
                    if (b.getType() == Material.COARSE_DIRT)
                        p.sendBlockChange(b.getLocation(), Material.WHITE_CONCRETE_POWDER, (byte) 0);
                    if (b.getType() == Material.BROWN_CONCRETE_POWDER)
                        p.sendBlockChange(b.getLocation(), Material.WHITE_CONCRETE_POWDER, (byte) 0);

                }
            }
        }
    }
}
