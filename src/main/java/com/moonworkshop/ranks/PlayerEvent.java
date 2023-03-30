package com.moonworkshop.ranks;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class PlayerEvent implements Listener {

    private final Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build();

    VexctyRanks plugin;

    public PlayerEvent(VexctyRanks plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        plugin.getNametagManager().setNametags(player);
        plugin.getNametagManager().newTag(player);


        if (player.getName() == "Notch") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "jeb_") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "Kappische") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "Junkboy") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        }else if (player.getName() == "JahKob") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "danfrisk") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "MinecraftChick") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "BomuBoi") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "xlson") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "jonkagstrom") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "KrisJelbring") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "Midnight") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "KarinSeverinson") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "hideous_") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "EttGlasVatten") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "91maan90") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "E_Claymore") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "EvilSeph") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "Grumm") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "Dinnerbone") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "Tahg") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        } else if (player.getName() == "C418") {
            plugin.getRankManager().setRank(player.getUniqueId(), PlayerRank.MOJANG);
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = (Player) e.getPlayer();
        e.setCancelled(true);

        Bukkit.broadcastMessage(plugin.getRankManager().getRank(player.getUniqueId()).getName() + " " + player.getName() + ": " + ChatColor.WHITE + e.getMessage());


        if (plugin.getRankManager().getRank(player.getUniqueId()) == PlayerRank.MEMBER) {

            if (!cooldown.asMap().containsKey(player.getUniqueId())) {
                cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 3000); // must wait 3 seconds
            } else {
                long distance = cooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
                if (System.currentTimeMillis() > 1000) { // see if the wait time is less than 1 second
                    player.sendMessage(ChatColor.RED + "You must wait " + TimeUnit.MILLISECONDS.toSeconds(distance) + " second to type again. Ranked player can bypass this.");
                } else {
                    player.sendMessage(ChatColor.RED + "You must wait " + TimeUnit.MILLISECONDS.toSeconds(distance) + " seconds to type again. Ranked player can bypass this.");
                }

            }
        } else {
            return;
        }
    }


    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equals("Select Player")) {
            e.setCancelled(true);
            if(e.getCurrentItem() != null) {
                p.closeInventory();
                String name = e.getCurrentItem().getItemMeta().getDisplayName();
                GrantCommand.firstGUI(p);


            }
        } else if (e.getView().getTitle().equals("Select")) {

            e.setCancelled(true);

            if (e.getSlot() == 13) {
                p.closeInventory();
                GrantCommand.secondGUI(p);
            }
        } else if (e.getView().getTitle().equals("Select Rank")) {
            e.setCancelled(true);

            switch (e.getSlot()) {
                case 10:
                    p.closeInventory();
                    p.sendMessage(CC.GREEN + "You gave yourself Legend");
                    p.performCommand("rank " + p.getName() + " legend");
                    break;

                case 12:
                    p.closeInventory();
                    p.sendMessage(CC.GREEN + "You gave yourself Hacker");
                    p.performCommand("rank " + p.getName() + " hacker");
                    break;

                case 14:
                    p.closeInventory();
                    p.sendMessage(CC.GREEN + "You gave yourself Noob");
                    p.performCommand("rank " + p.getName() + " noob");
                    break;

                case 16:
                    p.closeInventory();
                    p.sendMessage(CC.GREEN + "You gave yourself Voter");
                    p.performCommand("rank " + p.getName() + " voter");
                    break;
                case 19:
                    GrantCommand.otherRanks(p);
                    break;

                case 26:
                    p.closeInventory();
                    GrantCommand.adminGUI(p);
                    break;
            }
        } else if (e.getView().getTitle().equals("Admin Ranks")) {
            e.setCancelled(true);

            switch (e.getSlot()) {
                case 9:
                    p.closeInventory();
                    p.sendMessage(CC.GREEN + "You gave yourself Owner");
                    p.performCommand("rank " + p.getName() + " owner");
                    break;

                case 11:
                    p.closeInventory();
                    p.sendMessage(CC.GREEN + "You gave yourself Manager");
                    p.performCommand("rank " + p.getName() + " manager");
                    break;

                case 13:
                    p.closeInventory();
                    p.sendMessage(CC.GREEN + "You gave yourself Administrator");
                    p.performCommand("rank " + p.getName() + " admin");
                    break;

                case 15:
                    p.closeInventory();
                    p.sendMessage(CC.GREEN + "You gave yourself Moderator");
                    p.performCommand("rank " + p.getName() + " mod");
                    break;

                case 17:
                    p.closeInventory();
                    p.sendMessage(CC.GREEN + "You gave yourself Developer");
                    p.performCommand("rank " + p.getName() + " dev");
                    break;
            }
        } else if (e.getInventory().getTitle().equals("Select Other Ranks")) {
            e.setCancelled(true);
            switch (e.getSlot()) {
                case 11:
                    p.closeInventory();
                    p.performCommand("rank " + p.getName() + " yt");
                    break;
                case 12:
                    p.closeInventory();
                    p.performCommand("rank " + p.getName() + " twitch");
                    break;
                case 13:
                    p.closeInventory();
                    p.performCommand("rank " + p.getName() + " mojang");
            }
        }
    }

}
