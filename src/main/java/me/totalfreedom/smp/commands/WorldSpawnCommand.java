package me.totalfreedom.smp.commands;

import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.TFSMP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
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

        int x = plugin.config.getInt("server.coords.worldspawn.x");
        int y = plugin.config.getInt("server.coords.worldspawn.y");
        int z = plugin.config.getInt("server.coords.worldspawn.z");

        Player player = (Player)sender;
        player.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "Teleporting to the world spawn...");
        player.teleport(new Location(world, x, y, z));
        return true;
    }
}