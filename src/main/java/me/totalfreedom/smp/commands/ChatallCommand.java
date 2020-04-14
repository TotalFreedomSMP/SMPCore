// 
// Decompiled by Procyon v0.5.36
// 

package me.totalfreedom.smp.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatallCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            return false;
        }
        final String message = StringUtils.join(args, " ");
        for (final Player player : Bukkit.getOnlinePlayers())
        {
            player.chat(message);
        }
        return true;
    }
}
