package base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class RestAPI {


    protected String apiKey;
    protected String apiSecretKey;
    protected String accessToken;
    protected String accessTokenSecret;
    protected Properties properties;
    protected InputStream inputStream;
    protected String baseUrl;
    protected String apiVersion = "1.1";
    protected String apiVersion2 = "2";
    protected String uploadImageBaseUrl;

    public RestAPI() {

//        try {
//            this.baseUrl = "https://api.twitter.com/"+this.apiVersion;
//        }catch (Exception exception){
//            System.out.println("baseURL is wrong");
//        }try {
//            this.baseUrl = "https://api.twitter.com/"+this.apiVersion2;
//        }catch (Exception exception){
//            System.out.println("baseURL is wrong");
//        }
        //https://api.twitter.com/1.1/statuses/update.json
        this.uploadImageBaseUrl = "https://upload.twitter.com/"+ this.apiVersion;

        this.baseUrl = "https://api.twitter.com/" + this.apiVersion;

        this.properties = new Properties();
        inputStream = null;
        try {
            // Path of the Secret.properties file
            this.inputStream = new FileInputStream("../Twitter/secret.properties");
            this.properties.load(this.inputStream);
            this.apiKey = this.properties.getProperty("apiKey");
            this.apiSecretKey = this.properties.getProperty("apiSecretKey");
            this.accessToken = this.properties.getProperty("accessToken");
            this.accessTokenSecret = this.properties.getProperty("accessTokenSecret");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not load Properly");
        } finally {
            try {
                this.inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


}
