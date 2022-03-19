package me.loudsnow.mcplug;

import lombok.Getter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import javax.security.auth.login.LoginException;

import static me.loudsnow.mcplug.Main.jda;
import static org.bukkit.Bukkit.getServer;

public class ChatMessage implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent ev){
        String player = ev.getPlayer().getDisplayName();
        String message = ev.getMessage();
        TextChannel chatChannelID = jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");
        chatChannelID.sendMessage("<**" + player + "**> " + message).queue();
    }


}

