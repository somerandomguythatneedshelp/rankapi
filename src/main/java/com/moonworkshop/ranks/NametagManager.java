package com.moonworkshop.ranks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class NametagManager {

    private VexctyRanks vexcty;

    Player player = null;

    public NametagManager(VexctyRanks vexcty) { this.vexcty = vexcty; }

    public void setNametags(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        for (PlayerRank rank : PlayerRank.values()) {
            Team team = player.getScoreboard().registerNewTeam(rank.name());
            if (rank == PlayerRank.MEMBER) {
                team.setPrefix(ChatColor.GRAY + "");
            } else {
                team.setPrefix(rank.getName().toString() + " ");
            }
        }
        for (Player tar : Bukkit.getOnlinePlayers()) {

            if (player.getUniqueId() != tar.getUniqueId()) {
                player.getScoreboard().getTeam(vexcty.getRankManager().getRank(tar.getUniqueId()).name()).addEntry(tar.getName());
            }
        }
    }

    public void newTag(Player player) {
        PlayerRank rank = vexcty.getRankManager().getRank(player.getUniqueId());
        for (Player tar : Bukkit.getOnlinePlayers()) {
            tar.getScoreboard().getTeam(rank.name()).addEntry(player.getName());
        }
    }

}
