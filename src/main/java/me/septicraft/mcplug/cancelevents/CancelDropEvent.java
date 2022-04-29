package me.septicraft.mcplug.cancelevents;

/*
public class CancelDropEvent implements Listener {
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        ItemStack item = event.getItemDrop().getItemStack();
        Player p = event.getPlayer();
        event.setCancelled(true);
        NamespacedKey key = new NamespacedKey(instance, "dropper");
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, p.getUniqueId().toString());
        item.setItemMeta(meta);


    }
    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent e){

    }
}
*/