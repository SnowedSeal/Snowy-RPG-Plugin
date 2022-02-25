package me.loudsnow.mcplug;

import me.loudsnow.mcplug.npcs.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new CancelPortal(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        getServer().getPluginManager().registerEvents(new PigKillTest(), this);
        getServer().getPluginManager().registerEvents(new ArmorStandCancel(), this);
        getServer().getPluginManager().registerEvents(new CancelBreakEvent(), this);
        getServer().getPluginManager().registerEvents(new CancelPlaceEvent(), this);
        getServer().getPluginManager().registerEvents(new NPC1(), this);
        getServer().getPluginManager().registerEvents(new NPC2(), this);
        getServer().getPluginManager().registerEvents(new NPC3(), this);
        getServer().getPluginManager().registerEvents(new NPC4(), this);
        getServer().getPluginManager().registerEvents(new NPC5(), this);
    }

    @Override
    public void onDisable() {

    }


}