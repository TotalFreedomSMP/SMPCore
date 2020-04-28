package me.totalfreedom.smp.commands;

import io.papermc.lib.PaperLib;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(Messages.PLAYER_ONLY);
            return true;
        }
        World spawn = Bukkit.getWorld("spawn");
        if (spawn == null)
        {
            sender.sendMessage(Messages.MISSING_WORLD);
            return true;
        }
        Player player = (Player)sender;
        player.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "Teleporting to the shop...");
        PaperLib.teleportAsync(player, new Location(spawn, -192, 4, -203));
        return true;
    }
}

