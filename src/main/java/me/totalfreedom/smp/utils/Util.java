package me.totalfreedom.smp.utils;

import io.papermc.lib.PaperLib;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
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

    public static void randomTeleport(Player player)
    {
        int cooldownTime = 20;

        if (cooldown.containsKey(player.getName()))
        {
            long secondsLeft = getSecondsLeft(cooldown.get(player.getName()), cooldownTime);
            if (secondsLeft > 0L)
            {
                player.sendMessage(ChatColor.RED + "You have to wait " + secondsLeft + " seconds before teleporting again.");
                return;
            }
        }

        cooldown.put(player.getName(), System.currentTimeMillis());

        Random rand = new Random();
        Location oldLoc = player.getLocation();
        Location newLoc = oldLoc.clone();
        Block topBlock = Bukkit.getWorld("world").getHighestBlockAt(newLoc);
        int maxDist = 3000 / 2;
        int minDist = 500 / 2;
        double xAdd;
        double zAdd;
        double x;
        double z;
        int count = 0;
        while ((topBlock.isLiquid()
                // dont have players spawn on these blocks
                || topBlock.getBlockData().getMaterial().equals(Material.LAVA)
                || topBlock.getBlockData().getMaterial().equals(Material.KELP)
                || topBlock.getBlockData().getMaterial().equals(Material.KELP_PLANT)
                || topBlock.getBlockData().getMaterial().equals(Material.SEAGRASS)
                || topBlock.getBlockData().getMaterial().equals(Material.TALL_SEAGRASS)
                || topBlock.getBlockData().getMaterial().equals(Material.GRAVEL)
                || topBlock.getBlockData().getMaterial().equals(Material.STONE)
                || newLoc.equals(oldLoc)) && count < 3)
        {
            count++;
            xAdd = rand.nextDouble() * (maxDist - minDist) + minDist;
            xAdd = (rand.nextDouble() - 0.5D > 0.0D) ? xAdd : -xAdd;
            zAdd = rand.nextDouble() * (maxDist - minDist) + minDist;
            zAdd = (rand.nextDouble() - 0.5D > 0.0D) ? zAdd : -zAdd;
            x = oldLoc.getX() + xAdd;
            z = oldLoc.getZ() + zAdd;
            newLoc = new Location(Bukkit.getWorld("world"), x, Bukkit.getWorld("world").getHighestBlockYAt((int)x, (int)z), z);
            topBlock = newLoc.getBlock();
        }
        newLoc.setY(newLoc.getY() + 2.0D);
        PaperLib.teleportAsync(player, newLoc);
        player.sendMessage(ChatColor.GREEN + "You have been randomly teleported!");
    }
}