package kr.rtuserver.commandlimit.commands;

import kr.rtuserver.commandlimit.RSCommandLimit;
import kr.rtuserver.commandlimit.configuration.LimitConfig;
import kr.rtuserver.framework.bukkit.api.RSPlugin;
import kr.rtuserver.framework.bukkit.api.command.RSCommand;
import kr.rtuserver.framework.bukkit.api.command.RSCommandData;

public class Command extends RSCommand {

    private final LimitConfig limitConfig = RSCommandLimit.getInstance().getLimitConfig();

    public Command(RSPlugin plugin) {
        super(plugin, "rscl", true);
    }

    @Override
    public void reload(RSCommandData data) {
        limitConfig.reload();
    }

}
