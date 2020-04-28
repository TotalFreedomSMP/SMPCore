package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChatCommand extends SMPBase implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0)
        {
            sender.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "Please provide a message.");
            return true;
        }
        String message = StringUtils.join(args, " ");
        Util.adminChat(sender, message);
        return true;
    }
}
