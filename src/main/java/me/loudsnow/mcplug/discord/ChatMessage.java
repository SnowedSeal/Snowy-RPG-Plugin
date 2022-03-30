package me.loudsnow.mcplug.discord;

import lombok.Getter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import javax.security.auth.login.LoginException;

import java.awt.*;

import static me.loudsnow.mcplug.Main.*;
import static org.bukkit.Bukkit.getServer;

public class ChatMessage implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent ev){
        Player p = ev.getPlayer();
        if (bugBoolean.containsKey(p.getUniqueId().toString())){
            String message = ev.getMessage();
            p.sendMessage(ChatColor.GREEN + "Thanks for reporting!");
            TextChannel reportChannel = jda.getGuildById("945036462141890601").getTextChannelById("955226290095546448");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(new Color(0xFF0000));
            eb.setTitle("**Bug Report**");
            eb.setDescription("**" + p.getDisplayName() + ":** " + message);
            eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
            reportChannel.sendMessageEmbeds(eb.build()).queue();
            bugBoolean.remove(p.getUniqueId().toString());
            p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "Transcript: " + ChatColor.RESET + message);
            ev.setCancelled(true);
        }
        if (abuseBoolean.containsKey(p.getUniqueId().toString())){
            String message = ev.getMessage();
            p.sendMessage(ChatColor.GREEN + "Thanks for reporting!");
            TextChannel reportChannel = jda.getGuildById("945036462141890601").getTextChannelById("955226290095546448");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(new Color(0xFF0000));
            eb.setTitle("**Abuse Report**");
            eb.setDescription("**" + p.getDisplayName() + ":** " + message);
            eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
            reportChannel.sendMessageEmbeds(eb.build()).queue();
            abuseBoolean.remove(p.getUniqueId().toString());
            p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "Transcript: " + ChatColor.RESET + message);
            ev.setCancelled(true);
        }
        if (errorBoolean.containsKey(p.getUniqueId().toString())){
            String message = ev.getMessage();
            p.sendMessage(ChatColor.GREEN + "Thanks for reporting!");
            TextChannel reportChannel = jda.getGuildById("945036462141890601").getTextChannelById("955226290095546448");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(new Color(0xFF0000));
            eb.setTitle("**Error Report**");
            eb.setDescription("**" + p.getDisplayName() + ":** " + message);
            eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
            reportChannel.sendMessageEmbeds(eb.build()).queue();
            errorBoolean.remove(p.getUniqueId().toString());
            p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "Transcript: " + ChatColor.RESET + message);
            ev.setCancelled(true);
        }
        if (deathBoolean.containsKey(p.getUniqueId().toString())) {
            String message = ev.getMessage();
            p.sendMessage(ChatColor.GREEN + "Thanks for reporting!");
            TextChannel reportChannel = jda.getGuildById("945036462141890601").getTextChannelById("955226290095546448");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(new Color(0xFF0000));
            eb.setTitle("**Death Report**");
            eb.setDescription("**" + p.getDisplayName() + ":** " + message);
            eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
            reportChannel.sendMessageEmbeds(eb.build()).queue();
            deathBoolean.remove(p.getUniqueId().toString());
            p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "Transcript: " + ChatColor.RESET + message);
            ev.setCancelled(true);
        }
        String player = ev.getPlayer().getDisplayName();
        String message = ev.getMessage();
        TextChannel chatChannelID = jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");
        chatChannelID.sendMessage("<**" + player + "**> " + message).queue();
    }
}

