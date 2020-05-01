package me.totalfreedom.smp.commands;

import io.papermc.lib.PaperLib;
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

public class ShopCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {

        FileConfiguration cfg = TFSMP.getPlugin(TFSMP.class).getConfig();

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

        int x = cfg.getInt("server.coords.shop.x");
        int y = cfg.getInt("server.coords.shop.y");
        int z = cfg.getInt("server.coords.shop.z");

        Player player = (Player)sender;
        player.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "Teleporting to the shop...");
        PaperLib.teleportAsync(player, new Location(spawn, x, y, z));
        return true;
    }
}