package ru.leaves.lefdev.profile;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import ru.leaves.lefdev.profile.ProfileAPI;

public class PlayerJoinListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ProfileAPI.getInstance().initPlayer(event.getPlayer());
       double join = ProfileAPI.getInstance().getJoin(player);
       join++;
       ProfileAPI.getInstance().setJoin(player, join);
        ProfileAPI.config.save();
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        double brik = ProfileAPI.getInstance().getBrik(player);
        brik++;
        ProfileAPI.getInstance().setBrik(player, brik);
        ProfileAPI.config.save();
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player player = e.getPlayer();
        double place = ProfileAPI.getInstance().getPlace(player);
        place++;
        ProfileAPI.getInstance().setPlace(player, place);
        ProfileAPI.config.save();
    }

}