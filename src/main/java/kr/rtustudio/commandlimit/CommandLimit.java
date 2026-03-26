package kr.rtustudio.commandlimit;

import kr.rtustudio.commandlimit.command.MainCommand;
import kr.rtustudio.commandlimit.configuration.WhitelistConfig;
import kr.rtustudio.commandlimit.handler.PlayerCommandPreprocess;
import kr.rtustudio.commandlimit.handler.PlayerCommandSend;
import kr.rtustudio.configurate.model.ConfigPath;
import kr.rtustudio.framework.bukkit.api.RSPlugin;
import lombok.Getter;
import org.bukkit.permissions.PermissionDefault;

@Getter
public class CommandLimit extends RSPlugin {
 
    @Getter
    private static CommandLimit instance;

    @Override
    protected void load() {
        instance = this;
    }

    @Override
    protected void enable() {
        registerPermission("default", PermissionDefault.TRUE);
        registerPermission("bypass.execute", PermissionDefault.OP);
        registerPermission("bypass.tabcomplete", PermissionDefault.OP);

        registerConfiguration(WhitelistConfig.class, ConfigPath.of("Whitelist"));

        registerEvent(new PlayerCommandPreprocess(this));
        registerEvent(new PlayerCommandSend(this));
        registerCommand(new MainCommand(this), true);
    }

}
