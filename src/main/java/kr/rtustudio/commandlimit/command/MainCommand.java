package kr.rtustudio.commandlimit.command;

import kr.rtustudio.commandlimit.CommandLimit;
import kr.rtustudio.commandlimit.configuration.WhitelistConfig;
import kr.rtustudio.framework.bukkit.api.command.RSCommand;
import kr.rtustudio.framework.bukkit.api.command.RSCommandData;

public class MainCommand extends RSCommand<CommandLimit> {

    public MainCommand(CommandLimit plugin) {
        super(plugin, "cmdlimit");
    }

    @Override
    protected void reload(RSCommandData data) {
        getPlugin().reloadConfiguration(WhitelistConfig.class);
    }
}
