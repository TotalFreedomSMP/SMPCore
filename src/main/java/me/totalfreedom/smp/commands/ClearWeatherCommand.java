package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
            sender.sendMessage(ChatColor.DARK_RED + "The server is actually fucked. Contact a staff member ASAP.");
            return true;
        }
        world.setStorm(false);
        sender.sendMessage(ChatColor.RED + "Ok, there is no longer a storm!");
        return true;
    }
}