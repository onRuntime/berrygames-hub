package net.berrygames.hub.listener;

import net.berrygames.cloudberry.bukkit.BukkitCloud;
import net.berrygames.cloudberry.bukkit.item.ClickableItem;
import net.berrygames.cloudberry.bukkit.item.ItemBuilder;
import net.berrygames.hub.Hub;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        final var player = event.getPlayer();
        final var playerData = BukkitCloud.get().getPlayer(player.getName());

        final var cloud = BukkitCloud.get();

        cloud.getInventoryManager().setItemToPlayer(player, 0, (ClickableItem) new ClickableItem(cloud.getHead("hub.item.games"))
                .onInteract("Ouvrir le menu des Jeux.", p -> p.sendMessage("games"))
                .setDisplayName(playerData.format("hub.inv.item.games")));

        /*inventory.setItem(1, new ClickableItem(event.getPlayer())
                .setDisplayName(playerData.format("hub.inv.item.profile")));
        if(false)
            inventory.setItem(2, new ClickableItem(cloud.getHead("hub.item.pannel"))
                    .setDisplayName(playerData.format("hub.inv.item.pannel")));
        inventory.setItem(4, new ClickableItem(cloud.getHead("hub.item.cosmetics"))
                .setDisplayName(playerData.format("hub.inv.item.cosmetics")));
        inventory.setItem(8, new ClickableItem(cloud.getHead("hub.item.hubs"))
                .setDisplayName(playerData.format("hub.inv.item.hubs")));

        inventory.setItem(12, new ClickableItem(cloud.getHead("hub.item.jump"))
                .onInteract("Se téléporter au jump.", e -> {e.closeInventory(); e.sendMessage(playerData.format("hub.message.wip"));})
                .setDisplayName(playerData.format("hub.inv.item.jump")));
        inventory.setItem(13, new ClickableItem(cloud.getHead("hub.item.spawn"))
                .onClick("Se téléporter au spawn.", e -> player.teleport(Hub.get().getSpawnLocation()))
                .setDisplayName(playerData.format("hub.inv.item.spawn")));
        inventory.setItem(14, new ClickableItem(cloud.getHead("hub.item.fruityzone"))
                .onClick("Se téléporter à la zone VIP.", e -> {e.closeInventory(); e.sendMessage(playerData.format("hub.message.wip"));})
                .setDisplayName("§d§lF§a§lr§e§lu§c§li§9§lt§6§ly §f§lZone"));*/

        // - Teleport player to world's spawn location
        player.teleport(player.getWorld().getSpawnLocation());

        //BukkitCloud.get().getScoreboardManager().addScoreboard(player.getUniqueId(), new HubScoreboard(player));
        //BukkitCloud.get().getTitleManager().addTitle(player.getUniqueId(), new WelcomeTitle());
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            if(event.getCause() == EntityDamageEvent.DamageCause.VOID)
                //Teleport to spawn when the player is too low
                event.getEntity().teleport(Hub.get().getSpawnLocation());
        }
    }
}
