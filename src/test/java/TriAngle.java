import org.junit.Assert;
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
        Thread.sleep(2000);

        WebElement infoLogError = driver.findElement(By.xpath("//div[@class='info logg error']"));

        Assert.assertEquals(infoLogError.getText(), "Задайте все стороны.");

        fild2.sendKeys("2");
        fild3.sendKeys("2");
        Thread.sleep(500);
        button.click();
        Thread.sleep(500);
        Assert.assertEquals(infoLogError.getText(), "Задайте все стороны.");
        ResetField.resetingfield(fild,fild2,fild3);
        /*

        Проверка пустого поля и отправка только двух заполненных (B и C )
         */

        fild.sendKeys("3");
        fild2.sendKeys("4");
        fild3.sendKeys("5");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        WebElement infoLog = driver.findElement(By.xpath("//div[@class='info logg']"));
        Assert.assertEquals(infoLog.getText(),"Это прямоугольный треугольник.\n" +
                "Вы ввели:\n" +
                "A: 3; B: 4; C: 5");


        fild.sendKeys("2");
        fild2.sendKeys("3");
        fild3.sendKeys("4");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        WebElement infoLogg = driver.findElement(By.xpath("//div[@class='info logg']"));
        Assert.assertEquals(infoLogg.getText(),"Это тупоугольный треугольник.\n" +
                "Вы ввели:\n" +
                "A: 2; B: 3; C: 4");




        fild.sendKeys("66");
        fild2.sendKeys("67");
        fild3.sendKeys("68");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogg.getText(),"Это остроугольный треугольник.\n" +
                "Вы ввели:\n" +
                "A: 66; B: 67; C: 68");

        fild.sendKeys("3");
        fild2.sendKeys("3");
        fild3.sendKeys("5");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogg.getText(),"Это равнобедренный треугольник.\n" +
                "Вы ввели:\n" +
                "A: 3; B: 3; C: 5");


        fild.sendKeys("6");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogg.getText(),"Это равносторонний треугольник.\n" +
                "Вы ввели:\n" +
                "A: 6; B: 6; C: 6");


        fild.sendKeys("2");
        fild2.sendKeys("3");
        fild3.sendKeys("10");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogError.getText(),"Одна сторона больше суммы двух других или равна ей.\n" +
                "Вы ввели:\n" +
                "A: 2; B: 3; C: 10");

        fild.sendKeys("w");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogError.getText(),"Это НЕ треугольник.\n" +
                "Вы ввели:\n" +
                "A: w; B: 6; C: 6");

        fild.sendKeys("4294967295");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogError.getText(),"Числа слишком большие.\n" +
                "Вы ввели:\n" +
                "A: 4294967295; B: 6; C: 6");

        fild.sendKeys("SELECT * FROM user");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogError.getText(),"SQL-инъекции это плохо! Так не получится. :)");

        fild.sendKeys("<script> </script>");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogError.getText(), "XSS это плохо! Так не получится. :)");


        fild.sendKeys("6");
        fild2.sendKeys("6");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogError.getText(),"Это НЕ треугольник.\n" +
                "Вы ввели:\n" +
                "A: 6; B: 6; C:");

        fild.sendKeys("0");
        fild2.sendKeys("0");
        fild3.sendKeys("0");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogg.getText(),"Это равносторонний треугольник.\n" +
                "Вы ввели:\n" +
                "A: 0; B: 0; C: 0");


        fild.sendKeys("6.6");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        Assert.assertEquals(infoLogError.getText(),"Это НЕ треугольник.\n" +
                "Вы ввели:\n" +
                "A: 6.6; B: 6; C: 6");

        fild.sendKeys("<SCRIPT></SCRIPT>");
        fild2.sendKeys("6");
        fild3.sendKeys("6");
        Thread.sleep(500);
        button.click();
        ResetField.resetingfield(fild,fild2,fild3);
        WebElement caseDetail = driver.findElement(By.xpath("//*[.='Кейс - Попробовали XSS']"));
        Assert.assertEquals(caseDetail.getText(), "Кейс - Попробовали XSS");

    }


}
