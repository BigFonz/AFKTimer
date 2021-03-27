package com.foenixe.afk;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class InteractionTracker implements Listener {
    private AFKTimer plugin;

    public InteractionTracker(AFKTimer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void move(PlayerMoveEvent e) {
        plugin.getLastInteraction().put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
    }

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        plugin.getLastInteraction().put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
    }

    @EventHandler
    public void quit(PlayerQuitEvent e) {
        plugin.getLastInteraction().remove(e.getPlayer().getUniqueId());
    }

    @EventHandler
    public void join(PlayerJoinEvent e) {
        plugin.getLastInteraction().put(e.getPlayer().getUniqueId(), System.currentTimeMillis());
    }

}
