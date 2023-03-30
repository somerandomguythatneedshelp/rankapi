package com.moonworkshop.ranks;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.print.Doc;

public final class VexctyRanks extends JavaPlugin {


    @Getter
    private RankManager rankManager;
    @Getter
    private NametagManager nametagManager;

    @Override
    public void onEnable() {

      this.rankManager = new RankManager(this);
      this.nametagManager = new NametagManager(this);
      getCommand("rank").setExecutor(new RankCommand(this));
      getCommand("grant").setExecutor(new GrantCommand());
      getCommand("comingsoonserver").setExecutor(new ServerCommingSoonCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerEvent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
