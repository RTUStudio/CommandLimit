package kr.rtustudio.commandlimit.listener;

import kr.rtustudio.commandlimit.CommandLimit;
import kr.rtustudio.commandlimit.configuration.WhitelistConfig;
import kr.rtustudio.framework.bukkit.api.listener.RSListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandSendEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class PlayerCommandSend extends RSListener<CommandLimit> {

    private final WhitelistConfig whitelistConfig;

    public PlayerCommandSend(CommandLimit plugin) {
        super(plugin);
        this.whitelistConfig = plugin.getConfiguration(WhitelistConfig.class);
    }

    @EventHandler
    public void onTabComplete(PlayerCommandSendEvent e) {
        Player player = e.getPlayer();
        if (getPlugin().hasPermission(player, "bypass.tabcomplete")) return;

        e.getCommands().clear();

        Set<String> set = new HashSet<>();
        Map<String, List<String>> map = whitelistConfig.getMap();
        for (String group : map.keySet()) {
            List<String> list = map.get(group);
            if (list.isEmpty()) continue;
            if (getPlugin().hasPermission(player, group)) set.addAll(list);
        }

        e.getCommands().addAll(set);
    }

}
