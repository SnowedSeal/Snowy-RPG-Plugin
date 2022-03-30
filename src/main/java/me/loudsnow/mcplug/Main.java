package me.loudsnow.mcplug;

import lombok.Getter;
import me.loudsnow.mcplug.cancelevents.*;
import me.loudsnow.mcplug.desolation.DesolationAbilityListener;
import me.loudsnow.mcplug.desolation.DesolationCommand;
import me.loudsnow.mcplug.desolation.DesolationAttackListener;
import me.loudsnow.mcplug.discord.*;
import me.loudsnow.mcplug.flameblade.FlamebladeCommand;
import me.loudsnow.mcplug.flameblade.FlamebladeListener;
import me.loudsnow.mcplug.forestsword.ForestSwordCommand;
import me.loudsnow.mcplug.glowingpendant.GlowingPendantCommand;
import me.loudsnow.mcplug.meteorslam.MeteorSlamCommand;
import me.loudsnow.mcplug.meteorslam.MeteorSlamListener;
import me.loudsnow.mcplug.npcs.*;
import me.loudsnow.mcplug.report.ReportCommand;
import me.loudsnow.mcplug.report.ReportTabComplete;
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
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.awt.Color;
import java.io.*;
import java.util.*;

import static net.dv8tion.jda.api.interactions.commands.OptionType.USER;


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
    public static HashMap<String, Integer> cd9 = new HashMap<>();
    public static HashMap<String, Integer> horse = new HashMap<>();
    public static HashMap<String, Integer> horsealive = new HashMap<>();
    public static HashMap<String, Integer> player2 = new HashMap<>();
    public static HashMap<UUID, UUID> drop = new HashMap<>();
    public static boolean desolationdmg = false;
    public static Map<String, String> player = new HashMap<String, String>();
    public static Map<String, String> horseowner = new HashMap<String, String>();
    public static Map<String, Integer> horseint = new HashMap<String, Integer>();
    public static HashMap<String, Boolean> bugBoolean = new HashMap<>();
    public static HashMap<String, Boolean> abuseBoolean = new HashMap<>();
    public static HashMap<String, Boolean> errorBoolean = new HashMap<>();
    public static HashMap<String, Boolean> deathBoolean = new HashMap<>();



    @Getter
    public static JDA jda;
    private TextChannel textChannel;
    @Override
    public void onEnable() {
        this.reloadConfig();
        ConsoleCommandSender console = getServer().getConsoleSender();
        String botToken = getConfig().getString("discord-token");
        try {
            jda = JDABuilder.createDefault(botToken)
                    .addEventListeners(new DiscordMessage())
                    .addEventListeners(new SlashCommandInteraction())
                    .setActivity(Activity.listening("all the people on the server!"))
                    .build();
            jda.awaitReady();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (jda == null){
            console.sendMessage("Unable to connect to Discord!");
        }
        Guild guild = jda.getGuildById("945036462141890601");
        CommandListUpdateAction commands = guild.updateCommands();
        commands.addCommands(
                Commands.slash("help", "Gives info on how to join the server!")
                        .addOptions(new OptionData(USER, "user", "The user to ping in the process")));
        commands.queue();
        TextChannel channel = jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");
        channel.sendMessage("**Connected to Websocket**").queue();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new Color(0x00FF00));
        eb.setTitle(":white_check_mark:   **Server has started!**   :white_check_mark:");
        eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
        guild.updateCommands();
        channel.sendMessageEmbeds(eb.build()).queue();







        instance = this;
        getServer().getPluginManager().registerEvents(new CancelPortal(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(), this);
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
        this.getCommand("clearhash").setExecutor(new ClearHash());

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
        this.getCommand("report").setExecutor(new ReportCommand());
        this.getCommand("report").setTabCompleter(new ReportTabComplete());
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
        this.getCommand("testspawn").setExecutor(new Lvl1Mob());
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
        getServer().getPluginManager().registerEvents(new ChatMessage(), this);
        getServer().getPluginManager().registerEvents(new HealthBar(), this);

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

        console.sendMessage("================================");
        console.sendMessage("Snowy RPG Plugin Enabled");
        console.sendMessage("Version 2.4");
        console.sendMessage("Latest Major Update: Spawning Algorithm");
        console.sendMessage("================================");
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
            public void run(){
                Location EntityArea = new Location(Bukkit.getWorld("world"),328, 111, 196);
                World world = Bukkit.getServer().getWorld("world");
                List<Entity> nearbyEntities = (List<Entity>) EntityArea.getWorld().getNearbyEntities(EntityArea, 60, 15, 60);

                for(Entity e : world.getEntities()){
                    if (nearbyEntities.contains(e)){
                        if (e instanceof Player) {
                            if (e.isInWater()) {
                                ((Player) e).damage(1.5);
                                ((Player) e).sendTitle("" + ChatColor.BOLD + ChatColor.RED + "DANGER: POISON", "");
                            }
                        }
                    }
                }
            }
        },20, 20);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
            @Override
            public void run() {
                World world = Bukkit.getServer().getWorld("world");
                List<Player> players = world.getPlayers();

                for (Player p : players){
                    if(p.getLocation().getY() >= 175){
                        p.sendTitle("" + ChatColor.BOLD + ChatColor.RED + "Low Oxygen", "");
                        p.damage(2);
                    }
                }

            }
        }, 20, 20);
    }


    @Override
    public void onDisable() {

        TextChannel channel = jda.getGuildById("945036462141890601").getTextChannelById("946929911095001118");
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(new Color(0xFF0000));
        eb.setTitle(":x:   **Server has shut down!**   :x:");
        eb.setFooter("Snowy RPG Bot written in Java by Loudbook");
        channel.sendMessageEmbeds(eb.build()).queue();
        Properties properties = new Properties();
        Properties properties1 = new Properties();
        Properties properties2 = new Properties();
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("Saving Hashmap");
        if (jda != null){
            jda.shutdown();
        }

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



