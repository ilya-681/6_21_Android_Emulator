package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/${env}.properties"
})
public interface DeviceConfig extends Config {

    @DefaultValue("Google Pixel 3")
    @Key("device")
    String device();

    @DefaultValue("9.0")
    @Key("os_version")
    String os_version();
}
