package kr.rtuserver.commandlimit.configuration;

import kr.rtuserver.commandlimit.RSCommandLimit;
import kr.rtuserver.framework.bukkit.api.config.RSConfiguration;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class LimitConfig extends RSConfiguration<RSCommandLimit> {

    private final Map<String, List<String>> map = new HashMap<>();

    public LimitConfig(RSCommandLimit plugin) {
        super(plugin, "Limit.yml", null);
        setup(this);
    }

    private void init() {
        getConfig().setComment("", """
                해당 기능은 명령어의 사용 제한을 구성합니다
                그러나 명령어를 실행하기 위해 명령어 자체 권한도 필요합니다
                This feature configures the usage limit of commands
                However, you also need permission what from command for execution""");
        getStringList("default", List.of("help"), """
                rscl.default (기본적으로 활성화됨)
                rscl.default (Enabled by default)""");
        for (String key : getConfig().getKeys(false)) {
            map.put(key, getStringList(key, List.of()));
        }
    }
}
