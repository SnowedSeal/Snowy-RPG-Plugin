package me.loudsnow.mcplug;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

import static me.loudsnow.mcplug.Main.*;

public class QuitEvent implements Listener {
    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage("" + ChatColor.RED + ChatColor.BOLD + p.getName() + " quit the server!");
        TextChannel channel = jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new Color(0xFF0000));
        eb.setTitle("**" + p.getDisplayName() + " quit the server!**");
        eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
        channel.sendMessageEmbeds(eb.build()).queue();
        World world = p.getWorld();
        for(World w : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()){
                if (entity instanceof Horse) {
                    if (((Horse) entity).getOwner() != null) {
                        if (((Horse) entity).getOwner().equals(p)) {
                            entity.remove();
                            horsealive.remove(p.getUniqueId().toString());
                        }
                    }
                }
            }
        }
    }
}
