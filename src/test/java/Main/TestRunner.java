package Main;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestRunner {
    ChromeDriver driver;

    @BeforeSuite
    private void beforeSuite() {
        System.out.println("Before_StartSuite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforClass_Start");
        String property = System.getProperty("user.dir") + "/ChromeDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", property);
        driver = new ChromeDriver();
                //driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
                //driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
                //driver.manage().window().maximize();
                driver.manage().deleteAllCookies();

    }
   @BeforeMethod
   public void beforeMethod(){
        System.out.println("Before_MethodStart");
   }

   @AfterMethod
   public void afterMethod(){
        System.out.println("AfterMethod_Close");
   }


    @AfterClass
    public void afterClass() throws InterruptedException {
        System.out.println("AfterClass_Close");
        //Thread.sleep(2000);
        //driver.quit();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite_Close");
    }
}