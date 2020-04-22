package me.totalfreedom.smp.listeners;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.TFSMP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
        if (plugin.perms.isModerator(player))
        {
            player.setPlayerListName(ChatColor.LIGHT_PURPLE + player.getName());
            return;
        }
        if (plugin.perms.isAdmin(player))
        {
            player.setPlayerListName(ChatColor.RED + player.getName());
            return;
        }

        if (plugin.perms.isDeveloper(player))
        {
            player.setPlayerListName(ChatColor.DARK_PURPLE + player.getName());
            return;
        }

        if (plugin.perms.isManager(player))
        {
            player.setPlayerListName(ChatColor.YELLOW + player.getName());
            return;
        }

        if (plugin.perms.isBuilder(player))
        {
            player.setPlayerListName(ChatColor.DARK_AQUA + player.getName());
            return;
        }

        if (plugin.perms.isOwner(player))
        {
            player.setPlayerListName(ChatColor.DARK_RED + player.getName());
            return;
        }
    }
}
