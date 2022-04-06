package me.loudsnow.mcplug;

//import com.comphenix.protocol.ProtocolLibrary;
//import com.comphenix.protocol.ProtocolManager;
import com.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import it.unimi.dsi.fastutil.doubles.DoubleArrayList;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import lombok.Getter;
import me.loudsnow.mcplug.cancelevents.*;
import me.loudsnow.mcplug.desolation.DesolationAbilityListener;
import me.loudsnow.mcplug.desolation.DesolationAttackListener;
import me.loudsnow.mcplug.desolation.DesolationCommand;
import me.loudsnow.mcplug.discord.*;
import me.loudsnow.mcplug.flameblade.FlamebladeCommand;
import me.loudsnow.mcplug.flameblade.FlamebladeListener;
import me.loudsnow.mcplug.forestsword.ForestSwordCommand;
import me.loudsnow.mcplug.glowingpendant.GlowingPendantCommand;
import me.loudsnow.mcplug.meteorslam.MeteorSlamCommand;
import me.loudsnow.mcplug.meteorslam.MeteorSlamListener;
import me.loudsnow.mcplug.mobdeaths.lvl1death;
import me.loudsnow.mcplug.npcs.*;
import me.loudsnow.mcplug.packets.Boom;
import me.loudsnow.mcplug.packets.PacketTest;
import me.loudsnow.mcplug.report.ReportCommand;
import me.loudsnow.mcplug.report.ReportTabComplete;
import me.loudsnow.mcplug.rookieglider.RookieGliderCommand;
import me.loudsnow.mcplug.rookieglider.RookieGliderListener;
import me.loudsnow.mcplug.salvation.SalvationCommand;
import me.loudsnow.mcplug.salvation.SalvationListener;
import me.loudsnow.mcplug.shadowleap.ShadowleapCommand;
import me.loudsnow.mcplug.shadowleap.ShadowleapListener;
import me.loudsnow.mcplug.snowblade.SnowBladeListener;
import me.loudsnow.mcplug.snowblade.SnowbladeCommand;
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
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import javax.security.auth.login.LoginException;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.*;

import static net.dv8tion.jda.api.interactions.commands.OptionType.USER;

public class Main extends JavaPlugin {
    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        //Are all listeners read only?
        PacketEvents.getAPI().getSettings().readOnlyListeners(true)
                .checkForUpdates(true)
                .bStats(true);
        PacketEvents.getAPI().load();
    }
    public static File file;
    public static Main instance;

    public static Map<String, Integer> bank = new HashMap<String, Integer>();
    public static Map<String, Boolean> bank1 = new HashMap<String, Boolean>();

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
    //public static ProtocolManager manager = ProtocolLibrary.getProtocolManager();

    @Getter
    public static JDA jda;
    private TextChannel textChannel;
    @Override
    public void onEnable() {
//        ProtocolManager manager = ProtocolLibrary.getProtocolManager();
        PacketEvents.getAPI().init();
        /*
        manager.addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Client.POSITION) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                PacketContainer packet = event.getPacket();
                Player p = event.getPlayer();
                double x = packet.getDoubles().read(0);
                double y = packet.getDoubles().read(1);
                double z = packet.getDoubles().read(2);
                boolean onGround = packet.getBooleans().read(0);
                p.sendMessage("INBOUND X: " + x + " Y: " + y + " Z: " + z + " : On Ground? " + onGround);
            }
        });*/
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
        //getServer().getPluginManager().registerEvents(new ArmorStandCancel(), this);
        getServer().getPluginManager().registerEvents(new CancelBreakEvent(), this);
//        getServer().getPluginManager().registerEvents(new CancelPlaceEvent(), this);
        getServer().getPluginManager().registerEvents(new NPC1(), this);
        getServer().getPluginManager().registerEvents(new NPC2(), this);
        getServer().getPluginManager().registerEvents(new NPC3(), this);
        getServer().getPluginManager().registerEvents(new NPC4(), this);
        getServer().getPluginManager().registerEvents(new NPC5(), this);
        getServer().getPluginManager().registerEvents(new TraderSpawn(), this);
        getServer().getPluginManager().registerEvents(new NPC6(), this);
        this.getCommand("getwindstep").setExecutor(new WindstepCommand());
        this.getCommand("clearhash").setExecutor(new ClearHash());
        getServer().getPluginManager().registerEvents(new CancelTransform(), this);
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
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
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
        getServer().getPluginManager().registerEvents(new lvl1death(), this);
        getServer().getPluginManager().registerEvents(new CancelFire(), this);
        getServer().getPluginManager().registerEvents(new CancelSandFall(), this);
        this.getCommand("spawnqueen").setExecutor(new SpawnQueen());
        this.getCommand("boom").setExecutor(new Boom());
        this.getCommand("getsnowblade").setExecutor(new SnowbladeCommand());
        getServer().getPluginManager().registerEvents(new SnowBladeListener(), this);
        this.getCommand("packettest").setExecutor(new PacketTest());
        instance = instance;




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
        console.sendMessage("Version 2.5");
        console.sendMessage("Latest Major Update: Packets");
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
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
            public void run(){
                Location EntityArea = new Location(Bukkit.getWorld("world"),149, 116, 38);
                World world = Bukkit.getServer().getWorld("world");
                List<Entity> nearbyEntities = (List<Entity>) EntityArea.getWorld().getNearbyEntities(EntityArea, 41, 41, 41);
                List<Entity> tooClose = (List<Entity>) EntityArea.getWorld().getNearbyEntities(EntityArea, 38, 38, 38);
                for(Entity e : world.getEntities()){
                    if (e instanceof Zombie){
                        if (nearbyEntities.contains(e)) {
                            Vector dir = e.getLocation().getDirection();
                            e.setVelocity(dir.multiply(-1));
                        }
                        if (tooClose.contains(e)){
                            e.remove();
                            world.spawnParticle(Particle.DRAGON_BREATH, e.getLocation(), 50, 0, 0, 0, 0.05);
                        }
                    }
                }
            }
        },20, 20);
/*        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
            @Override
            public void run() {
                World world = Bukkit.getServer().getWorld("world");
                for (Entity e : world.getEntities()){
                    if (e instanceof Wither){
                        ((Wither) e).setInvulnerableTicks(-800);
                    }
                }
            }
        }, 0, 0);*/
/*        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
            @SuppressWarnings("deprecation")
            @Override
            public void run() {
                World world = Bukkit.getServer().getWorld("world");
                Location loc1 = new Location(world, 201, 113, -551);
                List<Player> entities=  new ArrayList<>();
                for (Player en : loc1.getNearbyPlayers(20, 20, 20)){
                    entities.add(en);
                }
                if (entities.size() >= 1){
                    Location loc = new Location(world, 218, 113, -552);
                    FallingBlock mat = world.spawnFallingBlock(loc, Material.BLUE_CONCRETE_POWDER, (byte) 0);
                    mat.setVelocity(new Vector(-0.82, 1.2, 0));
                    mat.setDropItem(false);
                }
            }
        }, 20, 2);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
            @SuppressWarnings("deprecation")
            @Override
            public void run() {
                World world = Bukkit.getServer().getWorld("world");
                Location loc1 = new Location(world, 201, 113, -551);
                List<Player> entities=  new ArrayList<>();
                for (Player en : loc1.getNearbyPlayers(20, 20, 20)){
                    entities.add(en);
                }
                if (entities.size() >= 1){
                    Location loc = new Location(world, 184, 113, -552);
                    FallingBlock mat = world.spawnFallingBlock(loc, Material.BLUE_CONCRETE_POWDER, (byte) 0);
                    mat.setVelocity(new Vector(0.82, 1.2, 0));
                    mat.setDropItem(false);
                }
            }
        }, 20, 2);*/

        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
            @Override
            public void run() {
            World world = Bukkit.getServer().getWorld("world");
            int i = 0;

            for (Entity e : world.getEntities()){
                NamespacedKey namespacedKey = new NamespacedKey(instance, "level");
                PersistentDataContainer levels = e.getPersistentDataContainer();
                if (levels.has(namespacedKey, PersistentDataType.STRING)) {
                    if (levels.get(namespacedKey, PersistentDataType.STRING).contains("1")) {
                        i++;

                    }
                }
            }
            if (i <= 100){
                NamespacedKey namespacedKey = new NamespacedKey(instance, "level");
                for (i = 0; i < 25; i++) {
                    int xmax = 229;
                    int xmin = 97;
                    int zmax = 130;
                    int zmin = -50;
                    int xrandom = (int) Math.floor(Math.random() * (xmax - xmin + 1) + xmin);
                    int zrandom = (int) Math.floor(Math.random() * (zmax - zmin + 1) + zmin);

                    while (xrandom > 108 && xrandom < 196 && zrandom > 1 && zrandom < 92){
                        xrandom = (int) Math.floor(Math.random() * (xmax - xmin + 1) + xmin);
                        zrandom = (int)Math.floor(Math.random()*(zmax-zmin+1)+zmin);
                    }

                    final double[] count = {7};
                    int finalXrandom1 = xrandom;
                    int finalZrandom1 = zrandom;
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
                        @Override
                        public void run() {
                            if (world.getHighestBlockAt(finalXrandom1, finalZrandom1).getBlockData().getMaterial().equals(Material.WATER) || world.getHighestBlockAt(finalXrandom1, finalZrandom1).getBlockData().getMaterial().equals(Material.AZALEA_LEAVES) || world.getHighestBlockAt(finalXrandom1, finalZrandom1).getY() >= 115){
                            } else {
                                count[0] = count[0] - 0.5;
                                Location entityloc = new Location(world, finalXrandom1, world.getHighestBlockAt(finalXrandom1, finalZrandom1).getY() + count[0], finalZrandom1);
                                world.spawnParticle(Particle.SMOKE_LARGE, entityloc, 10, 0, 0, 0, 0.1);
                            }
                        }
                    }, 5, 2);


                    Bukkit.getScheduler().runTaskLater(instance, new Runnable() {
                        @Override
                        public void run() {
                            int i = 0;
                            int xrandom = (int) Math.floor(Math.random() * (xmax - xmin + 1) + xmin);
                            int zrandom = (int) Math.floor(Math.random() * (zmax - zmin + 1) + zmin);
                            int locy = world.getHighestBlockAt(finalXrandom1, finalZrandom1).getY() + 1;
                            Location loc = new Location(world, finalXrandom1, locy, finalZrandom1);
                            if (world.getHighestBlockAt(finalXrandom1, finalZrandom1).getBlockData().getMaterial().equals(Material.WATER) || world.getHighestBlockAt(finalXrandom1, finalZrandom1).getBlockData().getMaterial().equals(Material.AZALEA_LEAVES) || world.getHighestBlockAt(finalXrandom1, finalZrandom1).getY() >= 115) {
//                    while (locy >= 120 || spawnloc.getBlock().getBlockData().getMaterial().equals(Material.AIR)){
//                        xrandom = (int)Math.floor(Math.random()*(xmax-xmin+1)+xmin);
//                        zrandom = (int)Math.floor(Math.random()*(zmax-zmin+1)+zmin);
//                        spawnloc = new Location(world, finalXrandom1, block, finalZrandom1);
//                        loc = new Location(world, xrandom, locy, zrandom);
//                        locy = world.getHighestBlockAt(xrandom, zrandom).getY() + 1;
//                    }
                            }else{
                                Zombie mob = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
                                PersistentDataContainer levels = mob.getPersistentDataContainer();
                                levels.set(namespacedKey, PersistentDataType.STRING, "1");
                                AttributeInstance health = mob.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                                health.setBaseValue(40.0D);
                                mob.setRemoveWhenFarAway(false);
                                mob.setHealth(40.0D);
                                AttributeInstance strength = mob.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
                                mob.setCustomNameVisible(true);
                                strength.setBaseValue(10.0D);
                                int healthrounded = (int) Math.round(mob.getHealth());
                                int maxhealthrounded = (int) Math.round(mob.getMaxHealth());
                                mob.setCustomName("" + ChatColor.RED + ChatColor.BOLD + healthrounded + "/" + maxhealthrounded);
                                mob.setPersistent(true);
                                mob.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                                mob.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
                                world.spawnParticle(Particle.DRAGON_BREATH, mob.getLocation(), 50, 0, 0, 0, 0.05);
                            }
                        }
                    }, 27);
                }
            }

        }
    }, 100, 100);
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
        PacketEvents.getAPI().terminate();
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



