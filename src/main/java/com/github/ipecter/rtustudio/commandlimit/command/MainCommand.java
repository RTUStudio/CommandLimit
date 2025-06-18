package com.github.ipecter.rtustudio.commandlimit.command;

import com.github.ipecter.rtustudio.commandlimit.CommandLimit;
import com.github.ipecter.rtustudio.commandlimit.configuration.LimitConfig;
import kr.rtuserver.framework.bukkit.api.command.RSCommand;
import kr.rtuserver.framework.bukkit.api.command.RSCommandData;
import org.bukkit.permissions.PermissionDefault;

public class MainCommand extends RSCommand<CommandLimit> {

    private final LimitConfig limitConfig;

    public MainCommand(CommandLimit plugin) {
        super(plugin, "cmdlimit", PermissionDefault.OP);
        this.limitConfig = plugin.getLimitConfig();
    }

    @Override
    public void reload(RSCommandData data) {
        limitConfig.reload();
    }

}
