package me.ftsos.enderbutt.enderbutt.listeners;

import me.ftsos.enderbutt.enderbutt.Enderbutt;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class EnderPearlClick implements Listener {
    private Enderbutt plugin;

    public EnderPearlClick(Enderbutt plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPearlClick(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getItem() == null) return;
            if(event.getItem().getType() == Material.AIR) return;
            ItemStack item = event.getItem();
            if(!item.hasItemMeta()) return;
            if(!item.getItemMeta().hasDisplayName()) return;
            if(!ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("Ender Butt")) return;

            event.setCancelled(true);
            Player player = event.getPlayer();
            //La Magia
            Location playerLocation = player.getLocation();
            Vector toLocation = playerLocation.getDirection();

            FileConfiguration config = plugin.getConfig();
            if(config.contains("multiplier")) {
            player.setVelocity(toLocation.multiply(config.getInt("multiplier")));
            } else {
                player.setVelocity(toLocation.multiply(2));

            }
            //Fin de la Magia
            Sound sound = Sound.ENDERMAN_TELEPORT;
            int pitch = 50;
            int volume = 100;
            boolean shouldSound = true;
            if(config.contains("sound")){
                sound = Sound.valueOf(config.getString("sound").toUpperCase());
            }

            if(config.contains("pitchSound")){
                pitch = config.getInt("pitchSound");
            }

            if(config.contains("volumeSound")){
                volume = config.getInt("volumeSound");
            }

            if(config.contains("shouldSound")){
                shouldSound = config.getBoolean("shouldSound");
            }

            if(shouldSound) {
                player.playSound(player.getLocation(), sound, volume, pitch);
            }
        }
    }
}
