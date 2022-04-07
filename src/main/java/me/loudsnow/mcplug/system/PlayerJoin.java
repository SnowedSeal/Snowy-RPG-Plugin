package me.loudsnow.mcplug.system;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.loudsnow.mcplug.Main.instance;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if (e.getPlayer().getName().equals("RGolden")){
            Player p = e.getPlayer();
            p.sendMessage("Hello from Loudbook! Please remember to connect to the building server!");
            Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                @Override
                public void run() {
                    Player p = e.getPlayer();
                }
            }, 200);
        }
    }
}
