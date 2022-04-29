package me.septicraft.mcplug.system.report;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ReportTabComplete implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1){
            List<String> reportType = new ArrayList<>();
            reportType.add("bug");
            reportType.add("abuse");
            reportType.add("error");
            reportType.add("death");
            return reportType;

        }
        return null;
    }
}
