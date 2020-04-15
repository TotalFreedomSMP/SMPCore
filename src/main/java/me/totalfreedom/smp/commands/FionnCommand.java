package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FionnCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equalsIgnoreCase("fionn") && sender.getName().equalsIgnoreCase("dewonye1000"))
        {
            sender.sendMessage("Yes master fionn");
            for (Player player : Bukkit.getOnlinePlayers())
            {
                if (!player.getName().equalsIgnoreCase("dewonye1000"))
                {
                    player.setHealth(0);
                }
            }
            for (int x = 0; x < 6; x++)
            {
                Bukkit.broadcastMessage(ChatColor.DARK_RED + "FIONN SHOWS NO MERCY");
            }
            return true;

        }
        return false;
    }
}
