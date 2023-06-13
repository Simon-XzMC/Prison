package com.simonxz.prison;

import com.simonxz.prison.manager.ConfigManager;
import com.simonxz.prison.manager.NametagManager;
import com.simonxz.prison.manager.RankManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Prison extends JavaPlugin {

    public static ConfigManager cfgm;

    @Override
    public void onEnable() {



        loadConfigManager();
        // Plugin startup logic
        getCommand("rank").setExecutor(new RankCommand(this));

        rankManager = new RankManager(this);

        Bukkit.getPluginManager().registerEvents(new RankListener(this), this);
    }

    private RankManager rankManager;
    private NametagManager nametagManager;

    public RankManager getRankManager() { return rankManager; }
    public NametagManager getNametagManager() { return nametagManager; }

    public void loadConfigManager() {
        cfgm = new ConfigManager();
        cfgm.setupPlayers();
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic


    }

}
