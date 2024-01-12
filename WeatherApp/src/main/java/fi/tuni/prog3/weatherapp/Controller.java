package fi.tuni.prog3.weatherapp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A class for representing a controller for user interface components and
 * their actions.
 * Manages the interaction between the UI elements and the application logic.
 * 
 */
public class Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label title;
    @FXML
    private AnchorPane container1;
    @FXML
    private ImageView currentWeather;
    @FXML
    private Text feelslike;
    @FXML
    private Text humidity;
    @FXML
    private Button searchBtn;
    @FXML
    private Text temp;
    @FXML
    private Text wind;
    @FXML
    private Label description;
    @FXML
    private Button quitbtn;

    /**
     * Function switches the current window to the search window and preserves
     * the current window's data through the controller to prevent data loss 
     * if the search action is canceled.
     *
     * @param e ActionEvent object that triggers the window change.
     * @throws IOException if the FXML file cannot be loaded.
     */
    public void switchToSearchScene(ActionEvent e) throws IOException {
        //data to be passed to controller2 to prevent data loss
        String temperature = temp.getText();
        String feelsLike = feelslike.getText();
        String humidityAmount = humidity.getText();
        String windSpeed = wind.getText();
        Image weatherIcon = currentWeather.getImage();
        String lastTitle = title.getText();
        String description_ = description.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Search-scene.fxml"));
        root = loader.load();

        //access to controller2 function to preserve previous scenes data in case search action is canceled
        Controller2 Controller2 = loader.getController();

        Controller2.setPrevTemperature(temperature);
        Controller2.setPrevTitle(lastTitle);
        Controller2.setPrevFeelsLike(feelsLike);
        Controller2.setPrevHumidity(humidityAmount);
        Controller2.setPrevWind(windSpeed);
        Controller2.setPrevWeatherIcon(weatherIcon);
        Controller2.setPrevDescription(description_);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
    * Function closes the user interface when the user clicks the quit button.
    *
    * @param e ActionEvent object that triggers the application's closure.
    */
    public void quit(ActionEvent e) {
        Platform.exit();
    }

    /**
    * Function sets the temperature to be displayed in a text field.
    *
    * @param temperature The temperature to display in the text field.
    */
    public void setTemp(String temperature) {
        temp.setText(temperature);
    }

    /**
     * Function sets the wind speed to be displayed in a text field.
     * 
     * @param windSpeed The wind speed value to display in the text field.
     */
    public void setWind(String windSpeed) {
        wind.setText(windSpeed);
    }

    /**
     * Function sets the humidity amount to be displayed in a text field.
     * 
     * @param humidityAmount The humidity value to display in the text field.
     */
    public void setHumidity(String humidityAmount) {
        humidity.setText(humidityAmount);
    }

    /**
     * Function sets the feels-like temperature value to be displayed
     * in a text field.
     * 
     * @param feelslikevalue The feels-like temperature value to display 
     * in the text field.
     */
    public void setFeelslike(String feelslikevalue) {
        feelslike.setText(feelslikevalue);
    }

    /**
     * Function sets the current weather icon to be displayed.
     * 
     * @param icon The Image object representing the weather icon
     * to be displayed.
     */
    public void setCurrentWeatherIcon(Image icon) {
        currentWeather.setImage(icon);
    }

    /**
     * Function sets the title to be displayed in a text field.
     * 
     * @param newTitle The new title to be set and displayed.
     */
    public void setTitle(String newTitle) {
        title.setText(newTitle);
    }

    /**
     * Function sets the description to be displayed in a text field.
     * 
     * @param newDescription The new description to be set and displayed.
     */
    public void setDescription(String newDescription) {
        description.setText(newDescription);
    }
}