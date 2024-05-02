package apis;

import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import java.util.Arrays;
import java.util.List;

public class APisCreateAccount {

    /**
     * Variable
     **/
    private SHAFT.API api;

    /**
     * Constructor
     **/
    public APisCreateAccount(SHAFT.API api) {
        this.api = api;
    }

    /**
     * Services
     **/
    private static final String createAccount = "/createAccount";
    private static final String loginAccount = "/verifyLogin";
    private static final String deleteAccount = "/deleteAccount";
    private static final String getUserByEmail = "/getUserDetailByEmail";


    /******** Create Account ********/
    /**
     * >>	Keywords
     *
     * @param username     String Value From testDataFiles AccountData.json
     * @param email        String Value From testDataFiles AccountData.json
     * @param pass         String Value From testDataFiles AccountData.json
     * @param title        String Value From testDataFiles AccountData.json
     * @param firstName    String Value From testDataFiles AccountData.json
     * @param lastName     String Value From testDataFiles AccountData.json
     * @param zipCode      String Value From testDataFiles AccountData.json
     * @param state        String Value From testDataFiles AccountData.json
     * @param city         String Value From testDataFiles AccountData.json
     * @param mobileNumber String Value From testDataFiles AccountData.json
     * @return a self-reference to be used to chain actions
     */
    @Step("API Create User Account")
    public APisCreateAccount createUserAccount(String username, String email, String pass, String title,
                                               String firstName, String lastName, String zipCode, String state, String city, String mobileNumber) {
        List<List<Object>> data = Arrays.asList(
                Arrays.asList("name", username),
                Arrays.asList("email", email),
                Arrays.asList("password", pass),
                Arrays.asList("title", title),
                Arrays.asList("birth_date", "10"),
                Arrays.asList("birth_month", "7"),
                Arrays.asList("birth_year", "1990"),
                Arrays.asList("firstname", firstName),
                Arrays.asList("lastname", lastName),
                Arrays.asList("company", "company"),
                Arrays.asList("address1", "cairo"),
                Arrays.asList("address2", "kuwait"),
                Arrays.asList("country", "country"),
                Arrays.asList("zipcode", zipCode),
                Arrays.asList("state", state),
                Arrays.asList("city", city),
                Arrays.asList("mobile_number", mobileNumber));
        api.post(createAccount)
                .setParameters(data, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)
                .setTargetStatusCode(ApisAccountBase.SUCCESS)
                .perform();
        return this;
    }

    /******** Login Account ********/
    /**
     * >>	Keywords
     *
     * @param email String Value From testDataFiles AccountData.json
     * @param pass  String Value From testDataFiles AccountData.json
     * @return a self-reference to be used to chain actions
     */
    @Step("API Log Into User Account")
    public APisCreateAccount loginAccount(String email, String pass) {
        List<List<Object>> data = Arrays.asList(
                Arrays.asList("email", email),
                Arrays.asList("password", pass));
        api.post(loginAccount)
                .setParameters(data, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)
                .setTargetStatusCode(ApisAccountBase.SUCCESS)
                .perform();
        return this;
    }
    /******** Delete Account ********/
    /**
     * >>	Keywords
     *
     * @param email    String Value From testDataFiles AccountData.json
     * @param username String Value From testDataFiles AccountData.json
     * @return a self-reference to be used to chain actions
     */
    public APisCreateAccount deleteAccount(String username, String email) {
        List<List<Object>> data = Arrays.asList(
                Arrays.asList("name", username),
                Arrays.asList("email", email));
        api.post(createAccount)
                .setParameters(data, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)
                .setTargetStatusCode(ApisAccountBase.SUCCESS)
                .perform();
        return this;
    }

    /******** Validation ********/
    @Step("Validate User Created")
    public APisCreateAccount validateUserCreatedAccount() {
        api.verifyThatResponse().extractedJsonValue("message").isEqualTo("User created!").perform();
        return this;
    }

    @Step("Validate User Login")
    public APisCreateAccount validateUserLoggedIn() {
        api.verifyThatResponse().extractedJsonValue("message").isEqualTo("User exists!").perform();
        return this;
    }

    @Step("Validate Account Deleted")
    public APisCreateAccount validateDeleteUser() {
        api.verifyThatResponse().extractedJsonValue("message").isEqualTo("Account deleted!").perform();
        return this;
    }
}
