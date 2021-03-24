package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import helpers.TestConfig;
import helpers.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleWebTest {

    static final WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static final TestConfig testConfig = ConfigFactory.create(TestConfig.class, System.getProperties());

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = testConfig.getBaseURL();
        Configuration.browser = webConfig.getWebdriverBrowser();
        Configuration.browserVersion = webConfig.getWebdriverBrowserVersion();
        String env = webConfig.getEnvironment();

        if (env.equals("remote"))
        {
            Configuration.remote = webConfig.getWebdriver();
        }
    }



    @Test
    @Tag("web")
    void googleSearchWorking(){

        //System.out.println(Configuration.remote);
        open("");
        $(byName("q")).setValue(testConfig.getValueSearched()).pressEnter();
        $(byText(testConfig.getValueToCheck())).shouldBe(Condition.visible);

    }


}
