package me.totalfreedom.smp.listeners;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.SMPCore;
import me.totalfreedom.smp.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class Announcer extends SMPBase implements Listener
{
    public Announcer(SMPCore plugin)
    {
        this.plugin = plugin;
        announce();
    }

    List<String> announcements = plugin.config.getStringList("server.announcer.announcements");

    long interval = plugin.config.getInt("server.announcer.interval") * 20L;

    boolean enabled = plugin.config.getBoolean("server.announcer.enabled");

    String prefix = Util.colorize(plugin.config.getString("server.announcer.prefix"));

    public void announce()
    {
        if (!enabled)
        {
            return;
        }

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                String announcement = announcements.get(new Random().nextInt(announcements.size()));
                Bukkit.broadcastMessage(Util.colorize(prefix + announcement));
            }
        }.runTaskTimer(plugin, interval, interval);
    }
}