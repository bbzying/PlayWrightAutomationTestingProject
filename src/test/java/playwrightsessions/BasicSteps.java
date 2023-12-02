package playwrightsessions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasicSteps extends PlaywrightBasics{
    private static final Logger LOGGER = LogManager.getLogger(BasicSteps.class);
    @Given("I Setup Browser {string}")
    public void iSetupBrowser(String browser){
        LOGGER.info(browser);
        launchBrowser("chromium");
    }

    @Given("I open page {string}")
    public void iOpenPage(String URL){
        System.out.println("Navigate to " + URL);
        page.navigate(URL);
    }

    @And("I click on button {string}")
    public void iClickOnButton(String buttonName){
        page.locator(String.format("xpath=//td[contains(text(), '%s')]/following::button", buttonName)).click();
    }

    @And("I wait for {string} seconds")
    public void iWaitForSeconds(String seconds){
        try {
            System.out.println("Wait for " + seconds + " seconds");
            Thread.sleep(Integer.parseInt(seconds) * 1000L);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Given("I tear down")
    public void iTearDown(){
        closeBrowser();
    }
}
