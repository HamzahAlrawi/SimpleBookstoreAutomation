package ham.pom;

import ham.base.Base;
import org.openqa.selenium.By;

public class HomePage {

    private By homeDescription = By.cssSelector(".col-sm-9");
    private By homeTab = By.linkText("Home");
    private By booksTab = By.linkText("Books");
    private By authorsTab = By.linkText("Authors");




    public String getHomeDescriptionText() {
        System.out.println(Base.driver.findElement(homeDescription).getText());
        return Base.driver.findElement(homeDescription).getText();
    }

    public void navigateToBooks(){
        Base.driver.findElement(booksTab).click();
    }

    public void navigateToAuthors(){
        Base.driver.findElement(authorsTab).click();
    }
}
