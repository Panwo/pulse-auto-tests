package properies;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:common.properties"})
public interface CommonConfig extends Config {

    @DefaultValue("auto")
    String env();

    @Key("${env}.baseUrl")
    String baseUrl();

}