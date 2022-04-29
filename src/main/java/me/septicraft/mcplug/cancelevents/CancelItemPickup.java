package me.septicraft.mcplug.cancelevents;

import me.septicraft.mcplug.Main;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class CancelItemPickup implements Listener {
    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        Main.drop.put(e.getItemDrop().getUniqueId(), p.getUniqueId());

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
        if (Main.drop.containsKey(e.getItem().getUniqueId())){
            if (Main.drop.get(e.getItem().getUniqueId()).equals(p.getUniqueId())) {

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
