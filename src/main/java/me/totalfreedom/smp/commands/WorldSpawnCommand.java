package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldSpawnCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "Only players may execute this command.");
            return true;
        }
        Player player = (Player)sender;
        player.sendMessage(ChatColor.YELLOW + "Teleporting to the world spawn...");
        player.teleport(new Location(Bukkit.getWorld("world"), 0, 63, 0));
        return true;

    }
}

