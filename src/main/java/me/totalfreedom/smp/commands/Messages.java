package me.totalfreedom.smp.commands;

import org.bukkit.ChatColor;

/*
    Consistency rules:
    The default color is light purple. The player / action is in gold. The prefix should usually go
    before the message if it's a one liner.
    Example:
    &dTF-SMP // &6Telesphoreo &dis a simp.
    Error messages are in red (&c).
    If anything needs to be prefixed, use &8.
    Messages for "fun" commands don't necessarily need to be consistent. Having inconsistent
    messages for informal commands gives off more of a chill vibe, which is what is intended.
    Generally messages that go here are ones that are repeated. No need to put every single
    message for every command in this file.
    Note that it's impossible to have everything 100% consistent for various reasons,
    so do what you feel is right.
 */

public class Messages
{
    public static String PREFIX = ChatColor.LIGHT_PURPLE + "TF-SMP // ";
    public static String NO_PERMISSION = PREFIX + ChatColor.RED + "You do not have permission to execute this command.";
    public static String PLAYER_ONLY = PREFIX + ChatColor.RED + "This command may only be executed by players.";
    public static String CONSOLE_ONLY = PREFIX + ChatColor.RED + "This command may only be executed by the console.";
    public static String MISSING_WORLD = PREFIX + ChatColor.RED + "The requested world could not be found! Please contact a staff member ASAP.";
    public static String PLAYER_NOT_FOUND = PREFIX + ChatColor.RED + "Player not found.";
    public static String MISSING_ARGS = PREFIX + ChatColor.RED + "Please provide a message.";
}
