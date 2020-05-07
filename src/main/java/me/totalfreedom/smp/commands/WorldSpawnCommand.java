package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldSpawnCommand extends SMPBase implements CommandExecutor
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

        double x = plugin.config.getDouble("server.coords.worldspawn.x");
        double y = plugin.config.getDouble("server.coords.worldspawn.y");
        double z = plugin.config.getDouble("server.coords.worldspawn.z");

        Player player = (Player)sender;
        player.sendMessage(ChatColor.LIGHT_PURPLE + "Teleporting to the world spawn...");
        player.teleport(new Location(world, x, y, z));
        return true;
    }
}