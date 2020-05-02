package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ClearWeatherCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args)
    {
        World world = Bukkit.getWorld("world");
        if (world == null)
        {
            sender.sendMessage(Messages.MISSING_WORLD);
            return true;
        }
        world.setStorm(false);
        Util.action(sender.getName(), "cleared the weather!");
        return true;
    }
}