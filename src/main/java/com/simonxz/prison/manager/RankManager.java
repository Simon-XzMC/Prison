package com.simonxz.prison.manager;

import com.simonxz.prison.Prison;
import com.simonxz.prison.Rank;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.conversations.PlayerNamePrompt;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.profile.PlayerProfile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class RankManager {

    private File file;
    private YamlConfiguration config;

    public FileConfiguration playerscfg;

    Plugin plugin = Prison.getPlugin(Prison.class);

    public RankManager(Prison prison) {

        if (!prison.getDataFolder().exists()) {
            prison.getDataFolder().mkdir();
        }

  //      file = new File(prison.getDataFolder(), "ranks.yml");
  //      if (!file.exists()) {
  //          try {
   //             file.createNewFile();
   //         } catch (IOException e) {
   //             e.printStackTrace();
   //         }
   //     }
    //    config = YamlConfiguration.loadConfiguration(file);

    }


    public FileConfiguration getPlayers() {
        return this.playerscfg;
    }


    public void setRank(UUID uuid, Rank rank) {
        Prison.cfgm.getPlayers().set("Players." + uuid.toString() + ".Rank", rank.name());
        Prison.cfgm.savePlayers();
        //config.set("", rank.name());
        //config.set(uuid.toString(), rank.name());
    }

    public Rank getRank(UUID uuid) {
        return Rank.valueOf(Prison.cfgm.getPlayers().getString("Players." + uuid.toString() + ".Rank"));


        //return Rank.valueOf(config.getString(uuid.toString()));
    }

}
