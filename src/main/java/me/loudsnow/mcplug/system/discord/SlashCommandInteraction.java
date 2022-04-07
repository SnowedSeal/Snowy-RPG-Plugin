package me.loudsnow.mcplug.system.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandInteraction extends ListenerAdapter{
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if (e.getName().equals("help")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(0x008B8B);
            eb.setTitle("**Server Info**");
            eb.setImage("https://i.imgur.com/xAcK8NW.jpg");
            eb.addBlankField(false);
            eb.setDescription("**Server IP:** play.snowyrpg.xyz\n**Direct IP:** 51.161.16.124:25578\n \n__**Server Status:** Alpha Phase, whitelist only!__ \n \nPlease contact Loudbook for more info.");
            eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
            e.replyEmbeds(eb.build()).queue();
            try{
                String user = e.getOption("user").getAsString();
                TextChannel channel = e.getTextChannel();
                channel.sendMessage("<@" + user + ">").queue();
            } catch (NullPointerException ex) {
            }
        }
    }
}