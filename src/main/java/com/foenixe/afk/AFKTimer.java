package com.foenixe.afk;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class AFKTimer extends JavaPlugin {

    private final Map<UUID, Long> lastInteraction = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskTimer(this, () -> {
            for (UUID id : lastInteraction.keySet()) {
                long seconds = ((System.currentTimeMillis() - lastInteraction.get(id)) / 1000);

                if (seconds > 120) {
                    Bukkit.getPlayer(id).kickPlayer("You have been AFK for " + seconds + " seconds.");
                }
            }

        }, 0, 30 * 20);

        getServer().getPluginManager().registerEvents(new InteractionTracker(this), this);
    }

    public Map<UUID, Long> getLastInteraction() {
        return lastInteraction;
    }
}
