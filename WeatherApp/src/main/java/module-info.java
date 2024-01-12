module fi.tuni.progthree.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    exports fi.tuni.prog3.weatherapp;
    opens fi.tuni.prog3.weatherapp to javafx.fxml;
    opens fi.tuni.prog3.weatherapp.helpclasses to com.google.gson;

    requires com.google.gson;
    requires javafx.graphics;

}
