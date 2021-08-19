package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/${env}.properties"
})
public interface AppConfig extends Config {

    @Key("browserStackUsername")
    String browserStackUsername();

    @Key("browserStackPassword")
    String browserStackPassword();

    @Key("app")
    String app();

    @Key("browserStackURL")
    String browserStackURL();
}
