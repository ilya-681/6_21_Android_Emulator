package helpers;

import config.App;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class BrowserStack {
   /* public static URL getBrowserstackUrl() {
        try {
            return new URL("https://" + App.config.browserStackUsername() + ":" +
                    App.config.browserStackPassword() + "@hub-cloud.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static String getVideoUrl(String sessionId) {
        String video_url = given()
                .auth().basic(App.config.browserStackUsername(), App.config.browserStackPassword())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("automation_session.video_url");

        System.out.println("video_url: " + video_url);
        return video_url;
    }

    public static String getBSPublicLink(String sessionId){
        String publicUrl = given()
                .auth().basic(App.config.browserStackUsername(), App.config.browserStackPassword())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("automation_session.public_url");

        System.out.println("bs_public_url: " + publicUrl);
        System.out.println("bs_build_url: " + publicUrl.split("/sessions/")[0]);
        return publicUrl;
    }
}
