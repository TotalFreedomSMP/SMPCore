package me.totalfreedom.smp.commands;

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

public class SpawnCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {

        FileConfiguration cfg = TFSMP.getPlugin(TFSMP.class).getConfig();

        World spawn = Bukkit.getWorld("spawn");

        if (spawn == null)
        {
            sender.sendMessage(Messages.MISSING_WORLD);
            return true;
        }

        int x = cfg.getInt("server.coords.spawn.x");
        int y = cfg.getInt("server.coords.spawn.y");
        int z = cfg.getInt("server.coords.spawn.z");

        if (args.length == 0)
        {

            if (!(sender instanceof Player))
            {
                sender.sendMessage(Messages.PLAYER_ONLY);
                return true;
            }

            Player player = (Player) sender;
            player.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "Teleporting to the spawn...");
            player.teleport(new Location(spawn, x, y, z));
            return true;
        }

        if (sender.hasPermission("tfsmp.spawn_players"))
        {
            Player player = Bukkit.getPlayer(args[0]);

            if (player == null)
            {
                sender.sendMessage(Messages.PLAYER_NOT_FOUND);
                return true;
            }

            sender.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "Sent " + player.getName() + " to spawn successfully.");
            player.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + sender.getName() + " has teleported you to the spawn");
            player.teleport(new Location(spawn, x, y, z));
        }
        return true;
    }
}