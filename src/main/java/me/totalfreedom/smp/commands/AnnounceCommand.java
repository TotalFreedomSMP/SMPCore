package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AnnounceCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!sender.hasPermission("tfsmp.announce"))
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
        String prefix = plugin.config.getString("server.announcer.prefix");
        Bukkit.broadcastMessage(Util.colorize(prefix + message));
        return true;
    }
}
