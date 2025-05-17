package com.github.ipecter.rtustudio.commandlimit.listener;

import com.github.ipecter.rtustudio.commandlimit.CommandLimit;
import kr.rtuserver.framework.bukkit.api.listener.RSListener;
import kr.rtuserver.framework.bukkit.api.player.PlayerChat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlayerCommandPreprocess extends RSListener<CommandLimit> {

    public PlayerCommandPreprocess(CommandLimit plugin) {
        super(plugin);
    }

    @EventHandler
    public void onExecute(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        if (player.hasPermission("cmdlimit.bypass.execute")) return;
        String cmd = e.getMessage().replaceFirst("/", "").split(" ")[0];
        Set<String> set = new HashSet<>();
        Map<String, List<String>> map = getPlugin().getLimitConfig().getMap();
        for (String group : map.keySet()) {
            List<String> list = map.get(group);
            if (list.isEmpty()) continue;
            if (player.hasPermission("cmdlimit." + group)) set.addAll(list);
        }
        if (!set.contains(cmd)) {
            e.setCancelled(true);
            PlayerChat chat = PlayerChat.of(getPlugin());
            chat.announce(player, getMessage().get(player, "noPermission"));
        }
    }

}
