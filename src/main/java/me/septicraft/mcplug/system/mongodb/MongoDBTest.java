package me.septicraft.mcplug.system.mongodb;

import com.mongodb.*;
import me.septicraft.mcplug.Main;
import org.bson.Document;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class MongoDBTest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        UUID uuid = p.getUniqueId();
        String name = p.getName();
        Document document = new Document();
        document.append("_id", p.getUniqueId().toString());
        document.append("name", p.getName());
        //mongoCollection.insertOne(document);
        //mongoCollection.updateOne(Filters.eq("_id", p.getUniqueId().toString()), Updates.set("_id", p.getUniqueId().toString()));
//        String value  = mongoCollection.find().projection(Projections.include(p.getUniqueId().toString())).first().getString("name");
        DBObject query = new BasicDBObject("_id", p.getUniqueId().toString());
        //DBCursor cursor = Main.mongoCollection.find(query);
        //p.sendMessage(value);
        //DBCursor result = mongoCollection.find(query);
        //if (query.has){

        //}

        return true;
    }
}
