package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class VoteCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
    {
        List<String> voting = plugin.config.getStringList("voting");

        if (voting.isEmpty())
        {
            sender.sendMessage(ChatColor.RED + "The links section in the config.yml file has not been configured.");
        }
        else
        {
            sender.sendMessage(Util.colorize(StringUtils.join(voting, "\n")));
        }
        return true;
    }
}