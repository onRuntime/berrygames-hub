package net.berrygames.hub.titles;

import net.berrygames.cloudberry.bukkit.title.AnimatedTitle;

import java.util.Map;

public class WelcomeTitle extends AnimatedTitle {

    public WelcomeTitle() {
        super(10, 10, 2, 10);
    }

    public Map<Integer, String[]> getTitle(Map<Integer, String[]> title) {
        return title;
    }
}
