package me.loudsnow.mcplug;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import static me.loudsnow.mcplug.Main.*;


public class TrainingDummy implements Listener {
    Boolean used = false;
    @EventHandler
    public void onDamage(EntityDamageEvent e) {


        if (boolea.containsKey("Yes")) {
            e.setCancelled(true);



            } else {
                Entity entity = e.getEntity();
                String uuid = entity.getUniqueId().toString();
                if (uuid.equals("50fd99dc-628f-274d-b86d-5c8dc3ad6a98")) {

                    ((Damageable) entity).damage(0.1);
                    ((Damageable) entity).setHealth(20);
                    Bukkit.broadcastMessage("Test");

                    e.setCancelled(true);

                    Double damage = e.getDamage();
                    ((Damageable) entity).damage(0.1);
                    ((Damageable) entity).setHealth(20);
                    Entity damaged = e.getEntity();

                    damaged.setCustomNameVisible(true);
                    damaged.setCustomName(damage + " damage!");
                    boolea.put("Yes", 0);

                    Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
                        @Override
                        public void run() {
                            damaged.setCustomName("");
                            boolea.remove("Yes");

                        }
                    }, 100, -1);
                }
        }
    }
}
