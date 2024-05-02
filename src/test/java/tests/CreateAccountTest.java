package tests;

import apis.APisCreateAccount;
import apis.ApisAccountBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest {
    private SHAFT.API api;
    private SHAFT.TestData.JSON testData;
    private String currentTime;
    @Test
    public void CreatAccountTestApi() {

        api = new SHAFT.API(ApisAccountBase.ApisBaseUrl);
        currentTime = String.valueOf(System.currentTimeMillis());
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/AccountData.json");

        new APisCreateAccount(api)
                .createUserAccount(testData.getTestData("UserName"), testData.getTestData("UserMail") + currentTime + "@gmail.com",
                        testData.getTestData("UserPassword"),
                        testData.getTestData("Gender"),
                        testData.getTestData("UserFirstName"),
                        testData.getTestData("UserLastName"),
                        testData.getTestData( "Zipcode"),
                        testData.getTestData("UserState"),
                        testData.getTestData( "UserCity"),
                        testData.getTestData( "UserMobile"))
                .validateUserCreatedAccount()
                .deleteAccount(testData.getTestData("UserMail") + currentTime + "@gmail.com",
                        testData.getTestData("UserName" ));
    }
    //////////////////// Configurations \\\\\\\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/AccountData.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        api = new SHAFT.API(ApisAccountBase.ApisBaseUrl);
        currentTime = String.valueOf(System.currentTimeMillis());
    }



}

