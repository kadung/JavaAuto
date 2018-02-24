package tests.seleniumeasy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.WebUtils;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class InputPage {
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(InputPage.class);

    // Constructor
    public InputPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    private By checkBoxMessage = By.id("txtAge");
    private By checkAllbutton  = By.id("check1");



    // -----------------------------------------------------------------------------
    // Select tag drop-down list
    public void goSelectDropDown() {
        driver.get("http://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        driver.manage().window().maximize();
    }

    public InputPage dropDownSingle(String dropDownBoxName, String text){
        Select dropDown = new Select(driver.findElement(By.xpath("//*[text()='" + dropDownBoxName + "']/following-sibling::div/select")));
        dropDown.selectByVisibleText(text);
        return this;
    }

    public InputPage dropDownSingleSelectByText(String dropDownBoxName, String text){
        Select dropDown = new Select(driver.findElement(By.xpath("//*[text()='" + dropDownBoxName + "']/following-sibling::div/select")));
        if (!dropDown.isMultiple()){
            dropDown.selectByVisibleText(text);
            return this;
        }

        try {
            Robot rb = new Robot();
            rb.keyPress(KeyEvent.VK_CONTROL);
            dropDown.selectByVisibleText(text);
            Thread.sleep(100);
            rb.keyRelease(KeyEvent.VK_CONTROL);

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public InputPage dropDownMultipleSelectContinous(String dropDownBoxName, int fromItem, int toItem ){
        List<WebElement> selectList = driver.findElements((By.xpath("//*[text()='" + dropDownBoxName + "']/following-sibling::div/select/option")));
        Actions action = new Actions(driver);
        action.clickAndHold(selectList.get(fromItem - 1)).moveToElement(selectList.get(toItem - 1)).release().build().perform();
        return this;
    }

    // -----------------------------------------------------------------------------
    // Jquery drop-down list
    public void goJqueryDropDown() {
        driver.get("http://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
        driver.manage().window().maximize();
    }





}
