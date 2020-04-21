package me.totalfreedom.smp;

import me.totalfreedom.smp.api.Permissions;
import me.totalfreedom.smp.commands.*;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class TFSMP extends JavaPlugin
{
    public LoginProcess lp;
    public Permissions perms;

    public static TFSMP plugin;
    public static Server server;

    @Override
    public void onLoad()
    {
    }

    @Override
    public void onEnable()
    {
        plugin = this;
        server = getServer();
        loadCommands();
        lp = new LoginProcess(this);
        perms = new Permissions();
    }

    @Override
    public void onDisable()
    {
    }

    public static LuckPerms getLuckPermsAPI()
    {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null)
        {
            server.getLogger().info("Successfully loaded the LuckPerms API.");
            return provider.getProvider();
        }
        return null;
    }

    public void loadCommands()
    {
        getCommand("chatall").setExecutor(new ChatallCommand());
        getCommand("strikeall").setExecutor(new StrikeAllCommand());
        getCommand("importantmessage").setExecutor(new ImportantMessageCommand());
        getCommand("satisfyall").setExecutor(new SatisfyallCommand());
        getCommand("clearweather").setExecutor(new ClearWeatherCommand());
        getCommand("opchat").setExecutor(new OpChatCommand());
        getCommand("owo").setExecutor(new OwoCommand());
        getCommand("uhoh").setExecutor(new UhOhCommand());
        getCommand("begin").setExecutor(new BeginCommand());
        getCommand("powerboost").setExecutor(new PowerBoostCommand());
        getCommand("fionn").setExecutor(new FionnCommand());
        getCommand("worldspawn").setExecutor(new WorldSpawnCommand());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("crate").setExecutor(new CrateCommand());
        getCommand("randomtp").setExecutor(new RandomTpCommand());
    }
}