package net.simonxz.prison;

import net.simonxz.prison.files.ConfigManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Prison extends JavaPlugin implements Listener {

    public static ConfigManager cfgm;

    @Override
    public void onEnable() {

        loadConfigManager();
        getConfig().options().copyDefaults();
    }

    @Override
    public void onDisable() {
    }

    public void loadConfigManager() {
        cfgm = new ConfigManager();
        cfgm.setupPlayers();
    }

}
