package me.ftsos.enderbutt.enderbutt;

import me.ftsos.enderbutt.enderbutt.commands.EnderButtCommand;
import me.ftsos.enderbutt.enderbutt.listeners.EnderPearlClick;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Enderbutt extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerEvents();
        registerCommands();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents(){
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new EnderPearlClick(this), this);
    }
    public void registerCommands(){
        this.getCommand("enderbutt").setExecutor(new EnderButtCommand(this));
    }


}
