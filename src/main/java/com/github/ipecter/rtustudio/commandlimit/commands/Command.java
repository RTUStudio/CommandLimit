package com.github.ipecter.rtustudio.commandlimit.commands;

import com.github.ipecter.rtustudio.commandlimit.CommandLimit;
import com.github.ipecter.rtustudio.commandlimit.configuration.LimitConfig;
import kr.rtuserver.framework.bukkit.api.command.RSCommand;
import kr.rtuserver.framework.bukkit.api.command.RSCommandData;

public class Command extends RSCommand<CommandLimit> {

    private final LimitConfig limitConfig;

    public Command(CommandLimit plugin) {
        super(plugin, "cmdlimit");
        this.limitConfig = plugin.getLimitConfig();
    }

    @Override
    public void reload(RSCommandData data) {
        limitConfig.reload();
    }

}
