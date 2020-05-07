package me.totalfreedom.smp.commands;

import java.util.List;
import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RulesCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        List<String> adminInfo = plugin.config.getStringList("server.rules");
        if (adminInfo.isEmpty())
        {
            sender.sendMessage(ChatColor.RED + "There is no text set in the configuration file.");
        }
        else
        {
            sender.sendMessage(Util.colorize(StringUtils.join(adminInfo, "\n")));
        }
        return true;
    }
}