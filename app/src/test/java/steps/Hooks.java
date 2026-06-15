package steps;

import io.cucumber.java.After;
import pages.DriverManager;

public class Hooks {

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}