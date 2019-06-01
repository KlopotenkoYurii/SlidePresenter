package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestsSlidePresenter extends TestRunner {
    private static final String ALPHA_NUMERIC_STRING = "0123456789abcdefghijklmnopqrstuvxyz";

    @Test
    public void test1() throws InterruptedException {
        driver.get(Url.SlidePresenterURL);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@title='Close']")).click();
        driver.findElement(By.xpath("//a[2]/span")).click();
    }

    //auto-generate email
    @Test
    private static String generateString(int size) {
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            sb.append(ALPHA_NUMERIC_STRING.charAt(new Random().nextInt(ALPHA_NUMERIC_STRING.length())));
        }
        return sb.toString();
    }

    private static String getRandomEmail(int size) {
        return generateString(size) + "@mailinator.com";
    }

    @DataProvider(name = "TestDP")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {getRandomEmail(6), ""},
        };
        return data;
    }

    @Test(dataProvider = "TestDP")
    public void test3(String name, String xz) throws InterruptedException {
        driver.getCurrentUrl();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(name);

        //copy value from block email
        String textEmail = driver.findElement(By.xpath("//input[@name='email']")).getAttribute("Value");

        //split email

        String[] parts = textEmail.split("@");
        String part1 = parts[0];
        String part2 = parts[1];


//        String Str = new String(textEmail);
//                for (String qwer : Str.split("@")){
//        System.out.println(qwer);}

//        //split email
//            String[] qwe = mail.split("[@]");
//        for (int j = 0; j <= qwe.length - 1; j++){
//            System.out.println("OurMail_:" + qwe);}


        Thread.sleep(1000);
        driver.findElement(By.xpath("//span/div/i")).click();
        driver.findElement(By.xpath("//span[contains(.,'Sign up for free')]")).click();

        //open new tab in browser
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(Url.MalinatorURL);

        //send email to form
        driver.findElement(By.className("form-control")).sendKeys(part1);
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(".hidden-sm .btn")).click();
    }

    @Test
    public void test4() throws InterruptedException {
        driver.getCurrentUrl();
        driver.findElement(By.xpath("//td[contains(.,'SlidePresenter: activation of your account and first steps')]")).click();
        Thread.sleep(2000);
    }

//    @Test
//    public void test5() throws InterruptedException {
//        driver.getCurrentUrl();
//        Thread.sleep(3000);
//        //int size = driver.findElements(By.tagName("iframe")).size();
//        driver.switchTo().frame("aswift_0");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//a[contains(text(),'Activate your account and set up your password')]")).click();
//        driver.switchTo().defaultContent()
//    }

        @Test
                public void test6()throws InterruptedException {

            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2));
            driver.get(Url.baseUrl);
        }
        @Test
            public void test7(){
        driver.getCurrentUrl();
        driver.findElement(By.xpath(Locators.FirstName)).sendKeys("Yurii");
        driver.findElement(By.xpath(Locators.LAST_NAME)).sendKeys("Devich");
        WebElement dropList = driver.findElement(By.cssSelector(".jss274"));
            List<WebElement> listbox = dropList.findElements(By.tagName("li"));
            Select privStud = new Select(driver.findElement(By.xpath(Locators.CompanySize)));
        driver.findElement(By.xpath(Locators.Password)).sendKeys("1234567890W");
            driver.findElement(By.xpath(Locators.ConfirmPassword)).sendKeys("1234567890W");

        }

//            ((JavascriptExecutor) driver).executeScript("window.open()");
//        Thread.sleep(1000);
//            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(1));
//            driver.get("https://app.slidepresenter.com/#/sign-in?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6ImRlYTA2YjA4LWNkMmYtNGI5Mi1iZjllLTlmM2M0MTkwMjM3OCIsImlzcyI6InNsaWRlcHJlc2VudGVyLmNvbSIsImV4cCI6MTU2MTk3MTkwMywidXNlcklkIjoiNjY3ZTRmNGQtNThjNi00ZTAxLTk0MWQtMzllNmU4NmY2MTEzIiwiaWF0IjoxNTU5Mzc5OTAzLCJlbWFpbCI6ImNneW14aEBtYWlsaW5hdG9yLmNvbSJ9.9W1d_tpTOrxLnGhZ3G1rGurBTCi-O_mqPe5_h2-VTWk");


//            String childtFrame = driver.getWindowHandle();
//        driver.switchTo().window(childtFrame);

//        //driver.findElement(By.xpath("//a[contains(text(),'Activate your account and set up your password')]")).click();
//    }}

//    @Test
//    public void test5()throws InterruptedException{
//            driver.getWindowHandle();
//        driver.switchTo().window();
//            Thread.sleep(2000);
//          //  driver.findElement(By.cssSelector("p:nth-child(3) > a"));
//        //WebElement element = driver.findElement(By.cssSelector("p:nth-child(3) > a"));
//        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Activate your account and set up your password')]"));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//
    }
