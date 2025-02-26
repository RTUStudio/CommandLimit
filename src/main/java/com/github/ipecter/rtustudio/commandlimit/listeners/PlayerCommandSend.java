package com.github.ipecter.rtustudio.commandlimit.listeners;

import com.github.ipecter.rtustudio.commandlimit.CommandLimit;
import kr.rtuserver.framework.bukkit.api.listener.RSListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlayerCommandSend extends RSListener<CommandLimit> {

    public PlayerCommandSend(CommandLimit plugin) {
        super(plugin);
    }

    @EventHandler
    public void onTabComplete(PlayerCommandSendEvent e) {
        Player player = e.getPlayer();
        if (player.hasPermission("cmdlimit.bypass.tabComplete")) return;

        e.getCommands().clear();

        Set<String> set = new HashSet<>();
        Map<String, List<String>> map = getPlugin().getLimitConfig().getMap();
        for (String group : map.keySet()) {
            List<String> list = map.get(group);
            if (list.isEmpty()) continue;
            if (player.hasPermission("cmdlimit." + group)) set.addAll(list);
        }

        e.getCommands().addAll(set);
    }

}
