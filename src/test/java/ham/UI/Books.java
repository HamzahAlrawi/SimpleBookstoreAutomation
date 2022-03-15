package ham.UI;

import ham.base.Base;
import ham.pom.AuthorsPage;
import ham.pom.BooksPage;
import ham.pom.HomePage;
import ham.util.DataHelper;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Books {
    HomePage homePage = new HomePage();
    Base base = new Base();
    AuthorsPage authorsPage = new AuthorsPage();
    BooksPage booksPage = new BooksPage();
    DataHelper util = new DataHelper();


    @BeforeTest
    public void init(){
        base.initDriver();
        homePage.navigateToBooks();
    }

    @AfterTest
    public void quit() {
        base.quitDriver();
    }

    @Test
    public void deleteBook() {
        String oldBookName = booksPage.getBookTitleByIndex(1);
        booksPage.deleteBook();
        Assert.assertNotEquals(oldBookName, booksPage.getBookTitleByIndex(1));
    }

    @Test
    public void createBook() {

        String year = Integer.toString(util.getRandomNumber(1000,2020));
        String title = util.getBookTitle();

        booksPage.createBook(title,year);
        Assert.assertTrue(booksPage.verifyBookExists(title));

    }

    @Test
    public void editBookTitle() {
        String title = util.getBookTitle();
        String year = Integer.toString(util.getRandomNumber(1000,2020));
        booksPage.editFirstBook(title, year);
        Assert.assertTrue(booksPage.verifyBookExists(title));
    }



}
