package helpers;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface WebDriverConfig extends Config {

    @Key("webDriver")
    String getWebdriver();

    @Key("browser")
    String getWebdriverBrowser();

    @Key("browserVersion")
    String getWebdriverBrowserVersion();


    @Key("environment")
    String getEnvironment();

}

