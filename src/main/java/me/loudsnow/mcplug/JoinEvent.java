package me.loudsnow.mcplug;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;

import static me.loudsnow.mcplug.Main.*;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("" + ChatColor.GREEN + ChatColor.BOLD + p.getName() + " joined the server!");
        TextChannel channel = jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new Color(0x00FF00));
        eb.setTitle("**" + p.getDisplayName() + " joined the server!**");
        eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
        channel.sendMessageEmbeds(eb.build()).queue();
        if (horseowner.containsKey(p.getUniqueId().toString())) {
            p.sendMessage(ChatColor.YELLOW + "Use /whistle to summon your horse!");

        }
    }
}
