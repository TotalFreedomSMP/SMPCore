package me.totalfreedom.smp.api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import me.totalfreedom.smp.SMPBase;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
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

    public boolean isPlayer(Player player)
    {
        return inGroup(player, "player");
    }

    public boolean isModerator(Player player)
    {
        return inGroup(player, "mod");
    }

    public boolean isAdmin(Player player)
    {
        return inGroup(player, "admin");
    }

    public boolean isDeveloper(Player player)
    {
        return inGroup(player, "developer");
    }

    public boolean isManager(Player player)
    {
        return inGroup(player, "manager");
    }

    public boolean isBuilder(Player player)
    {
        return inGroup(player, "builder");
    }

    public boolean isOwner(Player player)
    {
        return inGroup(player, "owner");
    }
}
