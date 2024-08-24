package api;

import org.testng.annotations.BeforeSuite;
import rest_api.BaseRestAssuredConfig;

public class BaseApiTest {

    @BeforeSuite
    public void initRestAssured(){
        BaseRestAssuredConfig.init();
    }
}
