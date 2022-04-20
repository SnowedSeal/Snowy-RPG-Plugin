package me.septicraft.mcplug.system.discord;

import me.septicraft.mcplug.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.awt.*;

public class ChatMessage implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent ev){
        Player p = ev.getPlayer();
        if (Main.bank1.containsKey(p.getUniqueId().toString())) {
            int amount = -1;
            boolean stop = false;
            ev.setCancelled(true);
            try {
                amount = Integer.parseInt(ev.getMessage());
            } catch (Exception e) {
                p.sendMessage(ChatColor.RED + "Incorrect Syntax! Please try again.");
                Main.bank1.remove(p.getUniqueId().toString());
                stop = true;
            }
            if (amount == 0){
                if (stop == false) {
                    p.sendMessage(ChatColor.RED + "You must choose a number greater than 0!");
                    Main.bank1.remove(p.getUniqueId().toString());
                }
            }
            NamespacedKey namespacedKey = new NamespacedKey(Main.instance, "balance");
            PersistentDataContainer pbalance = p.getPersistentDataContainer();
            int num = pbalance.get(namespacedKey, PersistentDataType.INTEGER);
            Main.bank1.remove(p.getUniqueId().toString());
            if (amount != 0 && num >= amount) {
                pbalance.set(namespacedKey, PersistentDataType.INTEGER, num - amount);
                ItemStack sunflower = new ItemStack(Material.SUNFLOWER, amount);
                p.getInventory().addItem(sunflower);
                p.sendMessage(ChatColor.GREEN + "Done!");

            } else {
                p.sendMessage(ChatColor.RED + "You don't have enough!");
                Main.bank1.remove(p.getUniqueId().toString());
            }

        }
        if (Main.bugBoolean.containsKey(p.getUniqueId().toString())){
            String message = ev.getMessage();
            p.sendMessage(ChatColor.GREEN + "Thanks for reporting!");
            TextChannel reportChannel = Main.jda.getGuildById("945036462141890601").getTextChannelById("955226290095546448");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(new Color(0xFF0000));
            eb.setTitle("**Bug Report**");
            eb.setDescription("**" + p.getDisplayName() + ":** " + message);
            eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
            reportChannel.sendMessageEmbeds(eb.build()).queue();
            Main.bugBoolean.remove(p.getUniqueId().toString());
            p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "Transcript: " + ChatColor.RESET + message);
            ev.setCancelled(true);
        }
        if (Main.abuseBoolean.containsKey(p.getUniqueId().toString())){
            String message = ev.getMessage();
            p.sendMessage(ChatColor.GREEN + "Thanks for reporting!");
            TextChannel reportChannel = Main.jda.getGuildById("945036462141890601").getTextChannelById("955226290095546448");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(new Color(0xFF0000));
            eb.setTitle("**Abuse Report**");
            eb.setDescription("**" + p.getDisplayName() + ":** " + message);
            eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
            reportChannel.sendMessageEmbeds(eb.build()).queue();
            Main.abuseBoolean.remove(p.getUniqueId().toString());
            p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "Transcript: " + ChatColor.RESET + message);
            ev.setCancelled(true);
        }
        if (Main.errorBoolean.containsKey(p.getUniqueId().toString())){
            String message = ev.getMessage();
            p.sendMessage(ChatColor.GREEN + "Thanks for reporting!");
            TextChannel reportChannel = Main.jda.getGuildById("945036462141890601").getTextChannelById("955226290095546448");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(new Color(0xFF0000));
            eb.setTitle("**Error Report**");
            eb.setDescription("**" + p.getDisplayName() + ":** " + message);
            eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
            reportChannel.sendMessageEmbeds(eb.build()).queue();
            Main.errorBoolean.remove(p.getUniqueId().toString());
            p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "Transcript: " + ChatColor.RESET + message);
            ev.setCancelled(true);
        }
        if (Main.deathBoolean.containsKey(p.getUniqueId().toString())) {
            String message = ev.getMessage();
            p.sendMessage(ChatColor.GREEN + "Thanks for reporting!");
            TextChannel reportChannel = Main.jda.getGuildById("945036462141890601").getTextChannelById("955226290095546448");
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(new Color(0xFF0000));
            eb.setTitle("**Death Report**");
            eb.setDescription("**" + p.getDisplayName() + ":** " + message);
            eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
            reportChannel.sendMessageEmbeds(eb.build()).queue();
            Main.deathBoolean.remove(p.getUniqueId().toString());
            p.sendMessage("" + ChatColor.GRAY + ChatColor.BOLD + "Transcript: " + ChatColor.RESET + message);
            ev.setCancelled(true);
        }
        String player = ev.getPlayer().getDisplayName();
        String message = ev.getMessage();
        TextChannel chatChannelID = Main.jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");
        chatChannelID.sendMessage("<**" + player + "**> " + message).queue();
    }
}

