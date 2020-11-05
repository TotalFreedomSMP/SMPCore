package me.totalfreedom.smp.listeners;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.SMPCore;
import me.totalfreedom.smp.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListener extends SMPBase implements Listener
{
    public ServerListener(SMPCore plugin)
    {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onServerPing(final ServerListPingEvent event)
    {
        String baseMotd = plugin.config.getString("server.motd");
        baseMotd = baseMotd.replace("\\n", "\n");
        baseMotd = Util.colorize(baseMotd);
        final StringBuilder motd = new StringBuilder();
        for (final String word : baseMotd.split(" "))
        {
            motd.append(Util.randomChatColor()).append(word).append(" ");
        }
        event.setMotd(motd.toString().trim());
    }
}