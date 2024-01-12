package fi.tuni.prog3.weatherapp.helpclasses;

/**
 * A class representing weather details obtained from weather data.
 * It includes attributes such as ID, main description, detailed description, 
 * and an icon representing the weather.
 * This class is used to store and manage weather information.
 *
 * 
 */
public class Weather {

    /**
     * The ID of the weather entry.
     */
    public String id = null;

    /**
     * The main description of the weather.
     */
    public String main = null;

    /**
     * The detailed description of the weather.
     */
    public String description = null;

    /**
     * The icon representing the weather.
     */
    public String icon = null;

    /**
     * Default constructor for the Weather class.
     */
    public Weather() {
    }

    /**
     * Returns the detailed description of the weather.
     *
     * @return The detailed description of the weather.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the icon representing the weather.
     *
     * @return The icon representing the weather.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Returns the ID of the weather entry.
     *
     * @return The ID of the weather entry.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the main description of the weather.
     *
     * @return The main description of the weather.
     */
    public String getMain() {
        return main;
    }
}

