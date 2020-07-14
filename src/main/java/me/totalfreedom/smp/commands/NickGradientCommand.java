package me.totalfreedom.smp.commands;

import java.util.List;
import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.utils.Util;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickGradientCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if (!sender.hasPermission("tfsmp.nickgradient"))
        {
            sender.sendMessage(Messages.NO_PERMISSION);
            return true;
        }

        if (args.length != 3)
        {
            return false;
        }


        String nick = args[2].trim();

        if (nick.length() < 3 || nick.length() > 30)
        {
            sender.sendMessage(ChatColor.RED + "Your nickname must be between 3 and 30 characters long.");
            return true;
        }

        for (Player player : Bukkit.getOnlinePlayers())
        {
            if (player == sender)
            {
                continue;
            }
            if (player.getName().equalsIgnoreCase(nick) || ChatColor.stripColor(player.getDisplayName()).trim().equalsIgnoreCase(nick))
            {
                sender.sendMessage(ChatColor.RED + "That nickname is already in use.");
                return true;
            }
        }

        java.awt.Color awt1, awt2;
        try
        {
            awt1 = java.awt.Color.decode(args[0]);
            awt2 = java.awt.Color.decode(args[1]);
        }
        catch (NumberFormatException ex)
        {
            sender.sendMessage(ChatColor.RED + "Invalid hex values. Make sure that you put a '#' before the color codes, and that it is six characters in length.");
            return true;
        }
        Color c1 = Util.fromAWT(awt1);
        Color c2 = Util.fromAWT(awt2);
        List<Color> gradient = Util.createColorGradient(c1, c2, nick.length());
        String[] splitNick = nick.split("");
        for (int i = 0; i < splitNick.length; i++)
        {
            splitNick[i] = net.md_5.bungee.api.ChatColor.of(Util.toAWT(gradient.get(i))) + splitNick[i];
        }
        nick = StringUtils.join(splitNick, "");
        final String outputNick = Util.colorize(nick);

        plugin.esb.setNickname(sender.getName(), outputNick);

        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Your nickname is now: " + outputNick);
        return true;
    }
}