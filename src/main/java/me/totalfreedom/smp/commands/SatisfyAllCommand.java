package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SatisfyAllCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args)
    {
        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.setHealth(20.0);
            player.setFoodLevel(20);
        }
        Util.action(sender.getName(), "fed and healed the entire server!");
        return true;
    }
}