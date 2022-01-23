import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ga2ee.ResetField;

public class TriAngle {

    @Test
    public void testcase() throws InterruptedException  {


        //указан путь драйвера, запуск драйвера, переход по странице, максимальное разрешение окна
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        ResetField resetField  = new ResetField();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://playground.learnqa.ru/puzzle/triangle");
        driver.navigate().refresh();
//      driver.manage().window().maximize();
        /*

        Ищем кнопку сабмит( Показать) и поля А , Б , С
         */
        WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-submit']"));

        WebElement fild = driver.findElement(By.className("js_a"));
        WebElement fild2 = driver.findElement(By.className("js_b"));
        WebElement fild3 = driver.findElement(By.className("js_c"));
        Thread.sleep(3500);
        button.click();
        fild2.sendKeys("2");
        fild3.sendKeys("2");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);
        /*

        Проверка пустого поля и отправка только двух заполненных (B и C )
         */

        fild.sendKeys("3");
        fild2.sendKeys("4");
        fild3.sendKeys("5");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("2");
        fild2.sendKeys("3");
        fild3.sendKeys("4");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);



        fild.sendKeys("66");
        fild2.sendKeys("67");
        fild3.sendKeys("68");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("3");
        fild2.sendKeys("3");
        fild3.sendKeys("5");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("6");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);

        fild.sendKeys("2");
        fild2.sendKeys("3");
        fild3.sendKeys("10");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("w");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("4294967295");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("SELECT * FROM user");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("<script> </script>");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("6");
        fild2.sendKeys("6");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("0");
        fild2.sendKeys("0");
        fild3.sendKeys("0");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


        fild.sendKeys("6.6");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);

        fild.sendKeys("<SCRIPT></SCRIPT>");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        resetField.resetingfield(fild,fild2,fild3);


    }


/*    public void resetingfield(WebElement field, WebElement field2, WebElement field3) {
        field.clear();
        field2.clear();
        field3.clear();
    }*/
}
