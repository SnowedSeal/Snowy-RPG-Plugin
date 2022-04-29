package me.septicraft.mcplug.armor.windstep;

import me.septicraft.mcplug.Main;
import me.septicraft.mcplug.system.Util;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class WindstepListener implements Listener {
    @EventHandler
    public void onPlayerCrouch(PlayerToggleSneakEvent event){
        Player p = event.getPlayer();
        if (p.isSneaking()){
            if (p.getInventory().getBoots() != null){
                if (event.getPlayer().isOnGround()) {
                    if (p.getInventory().getBoots().getItemMeta().getDisplayName().equals("" + ChatColor.WHITE + ChatColor.BOLD + "Windstep")) {

                        boolean go = Util.cooldown(p, p.getInventory().getBoots(),"Windstep", 100);
                        if (go){
                            p.setVelocity(new Vector(0, -1, 0));
                            Vector dir = p.getLocation().getDirection();
                            p.setVelocity(dir.multiply(2));
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0));
                            World world = p.getWorld();
                            Location location = p.getLocation();
                            world.spawnParticle(Particle.CLOUD, location, 10, 0.2, 0.2, 0.2, 0.2);
                        }
                    }
                }
            }
        }
    }
}
