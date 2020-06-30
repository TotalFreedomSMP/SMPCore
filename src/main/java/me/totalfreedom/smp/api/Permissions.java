package me.totalfreedom.smp.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import me.totalfreedom.smp.SMPBase;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Permissions extends SMPBase
{
    public String getGroup(Player player)
    {
        UUID uuid = player.getUniqueId();
        UserManager userManager = api.getUserManager();
        return userManager.getUser(uuid).getPrimaryGroup();
    }

    public Group getPlayerGroup(Player player)
    {
        return Group.getByName(getGroup(player).toLowerCase());
    }

    public String getRankName(Player player)
    {
        if (!(player instanceof Player))
        {
            return "Console";
        }
        Group group = getPlayerGroup(player);
        return group.getName();
    }

    public ChatColor getRankColor(Player player)
    {
        if (!(player instanceof Player))
        {
            return ChatColor.DARK_PURPLE;
        }
        Group group = getPlayerGroup(player);
        return group.getChatColor();
    }

    public String getDisplay(Player player)
    {
        return getRankColor(player) + getRankName(player);
    }

    // All credit goes to Steven and Polaris for this
    public enum Group
    {
        DEFAULT("Player", ChatColor.WHITE),
        MOD("Moderator", ChatColor.LIGHT_PURPLE),
        ADMIN("Admin", ChatColor.RED),
        DEVELOPER("Developer", ChatColor.DARK_PURPLE),
        MANAGER("Manager", ChatColor.YELLOW),
        BUILDER("Builder", ChatColor.DARK_AQUA),
        FOUNDER("Founder", ChatColor.RED),
        OWNER("Owner", ChatColor.DARK_RED);

        private static final Map<String, Group> BY_NAME = new HashMap<>();

        static
        {
            for (Group group : Group.values())
            {
                BY_NAME.put(group.toString().toLowerCase(), group);
            }
        }

        private final String name;
        private final ChatColor chatColor;

        Group(String name, ChatColor chatColor)
        {
            this.name = name;
            this.chatColor = chatColor;
        }

        public static Group getByName(String name)
        {
            return BY_NAME.getOrDefault(name, DEFAULT);
        }

        public String getName()
        {
            return this.name;
        }

        public ChatColor getChatColor()
        {
            return this.chatColor;
        }
    }
}
