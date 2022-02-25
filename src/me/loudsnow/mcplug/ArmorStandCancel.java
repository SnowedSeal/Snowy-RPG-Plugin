package me.loudsnow.mcplug;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ArmorStandCancel implements Listener {
    @EventHandler
    public void onStandManipulation(PlayerArmorStandManipulateEvent event) {
        Player player = event.getPlayer();
        if ()
            if (player.getDisplayName().equals("RGolden")) {
                player.sendMessage("Bypassing Armor Stand Rule");
            } else {
                event.setCancelled(true);
            }
    }
}
public class StandCancel extends JavaPlugin {

    public class CommandArmorStandBreak implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                boolean armorstand = true;
                armorstand = !armorstand;

            }

            return true;
        }
    }
}

