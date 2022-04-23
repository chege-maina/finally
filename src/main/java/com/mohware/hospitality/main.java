package com.mohware.hospitality;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.StageStyle;

public class main extends Application {

    public static final String CURRENCY = "Kshs. ";

    @Override
    public void start(Stage stage) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/rest_POS/POS.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcome/welcome.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/admin/admin.fxml"));

        //stage.setMaximized(true);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root, 960, 600));
        stage.setMaximized(true);
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.setScene(new Scene(root));
        //root.getStylesheets().add("/fxml/style/style.css");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
