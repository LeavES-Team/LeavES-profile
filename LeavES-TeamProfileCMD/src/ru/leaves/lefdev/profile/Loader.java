package ru.leaves.lefdev.profile;

import cn.nukkit.Server;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.level.Position;
import cn.nukkit.plugin.PluginBase;
import ru.leaves.lefdev.profile.ProfileCommand;
import ru.leaves.lefdev.profile.ProfileAPI;
import ru.leaves.lefdev.profile.EventListener;
import ru.leaves.lefdev.profile.PlayerDeathListener;
import ru.leaves.lefdev.profile.PlayerJoinListener;
import java.util.Arrays;

public class Loader extends PluginBase {

    @Override
    public void onEnable() {
        new ProfileAPI();
        this.registerListeners();
        Server.getInstance().getCommandMap().register("", new ProfileCommand());
    }

    private void registerListeners() {
        Arrays.asList(
                new EventListener(),
                new PlayerJoinListener(),
                new PlayerDeathListener()
        ).forEach(listener -> Server.getInstance().getPluginManager().registerEvents(listener, this));
    }

    @Override
    public void onDisable() {
        ProfileAPI.config.save();
    }
}