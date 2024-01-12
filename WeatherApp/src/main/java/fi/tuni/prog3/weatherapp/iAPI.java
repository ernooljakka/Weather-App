/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.helpclasses.WeatherData;

import java.io.IOException;


/**
 * Interface for extracting data from the OpenWeatherMap API.
 */
public interface iAPI {

    /**
     * Returns coordinates for a location.
     * @param loc Name of the location for which coordinates should be fetched.
     * @return String.
     * @throws java.io.IOException
     */
    public String lookUpLocation(String loc) throws IOException;

    /**
     * Returns the current weather for the given coordinates.
     *
     * @param lat The latitude of the location.
     * @param lon The longitude of the location.
     * @return String.
     * @throws java.io.IOException
     */
    public WeatherData getCurrentWeather(double lat, double lon) throws IOException;
    /**
     * Returns a forecast for the given coordinates.
     * @param lat The latitude of the location.
     * @param lon The longitude of the location.
     * @return WeatherData.
     */
    public String getForecast(double lat, double lon);

}
