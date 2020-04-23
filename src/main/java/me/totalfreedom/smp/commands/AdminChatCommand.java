package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
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
        String message = StringUtils.join(args, " ");

        for (Player p : Bukkit.getOnlinePlayers())
        {
            if (p.isOp() || p.hasPermission("tfsmp.adminchat"))
            {
                String format = ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "# " + ChatColor.BLUE + sender.getName() + ChatColor.DARK_GRAY + " [" + plugin.perms.getDisplay(sender.getName())
                        + ChatColor.DARK_GRAY + "] \u00BB " + ChatColor.GOLD + message;
                p.sendMessage(format);
                server.getLogger().info(format);
            }
        }
        return true;
    }
}
