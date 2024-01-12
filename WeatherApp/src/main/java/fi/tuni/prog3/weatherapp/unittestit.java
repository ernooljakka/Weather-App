package fi.tuni.prog3.weatherapp;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fi.tuni.prog3.weatherapp.metodit;
import com.google.gson.*;
import fi.tuni.prog3.weatherapp.helpclasses.GeoLocToCoord;
import fi.tuni.prog3.weatherapp.helpclasses.WeatherData;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * A class for performing unit tests on methods related 
 * to weather data retrieval using OpenWeatherMap API.
 *
 */
public class unittestit {

    /**
     * The main method demonstrating unit test cases for fetching 
     * current weather data based on latitude and longitude,
     * looking up location information based on city names, 
     * and making API requests to fetch JSON responses.
     *
     * @param args Command-line arguments (unused).
     * @throws IOException If an error occurs during the API request handling.
     */
    public static void main(String[] args) throws IOException {


        metodit test2 = new metodit();
        System.out.println(test2.getCurrentWeather(60.1699, 24.9384));

        metodit test3 = new metodit();
        System.out.println(test3.lookUpLocation("Helsinki"));

        String sURL = "http://api.openweathermap.org/data/2.5/weather?lat="+60.1699+"&lon="+24.9384+"&appid=77198cacb67819e17efda6297827a0cf";
        String loc = "http://api.openweathermap.org/geo/1.0/direct?q=Helsinki&limit=1&appid=77198cacb67819e17efda6297827a0cf";
        URL asurl = new URL(loc);
        URLConnection request = asurl.openConnection();
        request.connect();

        // JSONIKSI GSONilla
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        if(root instanceof JsonArray){
            JsonArray rootobj = root.getAsJsonArray();
            System.out.println(rootobj.get(0));
        } else {
            JsonObject rootobj = root.getAsJsonObject();
            System.out.println(rootobj);
        }

    }
}

