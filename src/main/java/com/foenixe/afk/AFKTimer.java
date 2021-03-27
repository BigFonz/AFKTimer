package com.foenixe.afk;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class AFKTimer extends JavaPlugin {
    private final Map<UUID, Long> lastInteraction = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskTimer(this, new AFKChecker(this), 0, 30 * 20);

        getServer().getPluginManager().registerEvents(new InteractionTracker(this), this);
    }

    public Map<UUID, Long> getLastInteraction() {
        return lastInteraction;
    }

}
