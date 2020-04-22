package me.totalfreedom.smp.commands;

import java.util.Collections;
import java.util.List;
import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.TFSMP;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class SMPCommand extends SMPBase implements CommandExecutor, TabCompleter
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args)
    {
        if (args.length == 0)
        {
            TFSMP.BuildProperties build = TFSMP.build;
            sender.sendMessage(ChatColor.GOLD + "TF-SMP is the custom plugin developed for the TotalFreedom SMP server.");
            sender.sendMessage(ChatColor.GOLD + String.format("Version "
                            + ChatColor.BLUE + "%s.%s.%s",
                    build.version,
                    build.number,
                    build.head));
            sender.sendMessage(String.format(ChatColor.GOLD + "Compiled on "
                            + ChatColor.BLUE + "%s" + ChatColor.GOLD + " by "
                            + ChatColor.BLUE + "%s",
                    build.date,
                    build.author));
            sender.sendMessage(ChatColor.GREEN + "Visit " + ChatColor.AQUA + "https://github.com/Telesphoreo/LoginMessages" + ChatColor.GREEN + " for more information");
            return true;
        }
        if (args[0].toLowerCase().equals("reload"))
        {
            if (!sender.hasPermission("tfsmp.reload"))
            {
                sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command.");
                return true;
            }
            try
            {
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GRAY + "The configuration file has been reloaded.");
                return true;
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                sender.sendMessage(ChatColor.RED + "There was an error reloading the configuration file. Check the console for more details.");
            }
            return true;
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender.hasPermission("tfsmp.reload"))
        {
            return Collections.singletonList("reload");
        }
        else
        {
            return null;
        }
    }
}
