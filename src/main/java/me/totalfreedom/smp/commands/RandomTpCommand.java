package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomTpCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
            return true;
        }

        Player player = (Player)sender;
        Util.randomTeleport(player);
        return true;
    }
}
