package me.totalfreedom.smp.commands;

import java.util.List;
import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LinksCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        List<String> links = plugin.config.getStringList("links");

        if (links.isEmpty())
        {
            sender.sendMessage(ChatColor.RED + "The links section in the config.yml file has not been configured.");
        }
        else
        {
            sender.sendMessage(Util.colorize(StringUtils.join(links, "\n")));
        }
        return true;
    }
}