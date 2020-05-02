package me.totalfreedom.smp.utils;

import io.papermc.lib.PaperLib;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import me.totalfreedom.smp.SMPBase;
import me.totalfreedom.smp.TFSMP;
import me.totalfreedom.smp.commands.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
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
        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "TF-SMP // " + ChatColor.GOLD + player + ChatColor.LIGHT_PURPLE + " " + message);
    }

    public static void action(CommandSender sender, String message)
    {
        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "TF-SMP // " + ChatColor.GOLD + sender.getName() + ChatColor.LIGHT_PURPLE + " " + message);
    }

    public static void action(Player player, String message)
    {
        Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "TF-SMP // " + ChatColor.GOLD + player.getName() + ChatColor.LIGHT_PURPLE + " " + message);
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
        String rank = TFSMP.plugin.perms.getDisplay(player);
        String format = ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "# " + ChatColor.BLUE + sender.getName() + ChatColor.DARK_GRAY + " [" + rank
                + ChatColor.DARK_GRAY + "] \u00BB " + ChatColor.GOLD + message;
        Bukkit.getLogger().info(format);
        Bukkit.getOnlinePlayers()
                .stream()
                .filter((players) -> (players.hasPermission("tfsmp.adminchat")))
                .forEachOrdered((players) -> players.sendMessage(format));
    }

    public static void randomTeleport(Player player)
    {
        int cooldownTime = 20;

        if (cooldown.containsKey(player.getName()))
        {
            long secondsLeft = getSecondsLeft(cooldown.get(player.getName()), cooldownTime);
            if (secondsLeft > 0L)
            {
                player.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "You have to wait "
                + ChatColor.GOLD + secondsLeft + " seconds before teleporting again.");
                return;
            }
        }

        cooldown.put(player.getName(), System.currentTimeMillis());

        Random rand = new Random();
        World world = Bukkit.getWorld("world");
        if (world == null)
        {
            player.sendMessage(Messages.MISSING_WORLD);
            return;
        }
        player.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "You will now be randomly teleported, please wait...");
        Location oldLoc = player.getLocation();
        Location newLoc = oldLoc.clone();
        Block topBlock = world.getHighestBlockAt(newLoc);
        int maxDist = 696969 / 2;
        int minDist = 4200 / 2;
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
                || newLoc.equals(oldLoc)) && count < 3)
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
        player.sendMessage(Messages.PREFIX + ChatColor.LIGHT_PURPLE + "You have been randomly teleported!");
    }
}