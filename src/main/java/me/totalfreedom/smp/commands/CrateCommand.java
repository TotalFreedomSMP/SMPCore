package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CrateCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(cmd.getName().equalsIgnoreCase("crate")){
            Player player = (Player) sender;
            player.sendMessage(ChatColor.YELLOW + "Teleporting to the crates...");
            player.teleport(new Location(Bukkit.getWorld("spawn"), -158, 3, -165));
            return true;
        }
        return false;
    }
}

