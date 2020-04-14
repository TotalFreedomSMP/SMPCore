// 
// Decompiled by Procyon v0.5.36
// 

package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearWeatherCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args)
    {
        if (!(sender instanceof Player))
        {
            return false;
        }
        final Player player = (Player)sender;
        Bukkit.getWorld("world").setStorm(false);
        sender.sendMessage(ChatColor.RED + "Ok, there is no longer a storm!");
        return true;
    }
}
