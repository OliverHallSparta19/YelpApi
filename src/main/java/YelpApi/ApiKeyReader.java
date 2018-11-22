package YelpApi;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;


public class ApiKeyReader {

    private String apiKey;

    public String readKey() {

        Properties appProps = new Properties();
        try {
            appProps.load(new FileReader("resources/apikey/apikey.properties"));
            apiKey = appProps.getProperty("api_key");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }
}
