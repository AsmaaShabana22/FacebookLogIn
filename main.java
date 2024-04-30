package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com/");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//a[normalize-space()='Create new account'])[1]")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.name("firstname")).sendKeys("asmaa");
        driver.findElement(By.name("lastname")).sendKeys("shabana");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.name("reg_email__")).sendKeys("as@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123abc");

        WebElement ele = driver.findElement(By.name("birthday_day"));
        Select sel = new Select(ele);
        sel.selectByVisibleText("11");

        WebElement ele1 = driver.findElement(By.name("birthday_month"));
        Select sel1 = new Select(ele1);
        sel1.selectByVisibleText("Jun");

        WebElement ele2 = driver.findElement(By.name("birthday_year"));
        Select sel2 = new Select(ele2);
        sel2.selectByVisibleText("1988");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> l = driver.findElements(By.xpath("(//span[@data-name='gender_wrapper'])"));
        for (WebElement i : l) {
            System.out.println(i.getText());
        }

        driver.findElement(By.xpath("(//label[normalize-space()='Female'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.name("websubmit")).click();

        driver.close();


    }
}
