package me.totalfreedom.smp.commands;

import java.util.ArrayList;
import java.util.List;
import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class KillCommand extends SMPBase implements CommandExecutor, TabCompleter
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if (args.length == 0)
        {
            if (!(sender instanceof Player))
            {
                sender.sendMessage(Messages.PLAYER_ONLY);
                return true;
            }

            Player player = (Player)sender;
            player.setHealth(0.0);
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You died!");
            return true;
        }

        if (sender.hasPermission("tfsmp.kill"))
        {
            Player player = Bukkit.getPlayer(args[0]);

            if (player == null)
            {
                sender.sendMessage(Messages.PLAYER_NOT_FOUND);
                return true;
            }

            player.setHealth(0.0);
            sender.sendMessage(ChatColor.LIGHT_PURPLE + "Killed " + ChatColor.GOLD + player.getName());
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You were killed by " + ChatColor.GOLD + sender.getName());
        }
        else
        {
            sender.sendMessage(Messages.NO_PERMISSION);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args)
    {
        if (args.length > 0 && sender.hasPermission("tfsmp.kill"))
        {
            return Util.getPlayerList();
        }
        return null;
    }
}