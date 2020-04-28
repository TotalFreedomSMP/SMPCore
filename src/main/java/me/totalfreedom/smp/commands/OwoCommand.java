package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OwoCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        for (Player player : Bukkit.getOnlinePlayers())
        {
            for (int i = 0; i < 100; ++i)
            {
                player.playSound(player.getLocation(), Sound.ENTITY_SALMON_FLOP, 1.0f, 0.0f);
            }
        }
        return true;
    }
}