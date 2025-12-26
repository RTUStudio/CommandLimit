package kr.rtustudio.commandlimit.listener;

import kr.rtustudio.commandlimit.CommandLimit;
import kr.rtustudio.commandlimit.configuration.WhitelistConfig;
import kr.rtustudio.framework.bukkit.api.listener.RSListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class PlayerCommandPreprocess extends RSListener<CommandLimit> {

    private final WhitelistConfig whitelistConfig;

    public PlayerCommandPreprocess(CommandLimit plugin) {
        super(plugin);
        this.whitelistConfig = plugin.getConfiguration(WhitelistConfig.class);
    }

    @EventHandler
    public void onExecute(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        if (getPlugin().hasPermission(player, "bypass.execute")) return;
        String cmd = e.getMessage().replaceFirst("/", "").split(" ")[0];
        Set<String> set = new HashSet<>();
        Map<String, List<String>> map = whitelistConfig.getMap();
        for (String group : map.keySet()) {
            List<String> list = map.get(group);
            if (list.isEmpty()) continue;
            if (getPlugin().hasPermission(player, group)) set.addAll(list);
        }
        if (!set.contains(cmd)) {
            e.setCancelled(true);
            chat().announce(player, message().get(player, "no-permission"));
        }
    }

}
