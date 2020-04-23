package me.totalfreedom.smp.commands;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PowerBoostCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        MPlayer mplayer;
        Faction faction;
        mplayer = MPlayer.get(sender.getName());
        faction = mplayer.getFaction();
        if (faction == null)
        {
            sender.sendMessage(ChatColor.RED + "You are not in a faction!");
            return true;
        }
        faction.setPowerBoost((double)2147483647);
        mplayer.setPower((double)2147483647);
        sender.sendMessage(ChatColor.GOLD + "Powerboosted you and your faction.");
        return true;
    }
}