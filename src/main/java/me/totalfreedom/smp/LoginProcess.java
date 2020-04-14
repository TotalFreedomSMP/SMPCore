// 
// Decompiled by Procyon v0.5.36
// 

package me.totalfreedom.smp;

import me.totalfreedom.smp.utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class LoginProcess implements Listener
{
    private TFSMP plugin;

    public LoginProcess(TFSMP plugin) {
        this.plugin = plugin;
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onServerPing(final ServerListPingEvent event)
    {
        String baseMotd = "Total Freedom SMP - The Earth Is Flat\nMC 1.15.2";
        baseMotd = baseMotd.replace("\\n", "\n");
        baseMotd = Util.colorize(baseMotd);
        final StringBuilder motd = new StringBuilder();
        for (final String word : baseMotd.split(" "))
        {
            motd.append(Util.randomChatColor()).append(word).append(" ");
        }
        event.setMotd(motd.toString().trim());
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event)
    {
        final Player player = event.getPlayer();
        player.sendTitle(ChatColor.RED + "Welcome to" + ChatColor.GREEN + " TotalFreedom" + ChatColor.RED + " SMP", ChatColor.WHITE + "To get started, type /begin!", 20, 100, 60);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerChatFormat(final AsyncPlayerChatEvent event)
    {
        try
        {
            this.handleChatEvent(event);
        }
        catch (Exception ex)
        {
        }
    }

    private void handleChatEvent(final AsyncPlayerChatEvent event)
    {
        final Player player = event.getPlayer();
        final String message = event.getMessage().trim();
        event.setMessage(message);
        final boolean mentionEveryone = ChatColor.stripColor(message).toLowerCase().contains("@everyone") && player.isOp();
        for (final Player p : Bukkit.getOnlinePlayers())
        {
            if (ChatColor.stripColor(message).toLowerCase().contains("@" + p.getName().toLowerCase()) || mentionEveryone)
            {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, SoundCategory.MASTER, 1337.0f, 0.9f);
            }
        }
    }
}
