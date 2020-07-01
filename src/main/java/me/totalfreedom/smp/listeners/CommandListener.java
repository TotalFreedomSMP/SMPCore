package me.totalfreedom.smp.listeners;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.SMPCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener extends SMPBase implements Listener
{
    public CommandListener(SMPCore plugin)
    {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public boolean PlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event)
    {
        String command = event.getMessage();
        final String[] commandParts = command.split(" ");
        if (commandParts[0].contains(":"))
        {
            event.getPlayer().sendMessage(ChatColor.RED + "Plugin specific commands are disabled.");
            event.setCancelled(true);
            return true;
        }
        return true;
    }

}
