package me.loudsnow.mcplug.armor.rookieglider;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

import static me.loudsnow.mcplug.Main.cd6;
import static me.loudsnow.mcplug.Main.instance;

public class RookieGliderListener implements Listener {

    private List<Player> rookieGliderListener;

    public RookieGliderListener() {
        rookieGliderListener = new ArrayList<>();
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().setAllowFlight(true);
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        rookieGliderListener.remove(e.getPlayer());
    }

    @EventHandler
    public void onPlayerHitGround (PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if ((p.isOnGround() || e.getTo().getBlock().isLiquid()) && rookieGliderListener.remove(p)) {
            p.setAllowFlight(true);
        }
    }
    @EventHandler
    public void onFlightToggle(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getChestplate() != null && p.getInventory().getChestplate().getItemMeta().getDisplayName().equals("" + ChatColor.GREEN + ChatColor.BOLD + "Rookie Glider")) {
            if (cd6.containsKey(p.getUniqueId().toString())) {
                p.sendMessage(ChatColor.RED + "Rookie Glider is on cooldown!");
                e.setCancelled(true);

            } else {
                GameMode gameMode = p.getGameMode();
                if (gameMode == GameMode.CREATIVE || gameMode == gameMode.SPECTATOR || p.isFlying()) {
                    return;

                }
                e.setCancelled(true);
                rookieGliderListener.add(p);
                p.setAllowFlight(false);
                p.setFlying(false);
                p.setVelocity(new Vector(0, 2, 0));
                cd6.put(p.getUniqueId().toString(), 0);
                Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                    @Override
                    public void run() {
                        p.sendMessage(ChatColor.GREEN + "Rookie Glider is no longer on cooldown!");
                        cd6.remove(p.getUniqueId().toString());
                        p.setAllowFlight(true);

                    }
                }, 600);
            }
        }
    }
}
