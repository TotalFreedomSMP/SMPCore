package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
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
            sender.sendMessage(Messages.PLAYER_ONLY);
            return true;
        }
        World world = Bukkit.getWorld("world");
        if (world == null)
        {
            sender.sendMessage(Messages.MISSING_WORLD);
            return true;
        }
        Player player = (Player)sender;
        player.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "Teleporting to the world spawn...");
        player.teleport(new Location(world, 0, 63, 0));
        return true;
    }
}

