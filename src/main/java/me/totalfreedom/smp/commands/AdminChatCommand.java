package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AdminChatCommand extends SMPBase implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!sender.hasPermission("tfsmp.adminchat"))
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
        Util.adminChat(sender, message);
        return true;
    }
}
