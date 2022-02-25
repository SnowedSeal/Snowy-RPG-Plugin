package me.loudsnow.mcplug;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class JoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if(!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage("" + ChatColor.GOLD + ChatColor.BOLD + "Welcome to the server " + event.getPlayer().getName() + "! \n" + ChatColor.YELLOW + "Please take a moment to read the rules!");
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta bookMeta = (BookMeta) book.getItemMeta();
            bookMeta.setTitle("Rules");
            bookMeta.setAuthor("The Loud Snowy Team");

            ArrayList<String> page = new ArrayList<String>();
            page.add("\n" + ChatColor.BOLD + "1: Be a nice person!" + "\n" + "\n" + "2: Dont greif others... \n \n 3: Try not to break the game :/ \n \n 4: Have a bunch of fun.");
            bookMeta.setPages(page);
            p.getInventory().addItem(book);



        }
    }
}