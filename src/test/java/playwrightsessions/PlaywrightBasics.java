package playwrightsessions;

import com.microsoft.playwright.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

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
        if (browserName.equalsIgnoreCase("chromium")){
            browserType = playwright.chromium();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            browserType = playwright.firefox();
        } else {
            browserType = playwright.webkit();
        }

        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        System.out.println("Create Context and Page");
        context = browser.newContext();
        page = context.newPage();
    }

    public static void closeBrowser(){
        System.out.println("Close Context");
        context.close();
        System.out.println("Close Browser");
        browser.close();

    }

}