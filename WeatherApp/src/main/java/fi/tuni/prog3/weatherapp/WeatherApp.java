package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.helpclasses.WeatherData;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;


/**
 * Class which presents JavaFX application for displaying weather information.
 */
public class WeatherApp extends Application {

    /**
     * Function initializes and configures the primary stage of the application.
     * It loads the main UI from Main-scene.fxml and populates it with 
     * initial weather data for Tampere. It sets up the UI elements with 
     * weather-related information fetched from the OpenWeatherMap API for 
     * Tampere's current weather conditions.
     *
     * @param stage The primary stage of the application.
     * @throws IOException if an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main-scene.fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();
        //Add initial values set for current weather in Tampere
        metodit x = new metodit();
        String tampereCoordsStr = x.lookUpLocation("Tampere");
        String[] coordsStr = tampereCoordsStr.split(",");
        double coordsLat = Double.parseDouble(coordsStr[0]);
        double coordsLon = Double.parseDouble(coordsStr[1]);
        WeatherData data = x.getCurrentWeather(coordsLat, coordsLon);

        //setting the fetched values for Tampere current weather
        controller.setTitle("Tampere");
        controller.setDescription(data.weather[0].description);

        double x1 = Double.parseDouble(data.main.get("temp"));
        String y1 = String.valueOf(Math.round(x1));
        controller.setTemp(y1 + "°C");

        double x2 = Double.parseDouble(data.main.get("feels_like"));
        String y2 = String.valueOf(Math.round(x2));
        controller.setFeelslike("Feels like: " + y2 + "°C");

        double x3 = Double.parseDouble(data.wind.get("speed"));
        String y3 = String.valueOf(Math.round(x3));
        controller.setWind("Wind: " + y3 + " m/s");
        controller.setHumidity("Humidity: " + data.main.get("humidity") + " %");

        Image icon = new Image("https://openweathermap.org/img/wn/"+data.weather[0].icon+"@2x.png");
        controller.setCurrentWeatherIcon(icon);

        Scene scene = new Scene(root);
        stage.setTitle("WeatherApp");
        Image iconApp = new Image("/weatherIcon.png");
        stage.getIcons().add(iconApp);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main function of the application, launching the JavaFX application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}