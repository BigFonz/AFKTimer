package com.foenixe.afk;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class AFKChecker implements Runnable {
    private final AFKTimer plugin;

    public AFKChecker(AFKTimer plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (UUID id : plugin.getLastInteraction().keySet()) {
            Player player = Bukkit.getPlayer(id);
            long seconds = ((System.currentTimeMillis() - plugin.getLastInteraction().get(id)) / 1000);

            if (seconds > 120) {
                player.kickPlayer("You have been AFK for " + seconds + " seconds.");
                return;
            }
        }
    }

}
