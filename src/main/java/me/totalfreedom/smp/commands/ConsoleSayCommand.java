package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConsoleSayCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if (args.length == 0)
        {
            return false;
        }

        String message = StringUtils.join(args, " ");
        Bukkit.broadcastMessage(String.format("§7[CONSOLE] §c%s §8» §f%s", sender.getName(), message));
        return true;
    }
}
