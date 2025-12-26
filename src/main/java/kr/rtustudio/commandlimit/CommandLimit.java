package kr.rtustudio.commandlimit;

import kr.rtustudio.commandlimit.command.MainCommand;
import kr.rtustudio.commandlimit.configuration.WhitelistConfig;
import kr.rtustudio.commandlimit.listener.PlayerCommandPreprocess;
import kr.rtustudio.commandlimit.listener.PlayerCommandSend;
import kr.rtustudio.framework.bukkit.api.RSPlugin;
import lombok.Getter;
import org.bukkit.permissions.PermissionDefault;

@Getter
public class CommandLimit extends RSPlugin {

    @Override
    public void enable() {
        registerPermission("default", PermissionDefault.TRUE);
        registerPermission("bypass.execute", PermissionDefault.OP);
        registerPermission("bypass.tabcomplete", PermissionDefault.OP);

        registerConfiguration(WhitelistConfig.class, "Whitelist");

        registerEvent(new PlayerCommandPreprocess(this));
        registerEvent(new PlayerCommandSend(this));
        registerCommand(new MainCommand(this), true);
    }

}
