package by.mts.core;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Optional;

import static by.mts.core.BasePage.driver;


public class TestListener implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        driver.close();
        driver.quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        driver.close();
        driver.quit();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        driver.close();
        driver.quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment("screenshot", "imge/file", ".png",((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        driver.close();
        driver.quit();
    }
}
