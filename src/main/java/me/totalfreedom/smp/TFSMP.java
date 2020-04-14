package me.totalfreedom.smp;

import me.totalfreedom.smp.commands.BeginCommand;
import me.totalfreedom.smp.commands.ChatallCommand;
import me.totalfreedom.smp.commands.ClearWeatherCommand;
import me.totalfreedom.smp.commands.ImportantMessageCommand;
import me.totalfreedom.smp.commands.OpChatCommand;
import me.totalfreedom.smp.commands.OwoCommand;
import me.totalfreedom.smp.commands.PowerBoostCommand;
import me.totalfreedom.smp.commands.SatisfyallCommand;
import me.totalfreedom.smp.commands.StrikeAllCommand;
import me.totalfreedom.smp.commands.UhOhCommand;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class TFSMP extends JavaPlugin
{
    public LoginProcess lp;

    @Override
    public void onLoad()
    {
    }

    @Override
    public void onEnable()
    {
        loadCommands();
        lp = new LoginProcess(this);
        final PluginDescriptionFile pdfFile = this.getDescription();
        this.getLogger().info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
    }

    @Override
    public void onDisable()
    {
    }

    public void loadCommands()
    {
        this.getCommand("chatall").setExecutor(new ChatallCommand());
        this.getCommand("strikeall").setExecutor(new StrikeAllCommand());
        this.getCommand("importantmessage").setExecutor(new ImportantMessageCommand());
        this.getCommand("satisfyall").setExecutor(new SatisfyallCommand());
        this.getCommand("clearweather").setExecutor(new ClearWeatherCommand());
        this.getCommand("opchat").setExecutor(new OpChatCommand());
        this.getCommand("owo").setExecutor(new OwoCommand());
        this.getCommand("uhoh").setExecutor(new UhOhCommand());
        this.getCommand("begin").setExecutor(new BeginCommand());
        this.getCommand("powerboost").setExecutor(new PowerBoostCommand());
    }
}