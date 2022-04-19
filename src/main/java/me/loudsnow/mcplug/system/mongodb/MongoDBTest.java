package me.loudsnow.mcplug.system.mongodb;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import static me.loudsnow.mcplug.Main.mongoCollection;

public class MongoDBTest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        UUID uuid = p.getUniqueId();
        String name = p.getName();
        Document document = new Document();
        document.append("uuid", p.getUniqueId().toString());
        document.append("name", p.getName());
        //mongoCollection.insertOne(document);
        mongoCollection.updateOne(Filters.eq("uuid", p.getUniqueId().toString()), Updates.set("uuid", "p.getUniqueId().toString()"));

        return true;
    }
}
