package me.loudsnow.mcplug.mobs.npcs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.io.BukkitObjectInputStream;

import java.util.ArrayList;

import static me.loudsnow.mcplug.Main.instance;

public class NPC1 implements Listener {
    @EventHandler
    public void onNpcClick(PlayerInteractEntityEvent event) {
        Player p = (Player) event.getPlayer();
        if (event.getHand() == EquipmentSlot.HAND) {
            Entity entity = event.getRightClicked();
            String uuid = entity.getUniqueId().toString();
            if (uuid.equals("14df8b0e-0bd7-27d4-81c6-e59fb8f0b208")) {
                p.sendMessage("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] Welcome to the Snowy SMP!");
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] I'm Gilbert, your starting guide!");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] As you progress, your items will become increasingly better.");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] You may have noticed when you joined that this world has a terrible plague.");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] The 7th relic, lost to time, has been constantly spawning enemies on this planets surface.");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] There are also 6 more relics, guarded by demons.");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] This world is in need of a hero, and I grant you the opportunity to be one.");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] This will be a long hard journey, I wish you luck.");
                final int[] i = {0};
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (i[0] == 7) {
                            cancel();
                        }
                        p.sendMessage(arrayList.get(i[0]));
                        i[0]++;
                    }
                }.runTaskTimer(instance, 20L * 2, 20L * 4);
            }
        }
    }
}



