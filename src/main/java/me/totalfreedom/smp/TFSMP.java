package me.totalfreedom.smp;

import me.totalfreedom.smp.api.Permissions;
import me.totalfreedom.smp.commands.AdminChatCommand;
import me.totalfreedom.smp.commands.BeginCommand;
import me.totalfreedom.smp.commands.ClearWeatherCommand;
import me.totalfreedom.smp.commands.CrateCommand;
import me.totalfreedom.smp.commands.FionnCommand;
import me.totalfreedom.smp.commands.PowerBoostCommand;
import me.totalfreedom.smp.commands.RandomTpCommand;
import me.totalfreedom.smp.commands.SMPCommand;
import me.totalfreedom.smp.commands.SatisfyallCommand;
import me.totalfreedom.smp.commands.SayCommand;
import me.totalfreedom.smp.commands.ShopCommand;
import me.totalfreedom.smp.commands.WorldSpawnCommand;
import me.totalfreedom.smp.config.MainConfig;
import me.totalfreedom.smp.listeners.ChatListener;
import me.totalfreedom.smp.listeners.LoginProcess;
import me.totalfreedom.smp.listeners.ServerListener;
import me.totalfreedom.smp.listeners.TabListener;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class TFSMP extends JavaPlugin
{
    public static TFSMP plugin;
    public static Server server;
    public ChatListener cl;
    public LoginProcess lp;
    public ServerListener sl;
    public TabListener tl;
    public Permissions perms;
    public MainConfig config;

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

    @Override
    public void onLoad()
    {
        config = new MainConfig(this);
    }

    @Override
    public void onEnable()
    {
        plugin = this;
        server = getServer();
        config.load();
        perms = new Permissions();
        loadListeners();
        loadCommands();
    }

    @Override
    public void onDisable()
    {
        config.save();
    }

    public void loadCommands()
    {
        getCommand("satisfyall").setExecutor(new SatisfyallCommand());
        getCommand("clearweather").setExecutor(new ClearWeatherCommand());
        getCommand("adminchat").setExecutor(new AdminChatCommand());
        getCommand("begin").setExecutor(new BeginCommand());
        getCommand("powerboost").setExecutor(new PowerBoostCommand());
        getCommand("fionn").setExecutor(new FionnCommand());
        getCommand("worldspawn").setExecutor(new WorldSpawnCommand());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("crate").setExecutor(new CrateCommand());
        getCommand("randomtp").setExecutor(new RandomTpCommand());
        getCommand("say").setExecutor(new SayCommand());
        getCommand("smp").setExecutor(new SMPCommand());
    }

    public void loadListeners()
    {
        cl = new ChatListener(this);
        lp = new LoginProcess(this);
        sl = new ServerListener(this);
        tl = new TabListener(this);
    }
}