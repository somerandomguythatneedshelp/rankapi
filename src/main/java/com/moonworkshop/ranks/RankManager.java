package com.moonworkshop.ranks;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class RankManager {

    private VexctyRanks main;

    private File file;
    private YamlConfiguration config;

    public RankManager(VexctyRanks main) {
        this.main = main;

        if (!main.getDataFolder().exists()) {
            main.getDataFolder().mkdir();
        }

        file = new File(main.getDataFolder(), "ranks.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
    }

    public void setRank(UUID uuid, PlayerRank rank) {
        config.set(uuid.toString(), rank.name());
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }



        if (Bukkit.getOfflinePlayer(uuid).isOnline()) {
            Player player = Bukkit.getPlayer(uuid);
            newtag(player);
        }

    }

    public PlayerRank getRank(UUID uuid) {
        return PlayerRank.valueOf(config.getString(uuid.toString()));
    }

    public void newtag(Player player) {
        for (Player tar : Bukkit.getOnlinePlayers()) {
            tar.getScoreboard().getEntryTeam(player.getName()).removeEntry(player.getName());
        }
        main.getNametagManager().newTag(player);
    }

}
