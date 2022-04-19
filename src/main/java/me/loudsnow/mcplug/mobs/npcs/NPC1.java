package me.loudsnow.mcplug.mobs.npcs;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.io.BukkitObjectInputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static me.loudsnow.mcplug.Main.instance;

public class NPC1 implements Listener {
    @EventHandler
    public void onNpcClick(PlayerInteractEntityEvent event) {
        Player p = (Player) event.getPlayer();
        if (event.getHand() == EquipmentSlot.HAND) {
            Entity entity = event.getRightClicked();
            String uuid = entity.getUniqueId().toString();
            if (uuid.equals("14df8b0e-0bd7-27d4-81c6-e59fb8f0b208")) {
                p.sendMessage("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] Welcome to the Snowy RPG!\n ");
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] I'm Gilbert, your starting guide!\n ");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] As you progress, your items will become increasingly better.\n ");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] You may have noticed when you joined that this world has a terrible plague.\n ");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] The 7th relic, lost to time, has been constantly spawning enemies on this planets surface.\n ");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] There are also 6 more relics, guarded by demons.\n ");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] This world is in need of a hero, and I grant you the opportunity to be one.\n ");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] This will be a long hard journey, I wish you luck.\n ");
                arrayList.add("" + ChatColor.DARK_GREEN + ChatColor.BOLD + "[Gilbert] Let me start you out with this Starter Dagger!\n ");

                final int[] i = {0};
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.playSound(p.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_AMBIENT, 10, 10);
                        if (i[0] == 8) {
                            cancel();
                            ItemStack basicdagger = new ItemStack(Material.IRON_SWORD, 1);
                            ItemMeta meta = basicdagger.getItemMeta();
                            meta.setDisplayName("Basic Dagger");
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(UUID.randomUUID(),  "generic.attackDamage", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
                            meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(UUID.randomUUID(),  "generic.attackSpeed", 2.25, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
                            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
                            meta.isUnbreakable();
                            List<String> lore = new ArrayList<>();
                            lore.add("It's a solid starter weapon!");
                            meta.setLore(lore);
                            basicdagger.setItemMeta(meta);
                            p.getInventory().addItem(basicdagger);
                            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("" + ChatColor.GRAY + ChatColor.BOLD + "You have received Starter Dagger"));
                        }
                        p.sendMessage(arrayList.get(i[0]));
                        i[0]++;
                    }
                }.runTaskTimer(instance, 20L * 2, 20L * 4);
            }
        }
    }
}



