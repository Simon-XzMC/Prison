package com.simonxz.prison;

import com.simonxz.prison.manager.RankManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class RankListener implements Listener {

    public Prison prison;

    public RankListener(Prison prison) {
        this.prison = prison;
    }

    @EventHandler
//    public void onJoin(PlayerJoinEvent e) {
//
 //       Player player = e.getPlayer();
//
//        if (!player.hasPlayedBefore()) {
//
//            Player p = e.getPlayer();
//            addPlayerConfig(p);
//            prison.getRankManager().setRank(player.getUniqueId(), Rank.GUEST);
//
 //       }
 //   }

    public void createConfig(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        addPlayerConfig(p);
    }

    public void addPlayerConfig(Player p) {



        if (!Prison.cfgm.getPlayers().contains("Players." + p.getUniqueId().toString() + ".Name")) {
            Prison.cfgm.getPlayers().set("Players." + p.getUniqueId().toString() + ".Name", p.getName());
            Prison.cfgm.savePlayers();
        }
        if (!Prison.cfgm.getPlayers().contains("Players." + p.getUniqueId().toString() + ".Rank")) {
            Prison.cfgm.getPlayers().set("Players." + p.getUniqueId().toString() + ".Rank", new String(String.valueOf(Rank.GUEST)));
            Prison.cfgm.savePlayers();
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);

        Player player = e.getPlayer();
        Bukkit.broadcastMessage(prison.getRankManager().getRank(player.getUniqueId()).getDisplay() + " " + player.getName() + ": " + ChatColor.GRAY + e.getMessage());
    }
}
