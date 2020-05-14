package ru.leaves.lefdev.profile;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.form.window.FormWindowSimple;
import me.onebone.economyapi.EconomyAPI;
import ru.leaves.lefdev.profile.ProfileAPI;
import ru.nukkitx.forms.elements.SimpleForm;

public class ProfileCommand extends Command {

    public ProfileCommand() {
        super("profile", "Статистика игрока", "/profile");
        this.commandParameters.clear();
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cUse command in game!");
            return false;
        }
        Player player = (Player) sender;
        String name = player.getName();
        double monney = EconomyAPI.getInstance().myMoney(player);
        Integer money = (int) monney;
        double joi = ProfileAPI.getInstance().getJoin(player);
        Integer join = (int) joi;
        double bri = ProfileAPI.getInstance().getBrik(player);
        Integer brik = (int) bri;
        double plac = ProfileAPI.getInstance().getPlace(player);
        Integer place = (int) plac;
        double kil = ProfileAPI.getInstance().getKill(player);
        Integer kill = (int) kil;
        String address = player.getAddress();
        double ping = player.getPing();
        String client = player.getClientSecret();
        FormWindowSimple forms = new FormWindowSimple("§8§lВаш профиль", "§l§fВаше имя: §l§a" + name + "\n§l§fВаш баланс: §e" + money + "\n§l§fВходов в игру: §b" + join + "\n§l§fУбиств: §c" + kill + "\n§l§fПоставлено блоков: §a" + place + "\n§l§fСломано блоков: §a" + brik + "\n§l§fАдрес: §e" + address + "\n§l§fПинг: §a" + ping);
        player.showFormWindow(forms);
        return true;
    }
}
