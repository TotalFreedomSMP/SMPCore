package me.totalfreedom.smp.config;

import java.io.File;
import me.totalfreedom.smp.SMPCore;
import org.bukkit.configuration.file.YamlConfiguration;

public class MainConfig extends YamlConfiguration
{
    private SMPCore plugin;
    private MainConfig config;
    private File file;

    public MainConfig(SMPCore plugin)
    {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "config.yml");

        if (!file.exists())
        {
            saveDefault();
        }
    }

    public void load()
    {
        try
        {
            super.load(file);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void save()
    {
        try
        {
            super.save(file);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void saveDefault()
    {
        plugin.saveResource("config.yml", false);
    }
}
