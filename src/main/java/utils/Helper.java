package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;

public class Helper extends DefaultFieldDecorator {

    private WebDriver driver;

    public Helper(SearchContext searchContext, WebDriver driver) {
        super(new DefaultElementLocatorFactory(searchContext));
        this.driver = driver;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Object result = super.decorate(loader, field);
        if (result instanceof WebElement) {
            return Proxy.newProxyInstance(
                loader,
                new Class[]{WebElement.class},
                (proxy, method, args) -> {
                    WebElement element = (WebElement) result;
                    highlightElement(element);
                    return method.invoke(element, args);
                }
            );
        }
        return result;
    }

    private void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
    
    
    public static String generateRandomEmail() {
        String prefix = "Automation_user";
        String domain = "@yopmail.com";	
        String randomPart = String.valueOf(System.currentTimeMillis()); // or use UUID
        return prefix + randomPart + domain;
    }
    


}
