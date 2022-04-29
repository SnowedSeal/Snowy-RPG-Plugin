package me.septicraft.mcplug.system.discord;

import com.github.retrooper.packetevents.protocol.world.states.enums.South;
import com.google.gson.JsonObject;
import me.septicraft.mcplug.system.mongodb.MongoDBUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class SlashCommandInteraction extends ListenerAdapter{
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e){
        if (e.getName().equals("help")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(0x008B8B);
            eb.setTitle("**Server Info**");
            eb.setImage("https://i.imgur.com/xAcK8NW.jpg");
            eb.addBlankField(false);
            eb.setDescription("**Server IP:** play.snowyrpg.xyz\n**Direct IP:** 66.59.211.94:25566\n \n__**Server Status:** Alpha Phase, whitelist only!__ \n \nPlease contact Loudbook for more info.");
            eb.setFooter("Septicraft Bot written in Java by Loudbook");
            e.replyEmbeds(eb.build()).queue();
            try{
                String user = e.getOption("user").getAsString();
                TextChannel channel = e.getTextChannel();
                channel.sendMessage("<@" + user + ">").queue();
            } catch (NullPointerException ex) {
            }
        }
        if (e.getName().equals("tps")){
            TextChannel channel = e.getTextChannel();
            double [] tps = Bukkit.getServer().getTPS();
            e.reply("**Current TPS:** " + Math.round(tps[0] * 100 / 100)).queue();
        }
        if (e.getName().equals("fetch")){
            String pl = e.getOption("username").getAsString();
            try{
                Player p = Bukkit.getPlayer(pl);
                JsonObject object = MongoDBUtil.readData("_id", p.getUniqueId());
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle(pl + "'s data:");
                eb.setColor(0x00FF00);
                String name = String.valueOf(object.get("name"));
                String joined = String.valueOf(object.get("joined"));
                eb.setDescription("**Username:**" + name.replace('"', ' ') + "\n**Joined:**" + joined.replace('"', ' ') + "\n**Balance:** " + object.get("balance") + "\n**Status:** Online");
                eb.setThumbnail("https://minotar.net/avatar/" + p.getUniqueId());
                e.replyEmbeds(eb.build()).queue();
            }catch(Exception ex){
                try {
                    OfflinePlayer p = Bukkit.getOfflinePlayer(pl);
                    JsonObject object = MongoDBUtil.readData("_id", p.getUniqueId());
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.setTitle(pl + "'s data:");
                    eb.setColor(0xFF0000);
                    eb.setThumbnail("https://minotar.net/avatar/" + p.getUniqueId());
                    String name = String.valueOf(object.get("name"));
                    String joined = String.valueOf(object.get("joined"));
                    eb.setDescription("**Username:**" + name.replace('"', ' ') + "\n**Joined:**" + joined.replace('"', ' ') + "\n**Balance:** " + object.get("balance") + "\n**Status:** Offline");
                    e.replyEmbeds(eb.build()).queue();
                } catch (Exception ex1){
                    e.reply("Invalid Username! This will also happen if the player has not joined before.").queue();
                }
            }

            try{

            } catch (Exception ex){
                e.reply("Invalid Username").queue();
            }

        }
    }
}