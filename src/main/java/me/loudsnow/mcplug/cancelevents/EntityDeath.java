package me.loudsnow.mcplug.cancelevents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static me.loudsnow.mcplug.Main.drop;
import static me.loudsnow.mcplug.Main.instance;

public class EntityDeath implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent e){
        if (e.getEntity().getKiller() instanceof Player){
            Player p = e.getEntity().getKiller();
            e.getDrops().clear();
            NamespacedKey namespacedKey = new NamespacedKey(instance, "level");
            PersistentDataContainer levels = e.getEntity().getPersistentDataContainer();
            if (levels.has(namespacedKey, PersistentDataType.STRING)) {
                if (levels.get(namespacedKey, PersistentDataType.STRING).contains("1")) {
                    Entity entity = e.getEntity();
                    UUID id = UUID.randomUUID();
                    int zmin = 0;
                    int zmax = 4;
                    int random = (int) Math.floor(Math.random() * (zmax - zmin + 1) + zmin);
                    ItemStack stack = new ItemStack(Material.LEATHER, random);
                    ItemMeta meta = stack.getItemMeta();
                    meta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', "&0") + id));
                    stack.setItemMeta(meta);
                    entity.getWorld().dropItemNaturally(entity.getLocation(), stack);

                }
            }
        }
    }
}

