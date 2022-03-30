package me.loudsnow.mcplug.discord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class DiscordMessage extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if (e.getAuthor().isBot()) return;
        JDA jda = e.getJDA();
        if (e.isFromType(ChannelType.TEXT)){
            Guild guild = e.getGuild();
            TextChannel textChannel = e.getTextChannel();
            String member = e.getMember().getEffectiveName();
            String message = e.getMessage().getContentRaw();
            if (e.getTextChannel().getId().equals("946929911095001118")) {
                Bukkit.broadcastMessage("" + ChatColor.BLUE + ChatColor.BOLD + "[Discord] <" + member + "> " + ChatColor.RESET + message);
            }
        }
    }
}
