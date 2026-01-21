package test;

import Browser.browser;
import Page.GooglePageActions;

import java.util.List;

public class GoogleTest {

    public static void main(String[] args) {

        browser.launchBrowser();
        browser.openUrl("https://www.google.com");

        GooglePageActions actions = new GooglePageActions();
        //actions.enterSearchText("selenium");

        System.out.println(" Suggestions using @FindAll:");
        List<String> list1 = actions.getSuggestionsUsingFindAll();
        list1.forEach(System.out::println);

        System.out.println("\nSuggestions using @FindBys:");
        List<String> list2 = actions.getSuggestionsUsingFindBys();
        list2.forEach(System.out::println);
        
        actions.enterSearchText("selenium");
        actions.clickSuggestion("selenium interview questions");

//        actions.waitOnResultsPage();
        actions.stayOnPage(10);   // stay for 10 seconds

//        browser.closeBrowser();

    }
}