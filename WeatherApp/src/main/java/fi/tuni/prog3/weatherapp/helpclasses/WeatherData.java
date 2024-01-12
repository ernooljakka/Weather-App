package fi.tuni.prog3.weatherapp.helpclasses;

import java.util.Map;

/**
 * A class representing weather data obtained from an API response.
 * It encapsulates various weather-related attributes such as 
 * location information, weather conditions,
 * atmospheric details, and additional metadata.
 * This class is used to store and manage weather-related data 
 * received from an API response.
 *
 * 
 */
public class WeatherData {

    /**
     * Represents the name associated with a location.
     */
    public String name = null;

    /**
     * Represents the coordinates of a location.
     * The map contains latitude and longitude values.
     */
    public Map<String, String> coord = null;

    /**
     * Represents an array of weather information for a specific location.
     */
    public Weather[] weather = null;

    /**
     * Represents the data source of weather information.
     * Typically denotes the data provider used for fetching weather details.
     */
    public String base = null;

    /**
     * Represents the main weather-related parameters such as 
     * temperature, humidity, etc.
     * The map contains key-value pairs of weather attributes 
     * and their respective values.
     */
    public Map<String, String> main = null;

    /**
     * Represents the visibility in meters at the location.
     */
    public String visibility = null;

    /**
     * Represents wind-related information such as speed, direction, etc.
     * The map contains key-value pairs describing wind attributes.
     */
    public Map<String, String> wind = null;

    /**
     * Represents rain-related data.
     * The map contains information about precipitation, if available.
     */
    public Map<String, String> rain = null;

    /**
     * Represents cloud-related information.
     * The map contains data about cloud coverage, if available.
     */
    public Map<String, String> clouds = null;

    /**
     * Represents system-related data for the weather information.
     * The map contains various system-related attributes.
     */
    public Map<String, String> sys = null;

    /**
     * Represents the time of data calculation, measured in Unix time.
     */
    public String dt = null;

    /**
     * Represents the timezone offset in seconds 
     * from UTC (Coordinated Universal Time).
     */
    public String timezone = null;

    /**
     * Represents the ID of the city or location.
     */
    public String id = null;

    /**
     * Represents an alternative name of the location (if available).
     */
    public String name2 = null;

    /**
     * Represents the internal parameter indicating the status of 
     * the API response.
     * It typically holds a numeric code indicating the response status.
     */
    public String cod = null;

    /**
     * Represents a human-readable message related to the API response.
     * It may contain additional information or status details.
     */
    public String message = null;

    /**
     * Represents the number of data points returned in the API response.
     * It indicates the count of forecast or weather data entries received.
     */
    public String cnt = null;

    /**
     * Default constructor for the WeatherData class.
     * Initializes an instance of the WeatherData object.
     */
    public WeatherData() {
    }

    /**
     * Retrieves cloud-related information for the weather data.
     *
     * @return A map containing cloud-related attributes and 
     * their corresponding values.
     */
    public Map<String, String> getClouds() {
        return clouds;
    }

    /**
     * Retrieves the geographic coordinates for the location.
     *
     * @return A map containing latitude and longitude coordinates 
     * as key-value pairs.
     */
     public Map<String, String> getCoord() {
         return coord;
     }

    /**
     * Retrieves main weather-related information for the weather data.
     *
     * @return A map containing main weather attributes 
     * and their corresponding values.
     */
    public Map<String, String> getMain() {
        return main;
    }

    /**
     * Retrieves rain-related information for the weather data.
     *
     * @return A map containing rain-related attributes and 
     * their corresponding values.
     */
    public Map<String, String> getRain() {
        return rain;
    }

    /**
     * Retrieves system-related information for the weather data.
     *
     * @return A map containing system-related attributes 
     * and their corresponding values.
     */
    public Map<String, String> getSys() {
        return sys;
    }

    /**
     * Retrieves wind-related information for the weather data.
     *
     * @return A map containing wind-related attributes and 
     * their corresponding values.
     */
    public Map<String, String> getWind() {
        return wind;
    }

    /**
     * Retrieves the name of the location for which weather data is fetched.
     *
     * @return A string representing the name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves a message associated with the weather data.
     *
     * @return A string containing additional information or 
     * messages related to the weather data.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Retrieves an array of weather-related information for the location.
     *
     * @return An array containing weather-related details for the location.
     */
    public Weather[] getWeather() {
        return weather;
    }
    
}
