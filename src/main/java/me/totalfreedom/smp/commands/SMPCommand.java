package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SMPCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
    {
        plugin.config.load();
        sender.sendMessage(ChatColor.GRAY + "Configuration file reloaded");
        return true;
    }
}
