package me.totalfreedom.smp;

import java.util.logging.Logger;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.Server;

public class SMPBase
{
    protected static LuckPerms api = SMPCore.getLuckPermsAPI();
    protected SMPCore plugin = SMPCore.plugin;
    protected Server server = SMPCore.server;
    protected Logger logger = Bukkit.getLogger();
}