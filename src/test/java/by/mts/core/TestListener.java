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
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment("screenshot", "imge/file", ".png",((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }
}
