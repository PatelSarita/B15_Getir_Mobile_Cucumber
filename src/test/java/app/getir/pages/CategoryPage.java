package app.getir.pages;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends BasePage{
    @FindBy(xpath = "//android.widget.TextView[@text='Dondurma']")
    public AndroidElement categoryDondurma;
    @FindBy(id = "com.getir.casestudy.dev:id/ga_toolbar_getir10GABasketButton")
    public AndroidElement basketBtn;
    @FindBy(className = "android.widget.TextView")
    public List<AndroidElement> categoryList;
    @FindBy(id = "com.getir.casestudy.dev:id/btnAdd")
    public AndroidElement addBtn;

    public void goToCategory(String categoryName){
        driver.findElement(By.xpath("//*[@text='"+categoryName+"']")).click();
    }
    public void addItem(int num){
        if (num>=1){
            for (int i = 1; i < num; i++) {
                waitUntil(addBtn).click();
            }
        }
    }
}