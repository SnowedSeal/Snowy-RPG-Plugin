package me.septicraft.mcplug.weapons.desolation;

import me.septicraft.mcplug.Main;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class DesolationAttackListener implements Listener {
    @EventHandler
    public void onDesolationAttack(EntityDamageByEntityEvent e) {
        Entity entity = (Entity) e.getDamager();
        if (entity instanceof Player) {
            Player p = (Player) e.getDamager();
            if (Main.cd5.containsKey(p.getUniqueId().toString())) {


            } else {
                if (p.getItemInHand().getItemMeta() != null && p.getItemInHand().getItemMeta().getDisplayName().equals("" + ChatColor.RED + ChatColor.BOLD + "Desolation")) {
                    Main.cd5.put(p.getUniqueId().toString(), 0);

                    Location location = p.getLocation();
                    World world = p.getWorld();
                    world.spawnParticle(Particle.LANDING_LAVA, location, 10, 1, 1, 1, 1);
                    if (Main.desolationdmg) {
                        Double damage = e.getFinalDamage() / 7;
                        p.damage(damage, p);
                        p.setVelocity(new Vector());
                    } else {
                        Double damage = e.getFinalDamage() / 15;
                        p.damage(damage, p);
                        p.setVelocity(new Vector());
                    }


                    Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
                        @Override
                        public void run() {
                            Main.cd5.remove(p.getUniqueId().toString());
                        }

                    }, 20);
                }
            }
        }
    }
}

