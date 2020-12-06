package net.berrygames.hub;

import lombok.Getter;
import net.berrygames.cloudberry.bukkit.BukkitCloud;
import net.berrygames.cloudberry.bukkit.item.ItemBuilder;
import net.berrygames.hub.listener.PlayerListener;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin {

    @Getter
    private Location spawnLocation;

    public Hub() {}

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onEnable() {
        super.onEnable();

        // - Disable all events and protect world
        var shield = BukkitCloud.get().getWorldShield();
        shield.enableWorldProtection(false);
        shield.disableEntityDamage();
        shield.disableHunger();
        shield.disableDrops();
        shield.disablePickups();

        //BukkitCloud.get().getWorldShield().disableAll();
        var world = getServer().getWorld("world");
        world.getEntities().forEach(Entity::remove);
        world.setSpawnLocation(new Location(world, -293.5, 97, -988.5, (float) 90.0, (float) 0.0));

        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        // - Register custom heads.
        BukkitCloud.get().registerHead("hub.item.games", "http://textures.minecraft.net/texture/b12ef1b486e97e4cb124aa7629aceb91edc51d63338c91a012885493c5d9c");
        BukkitCloud.get().registerHead("hub.item.arcade", "http://textures.minecraft.net/texture/2ab214e253e5676433a71df13c4ed01a8ed7a275c147e87c577f3aae1869431f");
        BukkitCloud.get().registerHead("hub.item.pannel", "https://textures.minecraft.net/texture/109cde1afc95a474d222554097ed6d391e7cc7ae1f202fdbfd2d6dbc98309370");
        BukkitCloud.get().registerHead("hub.item.cosmetics", "http://textures.minecraft.net/texture/9c96be7886eb7df75525a363e5f549626c21388f0fda988a6e8bf487a53");
        BukkitCloud.get().registerHead("hub.item.hubs", "http://textures.minecraft.net/texture/38be8abd66d09a58ce12d377544d726d25cad7e979e8c2481866be94d3b32f");
        BukkitCloud.get().registerHead("hub.item.jump", "http://textures.minecraft.net/texture/7d1169b2694a6aba826360992365bcda5a10c89a3aa2b48c438531dd8685c3a7");
        BukkitCloud.get().registerHead("hub.item.spawn", "http://textures.minecraft.net/texture/cf7cdeefc6d37fecab676c584bf620832aaac85375e9fcbff27372492d69f");
        BukkitCloud.get().registerHead("hub.item.fruityzone", "http://textures.minecraft.net/texture/476d61d0da9c3395725fd50da17896219379fc99cdb5f6137beacf49f237e2ef");

        //TODO: Init BoxManager and boxs with location | Get from JavaPlugin#getConfig
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Hub get() {
        return getPlugin(Hub.class);
    }
}
