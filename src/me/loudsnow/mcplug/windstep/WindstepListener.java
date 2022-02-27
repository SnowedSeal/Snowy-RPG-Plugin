package me.loudsnow.mcplug.windstep;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.util.Vector;


import java.util.HashMap;

import static me.loudsnow.mcplug.Main.cd;
import static me.loudsnow.mcplug.Main.instance;

public class WindstepListener implements Listener {
    @EventHandler
    public void onPlayerCrouch(PlayerToggleSneakEvent event){
        Player p = event.getPlayer();
        if (p.isSneaking()){
            if (p.getInventory().getBoots() != null){
                if (event.getPlayer().isOnGround()) {
                    if (p.getInventory().getBoots().getItemMeta().getDisplayName().equals("" + ChatColor.GRAY + ChatColor.BOLD + "Windstep")) {

                        if (cd.containsKey(p.getUniqueId().toString())){
                            p.sendMessage(ChatColor.RED + "This object is on cooldown!");


                        } else {
                            p.setVelocity(new Vector(0, -1, 0));
                            Vector dir = p.getLocation().getDirection();
                            p.setVelocity(dir.multiply(2));

                            cd.put(p.getUniqueId().toString(), 0);


                            Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
                                @Override
                                public void run() {
                                    cd.remove(p.getUniqueId().toString());


                                }
                            }, 100, -1);

                        }
                    }
                }
            }
        }
    }

//Loud what is this code for? teleport boots when crouch it launches you
}
