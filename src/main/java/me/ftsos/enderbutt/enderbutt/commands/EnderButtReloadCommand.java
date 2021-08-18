package me.ftsos.enderbutt.enderbutt.commands;

import me.ftsos.enderbutt.enderbutt.Enderbutt;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EnderButtReloadCommand implements CommandExecutor {
    private Enderbutt plugin;

    public EnderButtReloadCommand(Enderbutt plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("enderbutt.reload")){
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aReloaded"));
            return true;
        } else {

                if(plugin.getConfig().contains("nopermissions")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("nopermissions")));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have permission"));

                }
                return false;

        }
    }
}
