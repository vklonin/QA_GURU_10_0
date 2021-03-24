package helpers;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:test.properties")
public interface TestConfig extends Config {

    @Key("baseURL")
    String getBaseURL();

    @Key("toSearch")
    String getValueSearched();

    @Key("toCheck")
    String getValueToCheck();


}

