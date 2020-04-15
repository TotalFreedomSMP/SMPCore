package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BeginCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            return false;
        }
        Bukkit.dispatchCommand(sender, "rtp");
        if (!sender.hasPermission("smp.noadd"))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + sender.getName() + " group set Player");
        }
        sender.sendMessage(ChatColor.RED + "You are now ready to play SMP! Good luck!");
        sender.sendMessage(ChatColor.GRAY + "If you are wanting to work with someone, send them a teleport request with '/tpa <user>'!");
        sender.sendMessage(ChatColor.GOLD + "To start a faction, type '/f create <name>'");
        return true;
    }
}
