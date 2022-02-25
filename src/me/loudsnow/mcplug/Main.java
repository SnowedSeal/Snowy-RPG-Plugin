package me.loudsnow.mcplug;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("booktest").setExecutor(new CommandBookTest());
        getServer().getPluginManager().registerEvents(new CancelPortal(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        getServer().getPluginManager().registerEvents(new PigKillTest(), this);
    }

    @Override
    public void onDisable() {

    }


    public class CommandBookTest implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bookMeta = (BookMeta) book.getItemMeta();
                bookMeta.setTitle("Rules");
                bookMeta.setAuthor("The Loud Snowy Team");

                ArrayList<String> page = new ArrayList<String>();
                page.add("\n" + ChatColor.BOLD + "1: Be a nice person!" + "\n" + "\n" + "2: Dont greif others... \n \n 3: Try not to break the game :/ \n \n 4: Have a bunch of fun.");
                bookMeta.setPages(page);
                p.getInventory().addItem(book);

            }
            return true;
        }

    }

}
