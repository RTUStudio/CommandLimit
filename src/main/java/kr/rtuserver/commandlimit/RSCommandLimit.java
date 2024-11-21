package kr.rtuserver.commandlimit;

import kr.rtuserver.commandlimit.commands.Command;
import kr.rtuserver.commandlimit.configuration.LimitConfig;
import kr.rtuserver.commandlimit.listeners.PlayerCommandPreprocess;
import kr.rtuserver.commandlimit.listeners.PlayerCommandSend;
import kr.rtuserver.framework.bukkit.api.RSPlugin;
import lombok.Getter;
import org.bukkit.permissions.PermissionDefault;

public class RSCommandLimit extends RSPlugin {

    @Getter
    private static RSCommandLimit instance;
    @Getter
    private LimitConfig limitConfig;

    @Override
    public void enable() {
        instance = this;

        registerPermission("rscl.default", PermissionDefault.TRUE);
        registerPermission("rscl.bypass.execute", PermissionDefault.OP);
        registerPermission("rscl.bypass.tabComplete", PermissionDefault.OP);

        limitConfig = new LimitConfig(this);

        registerEvent(new PlayerCommandPreprocess(this));
        registerEvent(new PlayerCommandSend(this));
        registerCommand(new Command(this));
    }
}
