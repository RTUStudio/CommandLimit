package kr.rtustudio.commandlimit.command;

import kr.rtustudio.commandlimit.CommandLimit;
import kr.rtustudio.commandlimit.configuration.WhitelistConfig;
import kr.rtustudio.framework.bukkit.api.command.CommandArgs;
import kr.rtustudio.framework.bukkit.api.command.RSCommand;

public class MainCommand extends RSCommand<CommandLimit> {

    public MainCommand(CommandLimit plugin) {
        super(plugin, "cmdlimit");
    }

    @Override
    protected void reload(CommandArgs args) {
        plugin.reloadConfiguration(WhitelistConfig.class);
    }
}
