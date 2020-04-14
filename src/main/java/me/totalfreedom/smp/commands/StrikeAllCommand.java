// 
// Decompiled by Procyon v0.5.36
// 

package me.totalfreedom.smp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class StrikeAllCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] split)
    {
        if (!(sender instanceof Player))
        {
            return false;
        }
        for (final Player player : Bukkit.getOnlinePlayers())
        {
            final Location targetPos = player.getLocation();
            final World world = player.getWorld();
            for (int x = -1; x <= 1; ++x)
            {
                for (int z = -1; z <= 1; ++z)
                {
                    final Location strike_pos = new Location(world, (double)(targetPos.getBlockX() + x), (double)targetPos.getBlockY(), (double)(targetPos.getBlockZ() + z));
                    world.strikeLightningEffect(strike_pos);
                }
                player.setHealth(20.0);
                final double strength = 2.0;
                player.setVelocity(new Vector(0.0, strength, 0.0));
                player.setHealth(20.0);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect give @a minecraft:resistance 5 100");
            }
        }
        return true;
    }
}
