package YelpApi;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Map;

import static org.apache.http.client.methods.HttpGet.*;

public class YelpHttpManager {

    private String uri;
    private String url;
    private String apiKey;
    private String result;
    private JSONObject myObject;

    public YelpHttpManager(){
        ApiKeyReader keyReader = new ApiKeyReader();
        apiKey = "Bearer " + keyReader.readKey();
        uri = "https://api.yelp.com/v3";
    }

    public JSONObject getSearch(){

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet requestSearch = new HttpGet(uri + "/businesses/north-india-restaurant-san-francisco" );
            requestSearch.addHeader("Authorization",apiKey);
            CloseableHttpResponse response = httpClient.execute(requestSearch);
            //result = EntityUtils.toString(response.getEntity());
            JSONObject myObject = new JSONObject(response);
            return myObject;
        } catch (IOException e) {
            e.printStackTrace();
        }
return null;
    }

//    public void nasaRequestSuccessful(){
//        given().when().get(uri+basePath).then().statusCode(200).body("photos[1].sol", equalTo(1000));
//
//    }



}
