package playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.wikipedia.org/");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close")).click();
            page.getByLabel("Search Wikipedia").click();
            page.getByLabel("Search Wikipedia").fill("playwright");
            page.getByLabel("Search Wikipedia").click();
            page.getByLabel("Search Wikipedia").press("Enter");
            page.pause();
            page.getByText("$100").click();
            page.getByText("I’ll generously add $4 to cover the transaction fees so you can keep 100% of my ").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Talk")).click();
            page.navigate("https://en.wikipedia.org/wiki/Literature");
        }
    }
}
