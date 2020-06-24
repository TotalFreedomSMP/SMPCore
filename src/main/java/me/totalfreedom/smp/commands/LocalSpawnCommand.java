package me.totalfreedom.smp.commands;

import io.papermc.lib.PaperLib;
import java.awt.print.Paper;
import me.totalfreedom.smp.SMPBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LocalSpawnCommand extends SMPBase implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(Messages.PLAYER_ONLY);
            return true;
        }

        Player player = (Player)sender;
        World world = player.getWorld();

        player.sendMessage(ChatColor.LIGHT_PURPLE + "Teleporting to the world's spawnpoint");
        PaperLib.teleportAsync(player, world.getSpawnLocation());
        return true;
    }
}