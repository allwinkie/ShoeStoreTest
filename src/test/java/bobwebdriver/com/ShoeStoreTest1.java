package bobwebdriver.com;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allwinkie on 2/18/16.
 * Manheim test
 */
public class ShoeStoreTest1 {
    static final Logger logger = Logger.getLogger(ShoeStoreTest1.class);

    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{ShoeStoreTest1.class});
        testng.addListener(tla);
        testng.run();
    }

    @Test
    public void initiateWebDriver() {
        final Logger logger = Logger.getLogger(ShoeStoreTest1.class);
        BasicConfigurator.configure();
        AcceptanceStoryOne();
    }

    private void AcceptanceStoryOne() {

        /**
         * Created by allwinkie on 2/18/16.
         * testplan Accptance Criteria 1
         * 1) have firefox open home page
         * 2) open month
         * 3) check if there are any shoes - if not assert error
         * 4)check each shoe for text,image,name,brand - if not assert error
         * 5) go through all 12 months - repeat steps 2,3,4
         */

        String monthsItreation = "";
        WebDriver firefox;
        firefox = new FirefoxDriver();

        List<String> months = getMonths();

        String baseUrl = "http://shoestore-manheim.rhcloud.com";
        String loopUrl = "";
        for (int i = 0; i < months.size(); i++) {
            monthsItreation = months.get(i);
            loopUrl = baseUrl + monthsItreation;
            firefox.navigate().to(loopUrl);
            firefox.navigate().to(loopUrl);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int iColCount = 0;
            List<WebElement> iColumns = firefox.findElements(By.xpath("/html/body/ul/li[*]/div/table/tbody/tr[1]"));

            iColCount = iColumns.size();

            checkAssertInt(monthsItreation, iColCount);
            WebElement tBrand = null, tName = null, tPrice = null, tDescription = null, tReleaseMonth = null, tImgUrl = null;
            String Brand, Name, Price, Description, ReleaseMonth, ImgUrl;


            for (int outside = 1; outside <= iColCount; outside++) {


                tBrand = firefox.findElement(By.xpath("/html/body/ul/li[" + outside + "]/div/table/tbody/tr[1]/td[2]"));
                tName = firefox.findElement(By.xpath("/html/body/ul/li[" + outside + "]/div/table/tbody/tr[2]/td[2]"));
                tPrice = firefox.findElement(By.xpath("/html/body/ul/li[" + outside + "]/div/table/tbody/tr[3]/td[2]"));
                tDescription = firefox.findElement(By.xpath("/html/body/ul/li[" + outside + "]/div/table/tbody/tr[4]/td[2]"));
                tReleaseMonth = firefox.findElement(By.xpath("/html/body/ul/li[" + outside + "]/div/table/tbody/tr[5]/td[2]"));


                tImgUrl = firefox.findElement(By.xpath("/html/body/ul/li[" + outside + "]/div/table/tbody/tr[6]/td/img"));

                Brand = tBrand.getText();
                Name = tName.getText();
                Price = tPrice.getText();
                Description = tDescription.getText();
                ReleaseMonth = tReleaseMonth.getText();
                ImgUrl = tImgUrl.getAttribute("src").toString();


                checkAssertStringsAreNull(monthsItreation, Brand, "Brand");
                checkAssertStringsAreNull(monthsItreation, Name, "Name");
                checkAssertStringsAreNull(monthsItreation, Price, "Price");
                checkAssertStringsAreNull(monthsItreation, Description, "Description");
                checkAssertStringsAreNull(monthsItreation, ImgUrl, "Image");
                checkAssertStringsAreNull(monthsItreation, ReleaseMonth, "Release Month");

            }

        }
        firefox.close();
    }

    private void checkAssertInt(String months, int iColCount) {

        try {
            Assert.assertTrue(iColCount > 0);


        } catch (Error e) {
            //   System.out.println(" shoes are missing in " + months);
            //Assert.fail(" shoes are missing in " + months);
            logger.error(" shoes are missing in " + months);
            e.printStackTrace();
            //     logger.error(" stack trace",e);
        }
    }

    private void checkAssertStringsAreNull(String months, String check, String Name) {
        try {
            //  Assert.(check);
            Assert.assertEquals(false, check.contains("null"));
        } catch (Exception e) {
            //       System.out.println(Name + " is missing " + months);
            logger.error(Name + " is missing " + months);
            //      e.printStackTrace();
            logger.error(" stack trace ", e);
        }
    }

    private List<String> getMonths() {
        List<String> months = new ArrayList<String>();
        months.add("/months/january");
        months.add("/months/february");
        months.add("/months/march");
        months.add("/months/april");
        months.add("/months/may");
        months.add("/months/june");
        months.add("/months/july");
        months.add("/months/august");
        months.add("/months/september");
        months.add("/months/october");
        months.add("/months/november");
        months.add("/months/december");
        return months;
    }
}