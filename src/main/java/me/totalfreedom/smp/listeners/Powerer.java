package me.totalfreedom.smp.listeners;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import me.totalfreedom.smp.SMPCore;
import me.totalfreedom.smp.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;

public class Powerer
{
    private BukkitTask task;

    public Powerer()
    {
        this.task = new BukkitRunnable()
        {
            public void run()
            {
                List<Faction> factions = Factions.getInstance().getAllFactions();
                for (Faction faction : factions)
                {
                    faction.setPowerBoost(faction.getPowerBoost() + 5.0);
                }
                Bukkit.broadcastMessage(Util.colorize("&dSMP » &6All factions have received their 30 minute power bump of 5!"));
            }
        }.runTaskTimer(SMPCore.plugin, 0, 36000);
    }
}