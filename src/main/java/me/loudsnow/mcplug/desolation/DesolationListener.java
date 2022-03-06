package me.loudsnow.mcplug.desolation;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Damageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static me.loudsnow.mcplug.Main.*;

public class DesolationListener implements Listener {
    @EventHandler
    public void onDesolationAttack(EntityDamageByEntityEvent e) {
        Player p = (Player) e.getDamager();
        if (p instanceof Player) {
            if (cd5.containsKey(p.getUniqueId().toString())) {


            } else {
                if (p.getItemInHand() != null && p.getItemInHand().getItemMeta().getDisplayName().equals("" + ChatColor.RED + ChatColor.BOLD + "Desolation")) {
                    cd5.put(p.getUniqueId().toString(), 0);

                    Location location = p.getLocation();
                    World world = p.getWorld();
                    world.spawnParticle(Particle.LANDING_LAVA, location, 10, 1, 1, 1, 1);
                    Double damage = e.getFinalDamage() / 15;
                    p.damage(damage, p);
                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        @Override
                        public void run() {
                            cd5.remove(p.getUniqueId().toString());
                        }

                    }, 20);
                }
            }
        }
    }
}

