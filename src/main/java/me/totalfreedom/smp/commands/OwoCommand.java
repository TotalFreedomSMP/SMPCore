// 
// Decompiled by Procyon v0.5.36
// 

package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OwoCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            return false;
        }
        for (final Player player : Bukkit.getOnlinePlayers())
        {
            for (int i = 0; i < 10; ++i)
            {
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
            }
        }
        return true;
    }
}
