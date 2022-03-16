package me.loudsnow.mcplug;

import me.loudsnow.mcplug.cancelevents.*;
import me.loudsnow.mcplug.desolation.DesolationAbilityListener;
import me.loudsnow.mcplug.desolation.DesolationCommand;
import me.loudsnow.mcplug.desolation.DesolationAttackListener;
import me.loudsnow.mcplug.flameblade.FlamebladeCommand;
import me.loudsnow.mcplug.flameblade.FlamebladeListener;
import me.loudsnow.mcplug.forestsword.ForestSwordCommand;
import me.loudsnow.mcplug.glowingpendant.GlowingPendantCommand;
import me.loudsnow.mcplug.meteorslam.MeteorSlamCommand;
import me.loudsnow.mcplug.meteorslam.MeteorSlamListener;
import me.loudsnow.mcplug.npcs.*;
import me.loudsnow.mcplug.rookieglider.RookieGliderCommand;
import me.loudsnow.mcplug.rookieglider.RookieGliderListener;
import me.loudsnow.mcplug.salvation.SalvationCommand;
import me.loudsnow.mcplug.salvation.SalvationListener;
import me.loudsnow.mcplug.shadowleap.ShadowleapCommand;
import me.loudsnow.mcplug.shadowleap.ShadowleapListener;
import me.loudsnow.mcplug.starterdagger.starterdaggerCommand;
import me.loudsnow.mcplug.startersword.starterswordCommand;
import me.loudsnow.mcplug.truedeso.trueDesoCommand;
import me.loudsnow.mcplug.truedeso.trueDesoListener;
import me.loudsnow.mcplug.windstep.WindstepCommand;
import me.loudsnow.mcplug.windstep.WindstepListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.*;


public class Main extends JavaPlugin {
    public static File file;
    public static Main instance;
    public static Map<String, Integer> bank = new HashMap<String, Integer>();
    public static HashMap<String, Integer> cd1 = new HashMap<>();
    public static HashMap<String, Integer> cd = new HashMap<>();
    public static HashMap<String, Integer> cd2 = new HashMap<>();
    public static HashMap<String, Integer> hitground = new HashMap<>();
    public static HashMap<String, Integer> cd3 = new HashMap<>();
    public static HashMap<String, Integer> boolea = new HashMap<>();
    public static HashMap<String, Integer> cd4 = new HashMap<>();
    public static HashMap<String, Integer> cd5 = new HashMap<>();
    public static HashMap<String, Integer> cd6 = new HashMap<>();
    public static HashMap<String, Integer> cd7 = new HashMap<>();
    public static HashMap<String, Integer> cd8 = new HashMap<>();
    public static HashMap<String, Integer> horse = new HashMap<>();
    public static HashMap<String, Integer> horsealive = new HashMap<>();
    public static HashMap<String, Integer> player2 = new HashMap<>();
    public static HashMap<UUID, UUID> drop = new HashMap<>();
    public static boolean desolationdmg = false;
    public static Map<String, String> player = new HashMap<String, String>();
    public static Map<String, String> horseowner = new HashMap<String, String>();
    public static Map<String, Integer> horseint = new HashMap<String, Integer>();


    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new CancelPortal(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        getServer().getPluginManager().registerEvents(new PigKillTest(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        // getServer().getPluginManager().registerEvents(new ArmorStandCancel(), this);
        getServer().getPluginManager().registerEvents(new CancelBreakEvent(), this);
        getServer().getPluginManager().registerEvents(new CancelPlaceEvent(), this);
        getServer().getPluginManager().registerEvents(new NPC1(), this);
        getServer().getPluginManager().registerEvents(new NPC2(), this);
        getServer().getPluginManager().registerEvents(new NPC3(), this);
        getServer().getPluginManager().registerEvents(new NPC4(), this);
        getServer().getPluginManager().registerEvents(new NPC5(), this);
        getServer().getPluginManager().registerEvents(new TraderSpawn(), this);
        getServer().getPluginManager().registerEvents(new NPC6(), this);
        this.getCommand("getwindstep").setExecutor(new WindstepCommand());
        getServer().getPluginManager().registerEvents(new WindstepListener(), this);
        getServer().getPluginManager().registerEvents(new CancelItemPickup(), this); // <- this
        getServer().getPluginManager().registerEvents(new CancelFallDamage(), this);
        this.getCommand("getmeteorslam").setExecutor(new MeteorSlamCommand());
        this.getCommand("getshadowleap").setExecutor(new ShadowleapCommand());
        this.getCommand("getdesolation").setExecutor(new DesolationCommand());
        getServer().getPluginManager().registerEvents(new MeteorSlamListener(), this);
        getServer().getPluginManager().registerEvents(new CancelBedEnter(), this);
        getServer().getPluginManager().registerEvents(new ShadowleapListener(), this);
        this.getCommand("getdesolation").setExecutor(new DesolationCommand());
        getServer().getPluginManager().registerEvents(new DesolationAttackListener(), this);
        getServer().getPluginManager().registerEvents(new DesolationAbilityListener(), this);
        this.getCommand("gettruedesolation").setExecutor(new trueDesoCommand());
        this.getCommand("getstarterdagger").setExecutor(new starterdaggerCommand());
        this.getCommand("getstartersword").setExecutor(new starterswordCommand());
        this.getCommand("getrookieglider").setExecutor(new RookieGliderCommand());
        getServer().getPluginManager().registerEvents(new trueDesoListener(), this);
        getServer().getPluginManager().registerEvents(new TrainingDummy(), this);
        getServer().getPluginManager().registerEvents(new CancelHorseRide(), this);
        getServer().getPluginManager().registerEvents(new RookieGliderListener(), this);
        this.getCommand("getflameblade").setExecutor(new FlamebladeCommand());
        getServer().getPluginManager().registerEvents(new FlamebladeListener(), this);
        getServer().getPluginManager().registerEvents(new SalvationListener(), this);
        getServer().getPluginManager().registerEvents(new SalvationListener(), this);
        getServer().getPluginManager().registerEvents(new NPC8(), this);
        getServer().getPluginManager().registerEvents(new HorseListener(), this);
        this.getCommand("getsalvation").setExecutor(new SalvationCommand());
        this.getCommand("getforestsword").setExecutor(new ForestSwordCommand());
        this.getCommand("getglowingpendant").setExecutor(new GlowingPendantCommand());
        this.getCommand("hashmaptest").setExecutor(new TestHashCommand());
        this.getCommand("whistle").setExecutor(new Whistle());
        getServer().getPluginManager().registerEvents(new HorseDeath(), this);
        getServer().getPluginManager().registerEvents(new QuitEvent(), this);
        //getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new CancelPVP(), this);
        getServer().getPluginManager().registerEvents(new CancelHorseDamage(), this);
        getServer().getPluginManager().registerEvents(new CancelSaddle(), this);
        getServer().getPluginManager().registerEvents(new CancelUnload(), this);
        getServer().getPluginManager().registerEvents(new CancelBerryHarvest(), this);
        getServer().getPluginManager().registerEvents(new BankerInventory(), this);
        getServer().getPluginManager().registerEvents(new BankerListener(), this);
        getServer().getPluginManager().registerEvents(new BankerWithdraw(), this);
        getServer().getPluginManager().registerEvents(new BankerDeposit(), this);
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("data.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : properties.stringPropertyNames()) {
            player.put(key, properties.get(key).toString());
        }

        Properties properties2 = new Properties();
        try {
            properties2.load(new FileInputStream("bank.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String key : properties2.stringPropertyNames()) {
            bank.put(key, Integer.parseInt((String) properties2.get(key)));
        }

        Properties properties1 = new Properties();
        try {
            properties1.load(new FileInputStream("horse.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String key : properties1.stringPropertyNames()) {
            horseowner.put(key, properties1.get(key).toString());
        }


/*
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
            public void run(){

                for (Player p : Bukkit.getOnlinePlayers()){
                    ItemStack power = new ItemStack(Material.BLAZE_POWDER);
                    ItemMeta meta = power.getItemMeta();
                    meta.setDisplayName("" + ChatColor.BLUE + ChatColor.BOLD + "Glowing Pendant");
                    power.setItemMeta(meta);

                    if (p.getInventory().containsAtLeast(power, 1))  {
                        p.sendMessage("You have the item!");
                    }
                }
            }
        }, 20L, 10L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
            public void run(){
                for(World w : Bukkit.getWorlds()) {
                    for (Entity entity : w.getEntities()) {
                        if (entity instanceof Horse) {
                            if (((Horse) entity).getOwner() != null) {
                                Player owner = (Player) ((Horse) entity).getOwner();
                                ((Horse) entity).setTarget(owner);
                            }
                        }
                    }
                }

            }
        }, 0L, 5L);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
            public void run(){

            }
        }, 0L, 5L);
*/

        // HashMaps.bank = loadHashMap("bank");

        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("================================");
        console.sendMessage("Snowy RPG Plugin Enabled");
        console.sendMessage("Version 1.2");
        console.sendMessage("================================");
    }

    @Override
    public void onDisable() {
        Properties properties = new Properties();
        Properties properties1 = new Properties();
        Properties properties2 = new Properties();
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("Saving Hashmap");


        for (Map.Entry<String, String> entry : player.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }

        try {
            properties.store(new FileOutputStream("data.properties"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Map.Entry<String, String> entry : horseowner.entrySet()) {
            properties1.put(entry.getKey(), entry.getValue());
        }

        try {
            properties1.store(new FileOutputStream("horse.properties"), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : bank.entrySet()) {
            properties2.put(entry.getKey(), entry.getValue().toString());
        }

        try {
            properties2.store(new FileOutputStream("bank.properties"), null);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}







