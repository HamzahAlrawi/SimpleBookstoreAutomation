package ham.UI;

import ham.base.Base;
import ham.pom.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Home {
    Base base = new Base();
    @BeforeTest
    public void init(){
        base.initDriver();
    }

    @AfterTest
    public void quit() {
        base.quitDriver();
    }

    HomePage home = new HomePage();
    @Test
    public void verifyHomePageText(){
       String desc = home.getHomeDescriptionText();
        Assert.assertEquals(desc, "Hello Test Automation Engineer!!");
    }
}
