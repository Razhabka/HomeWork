import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class SetUpDriver {

    private static WebDriver driver;

    public static WebDriver setUp(){
        WebDriverManager.chromedriver().setup();
        return driver;
    }

}
