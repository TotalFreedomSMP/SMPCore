package me.totalfreedom.smp.commands;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import static org.bukkit.Bukkit.getPlayer;

public class BanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        String reason = null;

        if (args.length > 1)
        {
            reason = StringUtils.join(ArrayUtils.subarray(args, 1, args.length - 1), " ");
        }

        Player player = getPlayer(args[0]);

        if (player == null)
        {
            sender.sendMessage(ChatColor.RED + "User was not Found");
            return true;
        }

        if (sender.getName().equalsIgnoreCase("fiogga")) {
            sender.sendMessage("ok");
            player.setDisplayName("idiot54");
            player.chat("Idiot 54");
            player.closeInventory();
            player.getInventory().clear();
            player.setFireTicks(10000);
            player.getWorld().createExplosion(player.getLocation(), 0F, false);
            player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));
            Bukkit.broadcastMessage(ChatColor.RED + "Yuh get in to it" + ChatColor.DARK_RED + "\n" + sender.getName() + " - Banishing " + player.getName());
            Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), ChatColor.RED + reason == null ? "Fuck you" : reason, null, null);
            Bukkit.getBanList(BanList.Type.IP).addBan(player.getName(), ChatColor.RED + reason == null ? "Fuck you" : reason, null, null);
            player.kickPlayer("Banished");
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
        }
        return true;
    }
}