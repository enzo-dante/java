package com.crownhoundz.musicmanagerui;

import com.crownhoundz.musicmanagerui.model.Album;
import com.crownhoundz.musicmanagerui.model.Artist;
import com.crownhoundz.musicmanagerui.model.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;

// always run the SQL query on a background thread using a Task
// when ready to update UI, update using the JavaFX UI Thread: data binding automatically uses JavaFX UI Thread
public class Controller {

    // these @FXML variables need to have a matching fx:id in the main.fxml file
    @FXML
    private TableView artistsTable;

    @FXML
    private ProgressBar progressBar;

    // @FXML notation allows for methods or variables to be accessed; for example, as an event handler from the main.fxml file on the respective buttons
    @FXML
    public void listArtists() {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistsTable.itemsProperty().bind(task.valueProperty());

        // using lambda expressions to manage visibility of progress bar regardless of success or failure
        progressBar.progressProperty().bind(task.progressProperty());
        progressBar.setVisible(true);

        task.setOnSucceeded(event -> progressBar.setVisible(false));
        task.setOnFailed(event -> progressBar.setVisible(false));

        // use new Thread to start task and make SQL queries on db
        new Thread(task).start();
    }

    @FXML
    public void listAlbumsForArtist() {
        final Artist artist = (Artist) artistsTable.getSelectionModel().getSelectedItem();

        if(artist == null) {
            System.out.println("NO ARTIST SELECTED");
            return;
        }

        // anonymous class
        Task<ObservableList<Album>> task = new Task<ObservableList<Album>>() {
            @Override
            protected ObservableList<Album> call() throws Exception {
                return FXCollections.observableArrayList(
                        DataSource.getDataSourceInstance().queryAlbumsForArtistId(artist.get_id())
                );
            }
        };
        artistsTable.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
    }
}

// task.setOnSucceeded(e -> artistTable.getItems().setAll(artistResults);
class GetAllArtistsTask extends Task {

    // to maintain model and UI compartmentalization, override call() to return ObservableArrayList
    @Override
    public ObservableList<Artist> call() {
        return FXCollections.observableArrayList(
                DataSource.getDataSourceInstance()
                        .queryArtists(DataSource.ORDER_BY_ASC)
        );
    }
}