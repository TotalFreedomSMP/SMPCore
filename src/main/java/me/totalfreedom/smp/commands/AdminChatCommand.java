package me.totalfreedom.smp.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChatCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        String message = StringUtils.join(args, " ");
        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (player.isOp() || player.hasPermission("tfsmp.adminchat"))
            {
                player.sendMessage(ChatColor.WHITE + "[" + ChatColor.AQUA + "STAFF" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + sender.getName() + ChatColor.WHITE + ": " + ChatColor.GOLD + message);
            }
        }
        return true;
    }
}
