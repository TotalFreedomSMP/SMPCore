package me.totalfreedom.smp.commands;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;
import com.massivecraft.factions.FactionsAPI;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.SMPCore;
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
            SMPCore.BuildProperties build = SMPCore.build;
            sender.sendMessage(ChatColor.GOLD + "SMPCore is the custom plugin developed for the TotalFreedom SMP server.");
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
            if (server.getPluginManager().isPluginEnabled("SMPItems"))
            {
                sender.sendMessage(ChatColor.GREEN + "Integration with SMPItems is enabled.");
            }
            return true;
        }
        switch (args[0].toLowerCase())
        {
            case "reload":
            {
                if (!sender.hasPermission("tfsmp.reload"))
                {
                    sender.sendMessage(Messages.NO_PERMISSION);
                    return true;
                }
                try
                {
                    plugin.config.load();
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
            case "resetpowerboost":
            {
                if (!sender.hasPermission("tfsmp.resetpowerboost"))
                {
                    sender.sendMessage(Messages.NO_PERMISSION);
                    return true;
                }

                List<Faction> factions = Factions.getInstance().getAllFactions();
                Collection<FPlayer> players = FPlayers.getInstance().getAllFPlayers();

                for (Faction faction : factions)
                {
                    faction.setPowerBoost(0);
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "Set powerboost to 0 for faction " + faction);
                }

                for (FPlayer fPlayer : players)
                {
                    fPlayer.setPowerBoost(0);
                    fPlayer.setIsAdminBypassing(false);
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "Set powerboost to 0 for player " + fPlayer.getName());
                }
                return true;
            }
            default:
                return false;
        }
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args)
    {
        return Arrays.asList("reload", "resetpowerboost");
    }
}