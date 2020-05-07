package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand extends SMPBase implements CommandExecutor
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

            Player player = (Player) sender;
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
            player.sendMessage(ChatColor.LIGHT_PURPLE + "You died!");
        }
        else
        {
            sender.sendMessage(Messages.NO_PERMISSION);
        }
        return true;
    }
}