package ru.leaves.lefdev.profile;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.entity.EntityDeathEvent;
import me.onebone.economyapi.EconomyAPI;
import ru.leaves.lefdev.profile.ProfileAPI;

public class EventListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        EntityDamageEvent lastDamage = entity.getLastDamageCause();

        if (lastDamage instanceof EntityDamageByEntityEvent) {
            Entity damager = ((EntityDamageByEntityEvent) lastDamage).getDamager();

            if (damager instanceof Player) {
                Player player = (Player) damager;
                double kill = ProfileAPI.getInstance().getKill(player);

                if (event.getEntity() instanceof Player) {
                    kill++;
                } else {
                    kill++;
                }


                ProfileAPI.getInstance().setKill(player, kill);
                ProfileAPI.config.save();
                return;

            }
        }
    }

}