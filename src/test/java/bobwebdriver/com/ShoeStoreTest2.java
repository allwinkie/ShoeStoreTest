package bobwebdriver.com;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by allwinkie on 2/20/16.
 */
public class ShoeStoreTest2 {
    @Test
    public void initiateWebDriver() {
        AcceptanceStoryTwo();

    }

    private void checkAssertStringsAreNull(String months, String check, String Name) {
        try {
            //  Assert.(check);
            assertEquals(false, check.contains("null"));
        } catch (Exception e) {
            System.out.println(Name + " is missing " + months);
            e.printStackTrace();
        }
    }

    private List<String> getUrlAcceptanceTwo() {
        // List<String> getLinks = null;
        List<String> getLinks = new ArrayList<String>();

        getLinks.add("http://shoestore-manheim.rhcloud.com/");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/january");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/february");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/march");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/april");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/may");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/june");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/july");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/august");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/september");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/october");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/november");
        getLinks.add("http://shoestore-manheim.rhcloud.com/months/december");
        getLinks.add("http://shoestore-manheim.rhcloud.com/shoes");
        getLinks.add("http://shoestore-manheim.rhcloud.com/definition");
        getLinks.add("http://shoestore-manheim.rhcloud.com/issues/new");
        getLinks.add("http://shoestore-manheim.rhcloud.com/issues");

        return getLinks;
    }

    private void AcceptanceStoryTwo() {
        /**
         * Created by allwinkie on 2/18/16.
         * testplan Accptance Criteria
         * 1) have firefox open each page with the email entry
         * 2) add email
         * 3) check to see if the flash message is sent- if not assert error
         *
         */

        WebDriver firefox;
        firefox = new FirefoxDriver();

        List<String> getLinks = getUrlAcceptanceTwo();
        String linkInUse = "";
        WebElement tFlashMessage;
        String flashMessage = "";

        for (int i = 0; i < getLinks.size(); i++) {
            linkInUse = getLinks.get(i);


            firefox.navigate().to(linkInUse);
            firefox.navigate().to(linkInUse);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            // enter email
            WebElement email = firefox.findElement(By.id("remind_email_input"));

            email.sendKeys("felisnavidad@gmail.com");
            firefox.findElement(By.xpath("/html/body/header/form[1]/div/input[2]")).click();
            tFlashMessage = firefox.findElement(By.xpath("/html/body/div[4]/div"));
            // check to see if thankyou is posted
            flashMessage = tFlashMessage.getText();
            checkAssertStringsAreNull("", flashMessage, "flashMessage");

            //refresh

            firefox.navigate().refresh();

        }

        firefox.close();
    }


}
