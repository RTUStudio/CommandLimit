package kr.rtuserver.commandlimit.commands;

import kr.rtuserver.commandlimit.RSCommandLimit;
import kr.rtuserver.commandlimit.configuration.LimitConfig;
import kr.rtuserver.framework.bukkit.api.command.RSCommand;
import kr.rtuserver.framework.bukkit.api.command.RSCommandData;

public class Command extends RSCommand<RSCommandLimit> {

    private final LimitConfig limitConfig;

    public Command(RSCommandLimit plugin) {
        super(plugin, "rscl");
        this.limitConfig = plugin.getLimitConfig();
    }

    @Override
    public void reload(RSCommandData data) {
        limitConfig.reload();
    }

}
