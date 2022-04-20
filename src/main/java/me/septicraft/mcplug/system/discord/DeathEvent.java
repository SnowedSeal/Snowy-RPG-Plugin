package me.septicraft.mcplug.system.discord;

import org.bukkit.*;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class DeathEvent implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player p = event.getEntity();
        String name = event.getEntity().getName();
        EntityDamageEvent ede = p.getLastDamageCause();
        EntityDamageEvent.DamageCause dc = ede.getCause();
        event.setKeepInventory(true);
        World world = p.getWorld();
        Firework firework = world.spawn(p.getLocation(), Firework.class);
        FireworkMeta meta = firework.getFireworkMeta();
        FireworkEffect effect = FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL).trail(true).build();
        meta.addEffect(effect);
        meta.setPower(1);
        firework.setFireworkMeta(meta);
        firework.detonate();

        if (dc == EntityDamageEvent.DamageCause.FLY_INTO_WALL) {
            event.setDeathMessage("" + ChatColor.RED + ChatColor.BOLD + name + "'s brains are all over the wall!");
        } else if (dc == EntityDamageEvent.DamageCause.DROWNING) {
            event.setDeathMessage("" + ChatColor.RED + ChatColor.BOLD + name + " ran out of air.");
        } else if (dc == EntityDamageEvent.DamageCause.FIRE) {
            event.setDeathMessage("" + ChatColor.RED + ChatColor.BOLD + name + " was burned alive!");
        }else if (dc == EntityDamageEvent.DamageCause.CUSTOM){
            event.setDeathMessage("" + ChatColor.RED + ChatColor.BOLD + name + " died!");
        } else {
            event.setDeathMessage("" + ChatColor.RED + ChatColor.BOLD + name + " died in a way that isn't implemented! Please report this!");
        }

    }
}
