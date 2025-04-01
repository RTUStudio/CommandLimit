package com.github.ipecter.rtustudio.commandlimit;

import com.github.ipecter.rtustudio.commandlimit.configuration.LimitConfig;
import com.github.ipecter.rtustudio.commandlimit.command.MainCommand;
import com.github.ipecter.rtustudio.commandlimit.listener.PlayerCommandPreprocess;
import com.github.ipecter.rtustudio.commandlimit.listener.PlayerCommandSend;
import kr.rtuserver.framework.bukkit.api.RSPlugin;
import lombok.Getter;
import org.bukkit.permissions.PermissionDefault;

@Getter
public class CommandLimit extends RSPlugin {

    private LimitConfig limitConfig;

    @Override
    public void enable() {
        registerPermission("cmdlimit.default", PermissionDefault.TRUE);
        registerPermission("cmdlimit.bypass.execute", PermissionDefault.OP);
        registerPermission("cmdlimit.bypass.tabComplete", PermissionDefault.OP);

        limitConfig = new LimitConfig(this);

        registerEvent(new PlayerCommandPreprocess(this));
        registerEvent(new PlayerCommandSend(this));
        registerCommand(new MainCommand(this), true);
    }

}
