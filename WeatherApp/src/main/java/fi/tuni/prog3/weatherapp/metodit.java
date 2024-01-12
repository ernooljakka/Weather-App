package fi.tuni.prog3.weatherapp;

import com.google.gson.*;
import fi.tuni.prog3.weatherapp.helpclasses.GeoLocToCoord;
import fi.tuni.prog3.weatherapp.helpclasses.WeatherData;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Class implementing iAPI interface, 
 * providing methods to interact with OpenWeatherMap API.
 */
class metodit implements iAPI{
    String APIkey = "77198cacb67819e17efda6297827a0cf";
    
    /**
     * Reads data from a given URL and parses it into a JsonObject using Gson.
     * 
     * @param url The URL from which data is to be read.
     * @return A JsonObject containing the parsed data retrieved from the URL.
     * @throws IOException If an I/O error occurs while reading from the URL.
     */
    public JsonObject URLreader(String url) throws IOException {
        String sURL = url;
        URL asurl = new URL(sURL);
        URLConnection request = asurl.openConnection();
        request.connect();

        // JSONIKSI GSONilla
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
        if(root instanceof JsonArray){
            JsonArray rootobj = root.getAsJsonArray();
            return (JsonObject) rootobj.get(0);
        } else {
            JsonObject rootobj = root.getAsJsonObject();
            return (rootobj);
        }
    }
    /**
     * Fetches latitude and longitude coordinates corresponding 
     * to the provided location name
     * using the OpenWeatherMap API's location lookup feature.
     * 
     * @param loc The name of the location for 
     * which coordinates are to be retrieved.
     * @return A string containing the latitude and longitude coordinates ,
     * separated by a comma (lat, lon),
     * or null if an error occurs during the API request or 
     * parsing of the response.
     * @throws IOException If an I/O error occurs while making the API request.
     */
    public String lookUpLocation(String loc) throws IOException {
        GeoLocToCoord loctocoord;
        try {
            String location = "http://api.openweathermap.org/geo/1.0/direct?q=" + loc + "&limit=1&appid=" + APIkey;
            Gson gson = new Gson();
            loctocoord = gson.fromJson(URLreader(location), GeoLocToCoord.class);
        } catch (Exception e) {
            return null;
        }
        return loctocoord.lat + "," + loctocoord.lon;
    }
    // Muutin getCurrentWeatherin palauttamaan Voidin, ja se tallentaa CurrentWeatherin API responsen
    // kaikki tiedot WeatherData classiin. Ne voi hakea sieltä gettereillä.
    /**
     * Retrieves current weather data for a specific latitude and longitude
     * using the OpenWeatherMap API.
     * 
     * @param lat The latitude of the location for 
     * which weather data is requested.
     * @param lon The longitude of the location for 
     * which weather data is requested.
     * @return The WeatherData object containing current weather information,
     *         or null if an error occurs during the API request or 
     *         response parsing.
     * @throws IOException If an I/O error occurs while making the API request.
     */
    public WeatherData getCurrentWeather(double lat, double lon) throws IOException {
        String curweather = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid="+APIkey+"&units=metric";
        // Gson tallentaa jsonin WeatherData luokkaan.
        Gson gson1 = new Gson();
        WeatherData weatherdata = gson1.fromJson(URLreader(curweather), WeatherData.class);
        // paluu on helpclasses->weather->description atm.
        //System.out.println(weatherdata.wind.get("speed"));
        //return weatherdata.weather[0].description;
        return weatherdata;
    }
    /**
    * Retrieves a 5-day weather forecast for a specific latitude and longitude
    * using the OpenWeatherMap API.
    * 
    * @param lat The latitude of the location 
    * for which the forecast is requested.
    * @param lon The longitude of the location 
    * for which the forecast is requested.
    * @return A string representation of the 5-day weather forecast data,
    *         or null if an error occurs during the API request or 
    *         response parsing.
    */
    public String getForecast(double lat, double lon){
        String forecast = "api.openweathermap.org/data/2.5/forecast?lat="+lat+"&lon="+lon+"&appid="+APIkey;
        JsonObject jsonObject = JsonParser.parseString(forecast).getAsJsonObject();
        // haetaan 5päivän ennusteesta list osa jsonarrayna
        final JsonArray asjson = jsonObject.getAsJsonArray("list");
        System.out.println("5 päivän ennuste litkana: " + asjson);
        // 5 päivän ennusteet t
        List<JsonObject> aslist = new ArrayList<>();
        for (JsonElement element : asjson) {
            aslist.add(element.getAsJsonObject());
        }
        // pitää tää returni laittaa Ui:lle sopivaan muotoon vielä.
        return aslist.toString();

    }
    
  
}
