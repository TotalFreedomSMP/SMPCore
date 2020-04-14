package me.totalfreedom.smp.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.bukkit.ChatColor;

public class Util
{
    public static final Map<String, ChatColor> CHAT_COLOR_NAMES;
    public static final List<ChatColor> CHAT_COLOR_POOL;
    private static final Random RANDOM;
    private static Iterator<ChatColor> CHAT_COLOR_ITERATOR;

    static
    {
        RANDOM = new Random();
        CHAT_COLOR_NAMES = new HashMap<String, ChatColor>();
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

    public static int random(final int min, final int max)
    {
        final int range = max - min + 1;
        final int value = (int)(Math.random() * range) + min;
        return value;
    }
}
