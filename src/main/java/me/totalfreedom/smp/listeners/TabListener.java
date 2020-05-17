package me.totalfreedom.smp.listeners;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.TFSMP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TabListener extends SMPBase implements Listener
{
    public TabListener(TFSMP plugin)
    {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        player.setPlayerListName(plugin.perms.getRankColor(player) + player.getName());
    }
}
