package net.berrygames.hub.scoreboard;

import net.berrygames.Format;
import net.berrygames.cloudberry.bukkit.BukkitCloud;
import net.berrygames.cloudberry.bukkit.player.PlayerData;
import net.berrygames.cloudberry.bukkit.scoreboard.NetworkScoreboard;
import net.berrygames.cloudberry.bukkit.scoreboard.ObjectiveSign;
import org.bukkit.entity.Player;

public class HubScoreboard extends NetworkScoreboard {

    private final PlayerData playerData;

    private String rankTag = "";
    private long coins = 0;
    private long credits = 0;
    private long experience = 0;
    private int online = 0;
    private int hubId;

    public HubScoreboard(Player player) {
        super(player);

        playerData = BukkitCloud.get().getPlayer(player.getName());
        //hubId = BukkitCloud.get().getServerManager().getCurrentServer().getId();
    }

    @Override
    public ObjectiveSign getScoreboard(ObjectiveSign objective) {
        objective.setLine(1, playerData.format("hub.sb.main.rank", rankTag));
        objective.setLine(2, "§a");
        objective.setLine(3, playerData.format("hub.sb.main.coins", Format.format(coins)));
        objective.setLine(4, playerData.format("hub.sb.main.credits", Format.format(credits)));
        objective.setLine(5, playerData.format("hub.sb.main.level", experience));
        objective.setLine(6, "§7§l■■■■■■■■■■■■");
        objective.setLine(7, "§b");
        objective.setLine(8, playerData.format("hub.sb.main.hub", hubId));
        objective.setLine(9, playerData.format("hub.sb.main.players", online));
        return objective;
    }

    @Override
    public void updateData() {
        rankTag = playerData.getRank().getTag();
        coins = playerData.getCoins();
        credits = playerData.getCredits();
        experience = playerData.getExperience();
        //online = Cloudberry.get().getServerManager().getOnlinePlayers(ServerType.BUNGEE);
    }
}
