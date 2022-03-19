package me.loudsnow.mcplug;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import javax.security.auth.login.LoginException;
import java.io.Console;

import static org.bukkit.Bukkit.getServer;

public class ReadyListener implements EventListener {
    public static void main(String[] args)
            throws LoginException, InterruptedException {
        // Note: It is important to register your ReadyListener before building
        JDA jda = JDABuilder.createDefault("OTU0MTcxOTY0MzAwMzYxNzc4.YjPP4w.DoXLg9WOtS9gMfkPjYvfvisaPm0")
                .addEventListeners(new ReadyListener())
                .build();
        TextChannel channel = jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");
        // optionally block until JDA is ready
        jda.awaitReady();
    }

    @Override
    public void onEvent(GenericEvent event) {
        if (event instanceof ReadyEvent) {
            JDA jda = (JDA) JDABuilder.createDefault("OTU0MTcxOTY0MzAwMzYxNzc4.YjPP4w.DoXLg9WOtS9gMfkPjYvfvisaPm0");
            TextChannel channel = jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");

            channel.sendMessage("Test");
        }
    }
}
