package ru.leaves.lefdev.profile;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;
import com.google.gson.internal.LinkedTreeMap;
import ru.leaves.lefdev.profile.ProfileCommand;

import java.util.HashMap;

public class ProfileAPI {

    public static final Config config = new Config("plugins/profile/dataBase.json", Config.JSON);
    private static ProfileAPI instance;

    public ProfileAPI() {
        instance = this;
    }

    public void initPlayer(Player player) {
        String playerName = player.getName().toLowerCase();

        if (!config.exists(playerName)) {
            HashMap<String, Double> params = new HashMap<>();
            params.put("join", 0d);
            params.put("brik", 0d);
            params.put("place", 0d);
            params.put("kill", 0d);
            config.set(playerName, params);
        }
    }

    public void setJoin(Player player, double val) {
        HashMap<String, Double> params = new HashMap<>();
        params.put("join", val);
        params.put("brik", getBrik(player));
        params.put("place", getPlace(player));
        params.put("kill", getKill(player));
        config.set(player.getName().toLowerCase(), params);
    }

    public void setBrik(Player player, double val) {
        HashMap<String, Double> params = new HashMap<>();
        params.put("join", getJoin(player));
        params.put("brik", val);
        params.put("place", getPlace(player));
        params.put("kill", getKill(player));
        config.set(player.getName().toLowerCase(), params);
    }

    public void setPlace(Player player, double val) {
        HashMap<String, Double> params = new HashMap<>();
        params.put("join", getJoin(player));
        params.put("brik", getBrik(player));
        params.put("place", val);
        params.put("kill", getKill(player));
        config.set(player.getName().toLowerCase(), params);
    }

    public void setKill(Player player, double val) {
        HashMap<String, Double> params = new HashMap<>();
        params.put("join", getJoin(player));
        params.put("brik", getBrik(player));
        params.put("place", getPlace(player));
        params.put("kill", val);
        config.set(player.getName().toLowerCase(), params);
    }

    public double getJoin(Player player) {
        Double join;
        try {
            join = ((HashMap<String, Double>) config.get(player.getName().toLowerCase())).get("join");
        } catch (Exception ex) {
            join = ((LinkedTreeMap<String, Double>) config.get(player.getName().toLowerCase())).get("join");
        }
        return join;
    }

    public double getBrik(Player player) {
        Double brik;
        try {
            brik = ((HashMap<String, Double>) config.get(player.getName().toLowerCase())).get("brik");
        } catch (Exception ex) {
            brik = ((LinkedTreeMap<String, Double>) config.get(player.getName().toLowerCase())).get("brik");
        }
        return brik;
    }

    public double getPlace(Player player) {
        Double place;
        try {
            place = ((HashMap<String, Double>) config.get(player.getName().toLowerCase())).get("place");
        } catch (Exception ex) {
            place = ((LinkedTreeMap<String, Double>) config.get(player.getName().toLowerCase())).get("place");
        }
        return place;
    }

    public double getKill(Player player) {
        Double kill;
        try {
            kill = ((HashMap<String, Double>) config.get(player.getName().toLowerCase())).get("kill");
        } catch (Exception ex) {
            kill = ((LinkedTreeMap<String, Double>) config.get(player.getName().toLowerCase())).get("kill");
        }
        return kill;
    }


    public static ProfileAPI getInstance() {
        return instance;
    }
}