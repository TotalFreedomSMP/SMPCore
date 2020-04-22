package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BeginCommand extends SMPBase implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "Only players may execute this command.");
            return true;
        }
        Player player = (Player)sender;
        sender.sendMessage(ChatColor.RED + "You are now ready to play SMP! Good luck!");
        sender.sendMessage(ChatColor.GRAY + "If you are wanting to work with someone, send them a teleport request with '/tpa <user>'!");
        sender.sendMessage(ChatColor.GOLD + "To start a faction, type '/f create <name>'");
        sender.sendMessage(ChatColor.GREEN + "You will now be randomly teleported, please wait...");
        Util.randomTeleport(player);
        return true;
    }
}
