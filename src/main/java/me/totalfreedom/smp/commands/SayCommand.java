package me.totalfreedom.smp.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SayCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
    {
        if  (!sender.hasPermission("tfsmp.say"))
        {
            sender.sendMessage(Messages.NO_PERMISSION);
            return true;
        }

        if (args.length == 0)
        {
            sender.sendMessage(Messages.MISSING_ARGS);
            return true;
        }

        String message = StringUtils.join(args, " ");
        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + String.format("[Server:%s] %s", sender.getName(), message));
        return true;
    }
}
