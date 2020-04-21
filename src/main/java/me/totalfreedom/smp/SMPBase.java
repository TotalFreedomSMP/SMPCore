package me.totalfreedom.smp;

import java.util.logging.Logger;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.Server;

public class SMPBase
{
    protected TFSMP plugin = TFSMP.plugin;
    protected Server server = TFSMP.server;
    protected Logger logger = Bukkit.getLogger();
    protected static LuckPerms api = TFSMP.getLuckPermsAPI();
}
