package me.totalfreedom.smp.utils;

import com.wimbli.WorldBorder.BorderData;
import com.wimbli.WorldBorder.Config;
import io.papermc.lib.PaperLib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.totalfreedom.smp.SMPCore;
import me.totalfreedom.smp.commands.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Util
{
    public static Map<String, ChatColor> CHAT_COLOR_NAMES;
    public static List<ChatColor> CHAT_COLOR_POOL;
    private static Random RANDOM;
    private static HashMap<String, Long> cooldown = new HashMap<>();

    static
    {
        RANDOM = new Random();
        CHAT_COLOR_NAMES = new HashMap<>();
        CHAT_COLOR_POOL = Arrays.asList(ChatColor.DARK_RED, ChatColor.RED, ChatColor.GOLD, ChatColor.YELLOW, ChatColor.GREEN, ChatColor.DARK_GREEN, ChatColor.AQUA, ChatColor.DARK_AQUA, ChatColor.BLUE, ChatColor.DARK_BLUE, ChatColor.DARK_PURPLE, ChatColor.LIGHT_PURPLE);
        for (final ChatColor chatColor : CHAT_COLOR_POOL)
        {
            CHAT_COLOR_NAMES.put(chatColor.name().toLowerCase().replace("_", ""), chatColor);
        }
    }

    public static void action(String player, String message)
    {
        Bukkit.broadcastMessage(ChatColor.GOLD + player + ChatColor.LIGHT_PURPLE + " " + message);
    }

    public static void action(CommandSender sender, String message)
    {
        Bukkit.broadcastMessage(ChatColor.GOLD + sender.getName() + ChatColor.LIGHT_PURPLE + " " + message);
    }

    public static void action(Player player, String message)
    {
        Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + ChatColor.LIGHT_PURPLE + " " + message);
    }

    public static String colorize(final String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static ChatColor randomChatColor()
    {
        return CHAT_COLOR_POOL.get(RANDOM.nextInt(CHAT_COLOR_POOL.size()));
    }

    public static Long getSecondsLeft(long prevTime, int timeAdd)
    {
        return prevTime / 1000L + timeAdd - System.currentTimeMillis() / 1000L;
    }

    public static void adminChat(CommandSender sender, String message)
    {
        Player player = Bukkit.getPlayer(sender.getName());
        String rank = SMPCore.plugin.perms.getDisplay(player);
        String format = ChatColor.DARK_GRAY + "# " + ChatColor.BLUE + sender.getName() + ChatColor.DARK_GRAY + " [" + rank
                + ChatColor.DARK_GRAY + "] \u00BB " + ChatColor.GOLD + message;
        Bukkit.getLogger().info(format);
        Bukkit.getOnlinePlayers()
                .stream()
                .filter((players) -> (players.hasPermission("tfsmp.adminchat")))
                .forEachOrdered((players) -> players.sendMessage(format));
    }

    public static List<String> getPlayerList()
    {
        List<String> names = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers())
        {
            names.add(player.getName());
        }
        return names;
    }

    public static void randomTeleport(Player player)
    {
        int cooldownTime = 20;

        if (cooldown.containsKey(player.getName()))
        {
            long secondsLeft = getSecondsLeft(cooldown.get(player.getName()), cooldownTime);
            if (secondsLeft > 0L)
            {
                player.sendMessage(ChatColor.LIGHT_PURPLE + "You have to wait "
                        + ChatColor.GOLD + secondsLeft + " seconds " + ChatColor.LIGHT_PURPLE + "before teleporting again.");
                return;
            }
        }

        if (!player.isOp())
        {
            cooldown.put(player.getName(), System.currentTimeMillis());
        }

        Random rand = new Random();
        World world = Bukkit.getWorld("world");

        if (world == null)
        {
            player.sendMessage(Messages.MISSING_WORLD);
            return;
        }

        BorderData border = Config.Border(world.toString());

        player.sendMessage(ChatColor.LIGHT_PURPLE + "You will now be randomly teleported, please wait...");
        Location oldLoc = world.getSpawnLocation();
        Location newLoc = oldLoc.clone();
        int y = newLoc.getBlockY();
        Block topBlock = world.getHighestBlockAt(newLoc);
        int maxDist = 20000 / 2;
        int minDist = 1500 / 2;
        double xAdd;
        double zAdd;
        double x;
        double z;
        int count = 0;
        while (border != null && topBlock.isLiquid() && topBlock.getType().isBlock()
                && !border.insideBorder(player.getLocation())
                // dont have players spawn on these blocks
                || topBlock.getType().equals(Material.WATER)
                || topBlock.getType().equals(Material.LAVA)
                || topBlock.getType().equals(Material.KELP)
                || topBlock.getType().equals(Material.KELP_PLANT)
                || topBlock.getType().equals(Material.SEAGRASS)
                || topBlock.getType().equals(Material.TALL_SEAGRASS)
                || topBlock.getType().equals(Material.GRAVEL)
                || topBlock.getType().equals(Material.ICE)
                || topBlock.getType().equals(Material.PACKED_ICE)
                || topBlock.getType().equals(Material.FROSTED_ICE)
                || newLoc.equals(oldLoc) && count < 3)
        {
            count++;
            xAdd = rand.nextDouble() * (maxDist - minDist) + minDist;
            xAdd = (rand.nextDouble() - 0.5D > 0.0D) ? xAdd : -xAdd;
            zAdd = rand.nextDouble() * (maxDist - minDist) + minDist;
            zAdd = (rand.nextDouble() - 0.5D > 0.0D) ? zAdd : -zAdd;
            x = oldLoc.getX() + xAdd;
            z = oldLoc.getZ() + zAdd;
            newLoc = new Location(world, x, world.getHighestBlockYAt((int)x, (int)z), z);
            topBlock = newLoc.getBlock();
        }
        newLoc.setY(newLoc.getY() + 2.0D);
        PaperLib.teleportAsync(player, newLoc);
        player.sendMessage(ChatColor.LIGHT_PURPLE + "You have been randomly teleported!");
    }

    private static Color interpolateColor(Color c1, Color c2, double factor)
    {
        long[] c1values = {c1.getRed(), c1.getGreen(), c1.getBlue()};
        long[] c2values = {c2.getRed(), c2.getGreen(), c2.getBlue()};
        for (int i = 0; i < 3; i++)
        {
            c1values[i] = Math.round(c1values[i] + factor * (c2values[i] - c1values[i]));
        }
        return Color.fromRGB((int) c1values[0], (int) c1values[1], (int) c1values[2]);
    }

    public static List<Color> createColorGradient(Color c1, Color c2, int steps)
    {
        double factor = 1.0 / (steps - 1.0);
        List<Color> colors = new ArrayList<>();
        for (int i = 0; i < steps; i++)
        {
            colors.add(interpolateColor(c1, c2, factor * i));
        }
        return colors;
    }

    public static Color fromAWT(java.awt.Color color)
    {
        return Color.fromRGB(color.getRed(), color.getGreen(), color.getBlue());
    }

    public static java.awt.Color toAWT(Color color)
    {
        return new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
    }
}
