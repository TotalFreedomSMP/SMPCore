package me.totalfreedom.smp.listeners;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.SMPCore;
import me.totalfreedom.smp.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginListener extends SMPBase implements Listener
{
    public LoginListener(SMPCore plugin)
    {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore())
        {
            player.sendTitle(ChatColor.RED + "Welcome to " + ChatColor.GREEN + "SMP", ChatColor.WHITE + "To get started, type /begin!", 20, 100, 60);
        }

        String header = plugin.config.getString("server.tablist_header");
        String footer = plugin.config.getString("server.tablist_footer");
        if (!(header == null))
        {
            player.setPlayerListHeader(Util.colorize(header).replace("\\n", "\n"));
        }
        if (!(footer == null))
        {
            player.setPlayerListFooter(Util.colorize(footer).replace("\\n", "\n"));
        }
    }
}