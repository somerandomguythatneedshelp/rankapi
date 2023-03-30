package com.moonworkshop.ranks;

import lombok.Getter;

public enum PlayerRank {

    OWNER(CC.DARK_RED + "[OWNER]", 14, true),
    MANAGER(CC.YELLOW + "[MANAGER]", 13, true),
    ADMIN(CC.RED + "[ADMIN]", 12, true),
    MOD(CC.DARK_GREEN + "[MODERATOR]", 11, true),
    DEV(CC.BLACK + "[DEVELOPER]", 10, true),
    YOUTUBE(CC.RED + "[YOUTUBE]", 9,false),
    TWITCH(CC.L_PURPLE + "[TWITCH]", 8, false),
    MOJANG(CC.GOLD + "[MOJANG]", 7, false),
    LEGEND(CC.BLACK + "[LEGEND]", 6, false),
    HACKER(CC.DARK_RED + "[HACKER]", 5, false),
    NOOB(CC.YELLOW + "[NOOB]", 4, false),
    DONOR(CC.AQUA + "[DONOR]", 3, false),
    VOTER("⚔︎", 2, false),
    MEMBER(CC.GRAY + "", 1, false);


    @Getter
    private String name;
    @Getter
    private int level;
    @Getter
    public boolean isStaffRank;

    @Getter
    public static boolean isStaffRankk;

    PlayerRank(String name, int level, boolean isStaffRank) {
        this.name = name;
        this.level = level;
        this.isStaffRank = isStaffRank;
    }

}

