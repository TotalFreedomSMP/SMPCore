package me.totalfreedom.smp.commands;

import javafx.print.PageLayout;
import me.totalfreedom.smp.SMPBase;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConsoleSayCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if  (!sender.hasPermission("tfsmp.consolesay"))
        {
            sender.sendMessage(Messages.NO_PERMISSION);
            return true;
        }

        if (sender instanceof Player)
        {
            sender.sendMessage(Messages.CONSOLE_ONLY);
            return true;
        }

        if (args.length == 0)
        {
            sender.sendMessage(Messages.MISSING_ARGS);
            return true;
        }

        String message = StringUtils.join(args, " ");
        Bukkit.broadcastMessage(String.format("§7[CONSOLE] §c%s §8\u00BB §f%s", sender.getName(), message));
        return true;
    }
}
