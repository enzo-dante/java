package com.crownhoundz.musicmanagerui;

import com.crownhoundz.musicmanagerui.model.DataSource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        // compile and load UI with fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));

        // validate UI has compiled successfully before querying and loading artists into table view
        Parent root = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        controller.listArtists();

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("MusicManager!");
        stage.setScene(scene);
        stage.show();
    }

    // use lifecycle methods to manage db connection
    @Override
    public void init() throws Exception {
        super.init();

        DataSource.getDataSourceInstance().open();
        if(!DataSource.getDataSourceInstance().open()) {
            // implement popup dialog
            System.out.println("FATAL ERROR: Couldn't connect to database");

            // do not let user interact with application
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();

        // close db connection
        DataSource.getDataSourceInstance().close();
    }

    public static void main(String[] args) {
        launch();
    }
}