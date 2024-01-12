package fi.tuni.prog3.weatherapp.helpclasses;

import java.util.Map;

/**
 * A class representing geographic location coordinates obtained 
 * from location data.
 * It contains various attributes such as name, local names, latitude, 
 * longitude, country, and state.
 * This class is used to store and manage geographic location details.
 *
 * 
 */
public class GeoLocToCoord {

    /**
     * The name of the geographic location.
     */
    public String name = null;

    /**
     * Map of local names corresponding to the geographic location.
     */
    public Map<String, String> local_names = null;

    /**
     * The latitude coordinate of the location.
     */
    public String lat = null;

    /**
     * The longitude coordinate of the location.
     */
    public String lon = null;

    /**
     * The country associated with the geographic location.
     */
    public String country = null;

    /**
     * The state associated with the geographic location.
     */
    public String state = null;

    /**
     * Default constructor for the GeoLocToCoord class.
     */
    public GeoLocToCoord() {
    }
}
