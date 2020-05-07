package me.totalfreedom.smp;

import java.io.InputStream;
import java.util.Properties;
import me.totalfreedom.smp.api.Permissions;
import me.totalfreedom.smp.commands.AdminChatCommand;
import me.totalfreedom.smp.commands.BeginCommand;
import me.totalfreedom.smp.commands.ClearWeatherCommand;
import me.totalfreedom.smp.commands.ConsoleSayCommand;
import me.totalfreedom.smp.commands.CrateCommand;
import me.totalfreedom.smp.commands.FionnCommand;
import me.totalfreedom.smp.commands.KillCommand;
import me.totalfreedom.smp.commands.OwoCommand;
import me.totalfreedom.smp.commands.RandomTpCommand;
import me.totalfreedom.smp.commands.RawSayCommand;
import me.totalfreedom.smp.commands.RulesCommand;
import me.totalfreedom.smp.commands.SMPCommand;
import me.totalfreedom.smp.commands.SatisfyAllCommand;
import me.totalfreedom.smp.commands.SayCommand;
import me.totalfreedom.smp.commands.ShopCommand;
import me.totalfreedom.smp.commands.UhOhCommand;
import me.totalfreedom.smp.commands.WorldSpawnCommand;
import me.totalfreedom.smp.config.MainConfig;
import me.totalfreedom.smp.listeners.ChatListener;
import me.totalfreedom.smp.listeners.LoginListener;
import me.totalfreedom.smp.listeners.ServerListener;
import me.totalfreedom.smp.listeners.TabListener;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class TFSMP extends JavaPlugin
{
    public static final BuildProperties build = new BuildProperties();
    public static TFSMP plugin;
    public static String pluginVersion;
    public static Server server;
    public ChatListener cl;
    public LoginListener loli; // lynx likes this
    public ServerListener sl;
    public TabListener tl;
    public Permissions perms;
    public MainConfig config;

    @Override
    public void onLoad()
    {
        plugin = this;
        server = getServer();
        config = new MainConfig(this);
        pluginVersion = plugin.getDescription().getVersion();
        build.load(this);
    }

    @Override
    public void onEnable()
    {
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

    public static LuckPerms getLuckPermsAPI()
    {
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null)
        {
            server.getLogger().info("Successfully loaded the LuckPerms API.");
            return provider.getProvider();
        }
        server.getLogger().severe("The LuckPerms API was not loaded successfully. The plugin will not function properly.");
        return null;
    }

    public void loadCommands()
    {
        // try and keep this and the plugin.yml in alphabetical order it helps so much thx
        getCommand("adminchat").setExecutor(new AdminChatCommand());
        getCommand("begin").setExecutor(new BeginCommand());
        getCommand("clearweather").setExecutor(new ClearWeatherCommand());
        getCommand("consolesay").setExecutor(new ConsoleSayCommand());
        getCommand("crate").setExecutor(new CrateCommand());
        getCommand("fionn").setExecutor(new FionnCommand());
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("owo").setExecutor(new OwoCommand());
        getCommand("randomtp").setExecutor(new RandomTpCommand());
        getCommand("rawsay").setExecutor(new RawSayCommand());
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("satisfyall").setExecutor(new SatisfyAllCommand());
        getCommand("say").setExecutor(new SayCommand());
        getCommand("shop").setExecutor(new ShopCommand());
        getCommand("smp").setExecutor(new SMPCommand());
        getCommand("worldspawn").setExecutor(new WorldSpawnCommand());
        getCommand("uhoh").setExecutor(new UhOhCommand());
    }

    public void loadListeners()
    {
        cl = new ChatListener(this);
        loli = new LoginListener(this);
        sl = new ServerListener(this);
        tl = new TabListener(this);
    }

    public static class BuildProperties
    {
        public String author;
        public String version;
        public String number;
        public String date;
        public String head;

        public void load(TFSMP plugin)
        {
            try
            {
                final Properties props;

                try (InputStream in = plugin.getResource("build.properties"))
                {
                    props = new Properties();
                    props.load(in);
                }

                author = props.getProperty("buildAuthor", "unknown");
                version = props.getProperty("buildVersion", pluginVersion);
                number = props.getProperty("buildNumber", "1");
                date = props.getProperty("buildDate", "unknown");
                // Need to do this or it will display ${git.commit.id.abbrev}
                head = props.getProperty("buildHead", "unknown").replace("${git.commit.id.abbrev}", "unknown");
            }
            catch (Exception ex)
            {
                server.getLogger().severe("Could not load build properties! Did you compile with IntelliJ / Maven?");
                ex.printStackTrace();
            }
        }
    }
}