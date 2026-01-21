package Page;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Browser.browser;

public class GooglePageActions extends browser {

    GooglePage page;
    
    public void clickSuggestion(String expectedText) {

        wait.until(ExpectedConditions.visibilityOf(page.suggestionBox));

        for (WebElement element : page.suggestions_OR) {

            String actualText = element.getText();

            if (actualText.equalsIgnoreCase(expectedText)) {
                element.click();
                break;
            }
        }
    }
    public void stayOnPage(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public GooglePageActions() {
        page = PageFactory.initElements(driver, GooglePage.class);
    }

    public void enterSearchText(String text) {
        page.searchBox.sendKeys(text);
        wait.until(ExpectedConditions.visibilityOf(page.suggestionBox));
    }

    //  Using @FindAll
    public List<String> getSuggestionsUsingFindAll() {
        List<String> list = new ArrayList<>();
        for (var element : page.suggestions_OR) {
            String value = element.getText();
            if (!value.isEmpty()) {
                list.add(value);
            }
        }
        return list;
    }

    //  Using @FindBys
    public List<String> getSuggestionsUsingFindBys() {
        List<String> list = new ArrayList<>();
        for (var element : page.suggestions_AND) {
            String value = element.getText();
            if (!value.isEmpty()) {
                list.add(value);
            }
        }
        return list;
    }
}