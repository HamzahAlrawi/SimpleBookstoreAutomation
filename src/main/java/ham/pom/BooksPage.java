package ham.pom;
import ham.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class BooksPage {
    private By editFirstBookButton = By.linkText("Edit");
    private By deleteFirstBookButton = By.linkText("Delete");
    private By createBookButton = By.linkText("Create Book");

    private By bookTitle = By.id("title");
    private By bookYear = By.id("year");
    private By bookSubmit = By.cssSelector(".btn-success");

    //tr:nth-child(1) > td:nth-child(1)

    public StringBuilder listFirstFiveBooks() {
        StringBuilder res = new StringBuilder();
        //Go over the title and year of each book
        for (int i = 1; i <=5; i++){
            for (int j = 1; j<=2; j++) {
                res.append(Base.driver.findElement(By.cssSelector("tr:nth-child(" + i + ") > td:nth-child(" + j + ")")).getText());
            }
            res.append("\n");
        }
        return res;
    }

    public String getBookTitleByIndex(int index) {
        return Base.driver.findElement(By.cssSelector("tr:nth-child(" + index + ") > td:nth-child(1)")).getText();
    }

    public void editFirstBook(String title, String year){
        Base.driver.findElement(editFirstBookButton).click();

        //Clear existing data
        Base.driver.findElement(bookTitle).clear();
        Base.driver.findElement(bookYear).clear();

        //Input data to fields
        Base.driver.findElement(bookTitle).sendKeys(title);
        Base.driver.findElement(bookYear).sendKeys(year);

        //Submit
        Base.driver.findElement(bookSubmit).click();
    }

    public void createBook(String title, String year){
        Base.driver.findElement(createBookButton).click();

        //Clear existing data if any
        Base.driver.findElement(bookTitle).clear();
        Base.driver.findElement(bookYear).clear();

        //Input data
        Base.driver.findElement(bookTitle).sendKeys(title);
        Base.driver.findElement(bookYear).sendKeys(year);

        //Submit
        Base.driver.findElement(bookSubmit).click();

    }
    public void deleteBook(){
        Base.driver.findElement(deleteFirstBookButton).click();
    }

    public Boolean verifyBookExists (String title){
        List<WebElement> elements = Base.driver.findElements(By.xpath("//td[contains(.,'" + title + "')]"));
        if (elements.size() == 1) return true;

        return false;
    }
}
