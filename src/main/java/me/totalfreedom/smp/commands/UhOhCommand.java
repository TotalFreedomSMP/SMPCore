// 
// Decompiled by Procyon v0.5.36
// 

package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UhOhCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            return false;
        }
        for (final Player player : Bukkit.getOnlinePlayers())
        {
            player.sendMessage(ChatColor.YELLOW + "Uh oh! Stinky!");
            for (int i = 0; i < 10; ++i)
            {
                player.playSound(player.getLocation(), Sound.ENTITY_BEE_DEATH, 1.0f, 0.0f);
            }
        }
        return true;
    }
}
