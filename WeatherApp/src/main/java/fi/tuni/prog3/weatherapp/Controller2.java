package fi.tuni.prog3.weatherapp;

import fi.tuni.prog3.weatherapp.helpclasses.WeatherData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.io.IOException;

/**
 * A class for representing a controller for managing secondary 
 * user interface actions and data.
 * This class handles functionalities related to a secondary UI, 
 * such as managing weather data retrieval, 
 * interacting with user input fields, and preserving previous data 
 * for specific actions.
 * It also controls the interaction between the UI elements and 
 * the underlying application logic.
 */
public class Controller2 {

    /** 
     * The Stage object used for managing the user interface window.
    * Protected access allows subclasses within the same package  
    * or inheriting classes to access and modify the stage object if necessary.
     *
     */
    protected Stage stage;
    private Scene scene;
    private Parent root;

    //values to save last city data in case cancel is pressed
    private String prevTemperature;
    private Image prevWeatherIcon;
    private String prevFeelsLike;
    private String prevHumidity;
    private String prevWind;
    private String prevTitle;
    private String prevDescription;

    @FXML
    private Button cancelbtn;
    @FXML
    private TextField cityfield;
    @FXML
    private Button searchweather;
    @FXML
    private Label errorlabel;

    /**
     * Handles the cancel action by returning to the main scene 
     * while preserving previous data.
     * 
     * @param e ActionEvent object triggering the cancel action.
     * @throws IOException If Main-scene.fxml file cannot be loaded.
     */
    public void cancel(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main-scene.fxml"));
        root = loader.load();
        Controller controller = loader.getController();

        controller.setTemp(prevTemperature);
        controller.setTitle(prevTitle);
        controller.setHumidity(prevHumidity);
        controller.setFeelslike(prevFeelsLike);
        controller.setCurrentWeatherIcon(prevWeatherIcon);
        controller.setWind(prevWind);
        controller.setDescription(prevDescription);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Handles the search action for a specific town, 
     * retrieving and displaying its weather data.
     *
     * @param e ActionEvent object triggering the town search.
     * @throws IOException If Main-scene.fxml file cannot be loaded or
     * there is an issue with data retrieval.
 */
    public void searchTown(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main-scene.fxml"));
        root = loader.load();
        //Access to the other controller to get access to its functions
        Controller controller = loader.getController();

        //Data search
        String city = cityfield.getText();
        metodit x = new metodit();

        //Use methods from metodit class to fetch the data we need
        String coordsStr = x.lookUpLocation(city);

        // Check if data search was successful and act accordingly
        if (coordsStr == null) {
            cityfield.setText("");
            errorMessage();
        }
        else {

            String[] coords = coordsStr.split(",");
            double coordsLat = Double.parseDouble(coords[0]);
            double coordsLon = Double.parseDouble(coords[1]);
            WeatherData data = x.getCurrentWeather(coordsLat, coordsLon);

            controller.setTitle(data.name);
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

            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    /**
    * Displays an error message on the errorlabel, 
    * fades it out after a set duration,
    * and resets the errorlabel text to an empty string.
    */
    private void errorMessage() {
        errorlabel.setText("Error!! Enter different city");

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), errorlabel);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);

        // Set up a timeline to play the fade transition after a delay
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), event -> {
            fadeTransition.play();
        }));

        fadeTransition.setOnFinished(event -> {
            errorlabel.setText("");
            fadeTransition.stop();
        });

        timeline.play();

    }

    /**
     * Function sets the previous temperature value to be used in 
     * preserving data.
     *
     * @param temp The temperature value to be set as the previous temperature.
     */
    public void setPrevTemperature(String temp) {
        prevTemperature = temp;
    }

    /**
     * Function sets the previous "feels like" temperature value for 
     * preserving data.
     *
     * @param feelsLike The "feels like" temperature value to be stored 
     * as the previous value.
     */
    public void setPrevFeelsLike(String feelsLike) {
        prevFeelsLike = feelsLike;
    }

    /**
     * Function sets the previous title for the purpose of preserving data.
     *
     * @param title The title value to be stored as the previous title.
     */
    public void setPrevTitle(String title) {
        prevTitle = title;
    }

    /**
     * Sets the previous humidity value for the purpose of preserving data.
     *
     * @param humidity The humidity value to be stored 
     * as the previous humidity.
     */
    public void setPrevHumidity(String humidity) {
        prevHumidity = humidity;
    }

    /**
     * Function sets the previous wind speed value for the purpose 
     * of preserving data.
     *
     * @param wind The wind speed value to be stored 
     * as the previous wind speed.
     */
    public void setPrevWind(String wind) {
        prevWind = wind;
    }

    /**
     * Function sets the previous weather icon image for preserving data.
     *
     * @param prevIcon The Image object representing the previous weather icon 
     * to be stored.
     */
    public void setPrevWeatherIcon(Image prevIcon) {
        prevWeatherIcon = prevIcon;
    }

    /**
     * Function sets the previous description text for maintaining data.
     *
     * @param description The description text to be stored 
     * as the previous description.
     */
    public void setPrevDescription(String description) {
        prevDescription = description;
    }


}