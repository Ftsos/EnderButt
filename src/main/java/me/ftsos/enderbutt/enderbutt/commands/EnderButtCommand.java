package me.ftsos.enderbutt.enderbutt.commands;

import me.ftsos.enderbutt.enderbutt.Enderbutt;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnderButtCommand implements CommandExecutor {
    private Enderbutt plugin;

    public EnderButtCommand(Enderbutt plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou Can't Use This Command from the Console"));
            return false;
        }

        Player player = (Player) sender;
        if(!player.hasPermission("enderbutt.command")) {
            if(plugin.getConfig().contains("nopermissions")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("nopermissions")));
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have permission"));

            }
            return false;
        }
        ItemStack enderPearl = new ItemStack(Material.ENDER_PEARL, 64);
        ItemMeta itemMeta = enderPearl.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aEnder Butt"));
        enderPearl.setItemMeta(itemMeta);
        player.getInventory().addItem(enderPearl);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8Given Ender Butt"));

        return true;
    }
}
