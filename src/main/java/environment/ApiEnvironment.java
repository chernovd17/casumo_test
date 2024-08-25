package environment;

import java.io.IOException;
import java.util.Properties;

public class ApiEnvironment{

    private Properties defProp;
    private static ApiEnvironment env;

    protected ApiEnvironment() {
        defProp = new Properties();
        try {
            defProp.load(ApiEnvironment.class.getClassLoader().getResourceAsStream("api.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ApiEnvironment get() {
        if (env == null) {
            env = new ApiEnvironment();
        }
        return env;
    }

    public String getProperty(String propName) {
        String optionalValue = System.getProperty(propName);
        if(optionalValue != null) {
            return optionalValue;//returns -Dproperty
        } else
            return defProp.getProperty(propName, System.getProperty(propName));//returns default from property files
    }

    public static int getPort() {
        return Integer.parseInt(get().getProperty("port"));
    }

    public static int getRequestTimeout() {
        return Integer.parseInt(get().getProperty("timeout_1_minute"));
    }
}
