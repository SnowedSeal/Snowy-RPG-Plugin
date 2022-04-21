package me.septicraft.mcplug.system.mongodb;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bson.Document;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static me.septicraft.mcplug.Main.mongoCollection;

public class MongoDBTest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player p = (Player) commandSender;
        Document document = new Document();
        document.append("_id", p.getUniqueId().toString());
        document.append("name", p.getName());
        mongoCollection.insertOne(document);
        //mongoCollection.updateOne(Filters.eq("_id", p.getUniqueId().toString()), Updates.set("_id", p.getUniqueId().toString()));
        JsonObject jsonObject = MongoDBUtil.readData("_id", p.getUniqueId());



        p.sendMessage(jsonObject.get("name").toString());
        return true;
    }
}
