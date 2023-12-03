package playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlaywrightBasics {
    private static final Logger LOGGER = LogManager.getLogger(PlaywrightBasics.class);
    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    public static void launchBrowser(String browserName) {
        BrowserType browserType;
        LOGGER.info("Launch Browser " + browserName);

        playwright = Playwright.create();
        LaunchOptions lp = new LaunchOptions();
        lp.setHeadless(false);

        if (browserName.equalsIgnoreCase("firefox")) {
            browserType = playwright.firefox();
        } else if (browserName.equalsIgnoreCase("safari")){
            browserType = playwright.webkit();
        } else {
            lp.setChannel(browserName.toLowerCase());
            lp.setArgs(Arrays.asList("--start-maximized"));
            browserType = playwright.chromium();
        }

        browser = browserType.launch(lp);
        System.out.println("Create Context and Page");
        context = browser.newContext();
        page = context.newPage();

    }

    public static void closeBrowser(){
        System.out.println("Close Context");
        context.close();
        System.out.println("Close Browser");
        browser.close();
        playwright.close();

    }



}