package me.totalfreedom.smp.api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import me.totalfreedom.smp.SMPBase;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.luckperms.api.node.Node;
import org.bukkit.entity.Player;

public class Permissions extends SMPBase
{
    public boolean isPlayerInGroup(Player player, String group)
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
}
