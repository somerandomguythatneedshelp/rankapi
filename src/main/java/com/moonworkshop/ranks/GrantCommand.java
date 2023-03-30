package com.moonworkshop.ranks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GrantCommand implements CommandExecutor {

    private final List<UUID> players = new ArrayList<>();
    private Player viewer;

    private static VexctyRanks vexcty;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("f2erg.vexcty.admin")) {

                playerGUI(player);
            } else {
                player.sendMessage(CC.RED + "You do not have permission to use this command.");
            }
        }

        return false;
    }

    public static ItemStack getHead(Player player) {
        int lifePlayer = (int) player.getHealth();
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skull = (SkullMeta) item.getItemMeta();
        skull.setDisplayName(player.getName());
        ArrayList<String> lore = new ArrayList<String>();
        skull.setOwner(player.getName());
        item.setItemMeta(skull);
        return item;
    }

    public static void otherRanks(Player player) {
        Inventory inv = Bukkit.getServer().createInventory(player, 27, "Select Other Ranks");

        ItemStack yt = new ItemStack(Material.COAL_BLOCK);
        ItemMeta ytmeta = yt.getItemMeta();
        ytmeta.setDisplayName(CC.RED + "YOUTUBE");
        yt.setItemMeta(ytmeta);
        inv.setItem(11, yt);

        ItemStack tw = new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA);
        ItemMeta twmeta = tw.getItemMeta();
        twmeta.setDisplayName(CC.L_PURPLE + "TWITCH");
        tw.setItemMeta(twmeta);
        inv.setItem(12, tw);

        ItemStack mj = new ItemStack(Material.BLACK_GLAZED_TERRACOTTA);
        ItemMeta mjmeta = mj.getItemMeta();
        mjmeta.setDisplayName(CC.GOLD + "MOJANG");
        mj.setItemMeta(mjmeta);
        inv.setItem(13, mj);


        player.openInventory(inv);

    }

    public void playerGUI(Player player) {
        Inventory inv = Bukkit.getServer().createInventory(null, 54,"Select Player");

        for (Player player1 : Bukkit.getOnlinePlayers()) {

            inv.addItem(getHead(player1));
        }
        player.openInventory(inv);
    }

    public static void firstGUI(Player p) {
        Inventory gui = Bukkit.getServer().createInventory(p, 27, "Select");

        ItemStack ref1 = new ItemStack(Material.REDSTONE_BLOCK);


        ItemMeta metaref1 = ref1.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();


        metaref1.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        ref1.setItemMeta(metaref1);


        lore.add(CC.GRAY + "Grants the player the chosen rank");

        metaref1.setLore(lore);
        metaref1.setDisplayName(CC.RED + "Rank");


        ref1.setItemMeta(metaref1);
        gui.setItem(13, ref1);

        p.openInventory(gui);

    }

    public static void secondGUI(Player p) {
        Inventory gui = Bukkit.getServer().createInventory(p, 27, "Select Rank");
        ItemStack ref1 = new ItemStack(Material.GRASS); // legend
        ItemStack ref2 = new ItemStack(Material.BARRIER); // hacker
        ItemStack ref3 = new ItemStack(Material.GOLD_BLOCK); // noob
        ItemStack ref4 = new ItemStack(Material.IRON_SWORD); // voter
        ItemStack ref5 = new ItemStack(Material.REDSTONE_BLOCK); // admin ranks
        ItemStack ref6 = new ItemStack(Material.COAL_BLOCK);

        ItemMeta metaref1 = ref1.getItemMeta();


        metaref1.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        ref1.setItemMeta(metaref1);

        metaref1.setDisplayName(CC.BLACK + "Legend");


        ref1.setItemMeta(metaref1);
        gui.setItem(10, ref1);

        ItemMeta metaf2 = ref2.getItemMeta();

        ref2.setItemMeta(metaf2);

        metaf2.setDisplayName(CC.RED + "Hacker");

        ref2.setItemMeta(metaf2);
        gui.setItem(12, ref2);

        ItemMeta metaf3 = ref3.getItemMeta();

        ref3.setItemMeta(metaf3);

        metaf3.setDisplayName(CC.RED + "Noob");

        ref3.setItemMeta(metaf3);
        gui.setItem(14, ref3);

        ItemMeta metaf4 = ref4.getItemMeta();

        ref4.setItemMeta(metaf4);

        metaf4.setDisplayName(CC.RED + "Voter");

        ref4.setItemMeta(metaf4);
        gui.setItem(16, ref4);

        ItemMeta metaf5 = ref5.getItemMeta();

        ref5.setItemMeta(metaf5);

        metaf5.setDisplayName(CC.RED + "Admin Ranks");

        ref5.setItemMeta(metaf5);
        gui.setItem(26, ref5);

        ItemMeta metaf6 = ref6.getItemMeta();

        ref6.setItemMeta(metaf6);

        metaf6.setDisplayName(CC.RED + "Other Ranks");

        ref6.setItemMeta(metaf6);
        gui.setItem(19, ref6);

        p.openInventory(gui);
    }

    public static void adminGUI(Player p) {
        Inventory gui = Bukkit.getServer().createInventory(null, 27, "Admin Ranks");

        ItemStack ref1 = new ItemStack(Material.REDSTONE_BLOCK);
        ItemStack ref2 = new ItemStack(Material.REDSTONE_BLOCK);
        ItemStack ref3 = new ItemStack(Material.REDSTONE_BLOCK);
        ItemStack ref4 = new ItemStack(Material.REDSTONE_BLOCK);
        ItemStack ref5 = new ItemStack(Material.REDSTONE_BLOCK);

        ItemMeta metaref1 = ref1.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();


        metaref1.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        ref1.setItemMeta(metaref1);


        lore.add(CC.GRAY + "Grants the player the chosen rank");

        metaref1.setLore(lore);
        metaref1.setDisplayName(CC.RED + "Owner");
        ref1.setItemMeta(metaref1);
        gui.setItem(9, ref1);

        ItemMeta metaf2 = ref2.getItemMeta();
        ref2.setItemMeta(metaf2);
        metaf2.setDisplayName(CC.RED + "Manager");
        ref2.setItemMeta(metaf2);
        gui.setItem(11, ref2);

        ItemMeta metaf3 = ref3.getItemMeta();
        ref3.setItemMeta(metaf3);
        metaf3.setDisplayName(CC.RED + "Admin");
        ref3.setItemMeta(metaf3);
        gui.setItem(13, ref3);

        ItemMeta metaf4 = ref4.getItemMeta();
        ref4.setItemMeta(metaf4);
        metaf4.setDisplayName(CC.RED + "Moderator");
        ref4.setItemMeta(metaf4);
        gui.setItem(15, ref4);

        ItemMeta metaf5 = ref5.getItemMeta();
        ref5.setItemMeta(metaf5);
        metaf5.setDisplayName(CC.RED + "Developer");
        ref5.setItemMeta(metaf5);
        gui.setItem(17, ref5);



        p.openInventory(gui);
    }
}

