package me.totalfreedom.smp.api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import me.totalfreedom.smp.SMPBase;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Permissions extends SMPBase
{
    public boolean inGroup(Player player, String group)
    {
        return player.hasPermission("group." + group);
    }

    public void setGroup(UUID uuid, String group)
    {
        UserManager userManager = api.getUserManager();
        CompletableFuture<User> userFuture = userManager.loadUser(uuid);

        userFuture.thenAcceptAsync(user ->
        {
            user.setPrimaryGroup(group);
            userManager.saveUser(user);
        });
    }

    public String getGroup(Player player)
    {
        UUID uuid = player.getUniqueId();
        UserManager userManager = api.getUserManager();
        return userManager.getUser(uuid).getPrimaryGroup();
    }

    public String getDisplay(String name)
    {
        Player player = Bukkit.getPlayer(name);
        return getDisplay(player);
    }

    public String getDisplay(Player player)
    {
        if (!(player instanceof Player))
        {
            return ChatColor.DARK_PURPLE + "Console";
        }
        else if (isModerator(player))
        {
            return ChatColor.LIGHT_PURPLE + "Moderator";
        }
        else if (isAdmin(player))
        {
            return ChatColor.RED + "Admin";
        }
        else if (isDeveloper(player))
        {
            return ChatColor.DARK_PURPLE + "Developer";
        }
        else if (isBuilder(player))
        {
            return ChatColor.DARK_AQUA + "Builder";
        }
        else if (isManager(player))
        {
            return ChatColor.YELLOW + "Manager";
        }
        else if (isOwner(player))
        {
            return ChatColor.DARK_RED + "Owner";
        }

        return ChatColor.GREEN + "Player";
    }

    public boolean isPlayer(Player player)
    {
        return inGroup(player, "default");
    }

    public boolean isModerator(Player player)
    {
        return getGroup(player).equals("mod");
    }

    public boolean isAdmin(Player player)
    {
        return getGroup(player).equals("admin");
    }

    public boolean isDeveloper(Player player)
    {
        return getGroup(player).equals("developer");
    }

    public boolean isManager(Player player)
    {
        return getGroup(player).equals("manager");
    }

    public boolean isBuilder(Player player)
    {
        return getGroup(player).equals("builder");
    }

    public boolean isOwner(Player player)
    {
        return getGroup(player).equals("owner");
    }
}
