package Page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class GooglePage {

    //  @FindBy – single element
    @FindBy(name = "q")
    public WebElement searchBox;

    //  @FindBy – parent element (used for wait/sync)
    @FindBy(xpath = "//ul[@role='listbox']")
    public WebElement suggestionBox;

    //  @FindAll – OR condition
    // Finds suggestions using multiple locators
    @FindAll({
        @FindBy(xpath = "//ul[@role='listbox']//li//span"),
        @FindBy(css = "li.sbct span")
    })
    public List<WebElement> suggestions_OR;

    //  @FindBys – AND condition
    // First ul → then li → then span
    @FindBys({
        @FindBy(xpath = "//ul[@role='listbox']"),
        @FindBy(tagName = "li"),
        @FindBy(tagName = "span")
    })
    @CacheLookup
    public List<WebElement> suggestions_AND;
}