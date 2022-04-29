package me.septicraft.mcplug.weapons.truedeso;


import me.septicraft.mcplug.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class trueDesoListener implements Listener {
    @EventHandler
    public void onDesolationAttack(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName().equals("" + ChatColor.RED + ChatColor.BOLD + "Awakened Desolation")) {

                if (Main.cd4.containsKey(p.getUniqueId().toString())) {
                    p.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "This object is on cooldown!");
                    Main.cd4.remove(p.getUniqueId().toString());
                } else {
                    Location location = p.getLocation();
                    World world = p.getWorld();
                    world.spawnParticle(Particle.LAVA, location, 20, 1, 1, 1, 1);

                }
            }
        }
    }
}