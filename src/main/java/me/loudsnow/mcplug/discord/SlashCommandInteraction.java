package me.loudsnow.mcplug.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import javax.security.auth.login.LoginException;

import static me.loudsnow.mcplug.Main.jda;
import static net.dv8tion.jda.api.interactions.commands.OptionType.USER;

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