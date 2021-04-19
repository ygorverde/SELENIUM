package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;

public class APIWebDriver {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ygor\\IdeaProjects\\APIWEBDRIVER\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.demo.guru99.com/V4/");
        driver.manage().window().setSize(new Dimension(1440, 813));
        driver.findElement(By.name("uid")).sendKeys("mngr231217");
        driver.findElement(By.name("password")).sendKeys("sYhAzaj");
        driver.findElement(By.name("btnLogin")).submit();
        driver.findElement(By.linkText("Balance Enquiry")).click();
        //driver.findElement(By.name("accountno")).click();
        driver.findElement(By.name("accountno")).sendKeys("71946");
        driver.findElement(By.name("AccSubmit")).click();
        String innerText = driver.findElement(
                By.xpath("//table/tbody/tr[6]/td[2]")).getText();
        System.out.println(innerText);
        //(new WebDriverWait(driver, 10)).wait();
        assertEquals( "71946", innerText);
        Thread.sleep(3000);
        driver.quit();
    }


}
