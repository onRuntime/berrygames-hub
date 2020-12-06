package net.berrygames.hub.menu.game;

import net.berrygames.cloudberry.bukkit.BukkitCloud;
import org.bukkit.entity.Player;

public class GameMenu {

    public void display(Player player) {
        var translatable = BukkitCloud.get().getTranslatable();

        //setTitle(translatable.format(player.getName(), "hub.menu.game.title"));
    }
}
