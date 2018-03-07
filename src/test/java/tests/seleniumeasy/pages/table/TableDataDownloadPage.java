package tests.seleniumeasy.pages.table;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.ExcelUtils;

import java.io.File;

public class TableDataDownloadPage {
    private WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(TableFilterPage.class);

    public TableDataDownloadPage(WebDriver driver){
        this.driver = driver;
    }

    // Action
    public TableDataDownloadPage goTableDataDownloadPage(){
        driver.get("http://www.seleniumeasy.com/test/table-data-download-demo.html");
        driver.manage().window().maximize();
        return this;
    }

    public TableDataDownloadPage clickDownloadFile(String fileType){
        driver.findElement(By.xpath("//span[contains(text(),'" + fileType + "')]")).click();
        return this;
    }

    // Assertion
    public TableDataDownloadPage verifyFileDownloaded(String downloadPath, String fileName, int timeOutInMinute) throws InterruptedException {
        File dir = new File(downloadPath);

        for (int i=0; i < timeOutInMinute; i++ ){
            Thread.sleep(1000);
            File[] dirItems = dir.listFiles();

            for (File item : dirItems) {
                if (item.getName().equals(fileName))
                    Assert.assertTrue(item.getName().equals(fileName));
                logger.info("File is download successfully");
                return this;
            }
        }
        logger.info("Failed to download Expected document");
        throw new TimeoutException();
    }

    public TableDataDownloadPage verifyCSVHasCorrectItemsQuatities(String filePath, int expectedItems){
        int totalItems = ExcelUtils.countTotalItemsInCSVFile(filePath, 1);
        logger.info("Total item in download file is " + totalItems);
        Assert.assertEquals(totalItems, expectedItems);
        return this;
    }
}
