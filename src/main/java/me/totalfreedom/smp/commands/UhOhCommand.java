package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UhOhCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args)
    {
        if  (!sender.hasPermission("tfsmp.uhoh"))
        {
            sender.sendMessage(Messages.NO_PERMISSION);
            return true;
        }

        for (Player player : Bukkit.getOnlinePlayers())
        {
            for (int i = 0; i < 10; ++i)
            {
                player.playSound(player.getLocation(), Sound.ENTITY_BEE_DEATH, 1.0f, 0.0f);
            }
        }
        // This is a "fun" message and doesn't need to be consistent.
        Bukkit.broadcastMessage(ChatColor.YELLOW + "Uh oh! Stinky!");
        return true;
    }
}
