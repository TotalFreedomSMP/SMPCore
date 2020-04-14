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

public class SatisfyallCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args)
    {
        if (!(sender instanceof Player))
        {
            return false;
        }
        for (final Player player : Bukkit.getOnlinePlayers())
        {
            player.setHealth(20.0);
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.AQUA + "Everyone on the server has been healed and fed fully. ");
        }
        return true;
    }
}
