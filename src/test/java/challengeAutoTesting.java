import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class challengeAutoTesting {

    @Test
    public void test1() {
        //указан путь драйвера, запуск драйвера, переход по странице, максимальное разрешение окна

        System.setProperty("webdriver.chrome.driver", "D:\\qa\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://testingchallenges.thetestingmap.org/");
        driver.manage().window().maximize();

        // Поиск поля по //name// отправка
        // Отправка Not ASCII
        WebElement firstfild = driver.findElement(By.name("firstname"));
        firstfild.sendKeys("Вывыв");
        WebElement button = driver.findElement(By.className("button"));
        button.submit();

        //пустота перед символами
        WebElement test1 = driver.findElement(By.name("firstname"));
        test1.sendKeys(" -");
        driver.findElement(By.className("button")).submit();

        //Максимальное значение
        WebElement test2 = driver.findElement(By.name("firstname"));
        test2.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.className("button")).submit();

        //Минимальное значение
        WebElement test3 = driver.findElement(By.name("firstname"));
        test3.sendKeys("a");
        driver.findElement(By.className("button")).submit();

        //Не буквенные символы
        WebElement test4 = driver.findElement(By.name("firstname"));
        test4.sendKeys("Aaaaa-aaaaa");
        driver.findElement(By.className("button")).submit();

        //Пробел в середине (( 7 ошибок выдаёт на этот момент ))  //
        WebElement test5 = driver.findElement(By.name("firstname"));
        test5.sendKeys("Aaa aaa ааа");
        driver.findElement(By.className("button")).submit();

        //Пробел в конце
        WebElement test6 = driver.findElement(By.name("firstname"));
        test6.sendKeys("Aaa aaa ааа ");
        driver.findElement(By.className("button")).submit();

        //просто пробел
        WebElement test7 = driver.findElement(By.name("firstname"));
        test7.sendKeys(" ");
        driver.findElement(By.className("button")).submit();

        // Пен-тесты

        // html тег
        WebElement test8 = driver.findElement(By.name("firstname"));
        test8.sendKeys(" <script> </script>");
        driver.findElement(By.className("button")).submit();

        // sql- запрос
        WebElement test9 = driver.findElement(By.name("firstname"));
        test9.sendKeys("SELECT * FROM users;");
        driver.findElement(By.className("button")).submit();

        //XSS-
        WebElement test10 = driver.findElement(By.name("firstname"));
        test10.sendKeys("SELECT * FROM users;");
        driver.findElement(By.className("button")).submit();

        //Coockie просмотр
        WebElement test11 = driver.findElement(By.name("firstname"));

        //********

        //берём с сайта куку с названием TestingChallenge
        String cookie = driver.manage().getCookieNamed("TestingChallenge").getValue();
        //regex уровнение
        Pattern pattern = Pattern.compile("(?<=Add_).*(?=_in)");
        Matcher matcher = pattern.matcher(cookie);
        // .find() булевое значение
        matcher.find();
        //.group() выводит значение
        test11.sendKeys(matcher.group());
        driver.findElement(By.className("button")).submit();

        //*********





        // находим эллемент кол.проверок
        WebElement CheckFounds = driver.findElement(By.className("values-tested"));


        // Проверка 12 тестов = 12 проверкам
        Assert.assertEquals("12",CheckFounds.getText());
        System.out.println(CheckFounds);




    }

}
