package kr.rtustudio.commandlimit.configuration;

import kr.rtustudio.configurate.model.ConfigurationPart;
import kr.rtustudio.configurate.objectmapping.meta.Comment;
import kr.rtustudio.configurate.objectmapping.meta.Setting;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@SuppressWarnings({
        "unused",
        "CanBeFinal",
        "FieldCanBeLocal",
        "FieldMayBeFinal",
        "InnerClassMayBeStatic"
})
public class WhitelistConfig extends ConfigurationPart {

    @Comment("""
            Configure command usage limit
            The default permission is commandlimit.default and each group lists allowed commands
            명령어 사용 제한을 구성합니다.
            기본적으로 commandlimit.default 권한이 있으며, 권한에 따라 사용할 수 있는 명령어 목록을 설정합니다""")
    @Setting(nodeFromParent = true)
    private Map<String, List<String>> map =
            make(new HashMap<>(), it -> {
                it.put("default", List.of("help"));
                it.put("worldedit", List.of("/wand", "/copy"));
            });
}
