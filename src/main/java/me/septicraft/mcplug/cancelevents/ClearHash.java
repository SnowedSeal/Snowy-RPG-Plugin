package me.septicraft.mcplug.cancelevents;

import me.septicraft.mcplug.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ClearHash implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        Main.cd9.remove(p.getUniqueId().toString());
        return false;
    }
}
