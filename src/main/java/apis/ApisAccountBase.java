package apis;

import com.shaft.driver.SHAFT;

public class ApisAccountBase {

    /**
    Variables
    **/
    private SHAFT.API api;

    /**
    Constructor
    **/
    public ApisAccountBase (SHAFT.API api) {this.api = api;}

    /**
    Base URL
    **/
    public static String ApisBaseUrl = System.getProperty("baseUrl")+ "/api";

    /**
    Status Codes
    **/
    public static final int SUCCESS = 200;
}
