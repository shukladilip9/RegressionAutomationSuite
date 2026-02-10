package org.mac.pages;

import org.mac.base.BasePage;
import org.mac.pages.components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By labelDashboardHeader = By.xpath("//h6[text()='Dashboard']");
    public final HeaderComponent header;

    public DashboardPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }


}