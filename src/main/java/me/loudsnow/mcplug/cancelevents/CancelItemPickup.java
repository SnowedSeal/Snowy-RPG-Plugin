package me.loudsnow.mcplug.cancelevents;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static me.loudsnow.mcplug.Main.drop;

public class CancelItemPickup implements Listener {
    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        drop.put(e.getItemDrop().getUniqueId(), p.getUniqueId());

    }
    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent e){
        Player p = e.getPlayer();
        ItemMeta meta = e.getItem().getItemStack().getItemMeta();
/*        if (meta.hasLore()) {
            try {
                UUID uuid = UUID.fromString(meta.getLore().get(1));
                String str = e.getItem().getItemStack().getItemMeta().getLore().get(0);
                if (drop.containsKey(UUID.fromString(str))){
                    if (e.getItem().getItemStack().getItemMeta().getLore().get(1).equals(drop.get(uuid).toString())){
                        drop.remove(p.getUniqueId());
                    }
                }
            } catch (Exception ex) {
            }
        }*/
        if (drop.containsKey(e.getItem().getUniqueId())){
            if (drop.get(e.getItem().getUniqueId()).equals(p.getUniqueId())) {

            } else {
                e.setCancelled(true);
            }
        }
    }

//    @EventHandler
//    public void onEntityDamage(EntityDeathEvent e){
//
//        Entity en = e.getEntity();
//        if (en instanceof LivingEntity) {
//            LivingEntity killer = ((LivingEntity) en).getKiller();
//            List<ItemStack> list = e.getDrops();
//            for (ItemStack item : list){
//                UUID uuid = UUID.randomUUID();
//                List<String> lore = new ArrayList<>();
//                lore.add(uuid.toString());
//                lore.add(killer.getUniqueId().toString());
//                drop.put(uuid, killer.getUniqueId());
//                item.setLore(lore);
//            }
//        }
//    }
}
