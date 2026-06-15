package steps;

import io.cucumber.java.After;
import pages.BasePage;

public class Hooks {

    @After
    public void tearDown() {
        BasePage.quitDriver();
    }
}