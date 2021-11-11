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
    /**
     * This is the method which handles the event from the main.fxml file for listing all artists on the UI.
     *
     * @return Nothing.
     */
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

    /**
     * This is the method which handles the event from the main.fxml file for listing all albums by artist name on the UI.
     *
     * @return Nothing.
     */
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

        // update UI by populating it with db query data on new thread
        artistsTable.itemsProperty().bind(task.valueProperty());

        // use new Thread to start task and make SQL queries on db
        new Thread(task).start();
    }

    /**
     * This is the method which handles the event from the main.fxml file for updating an artist name on the backend and for the UI.
     *
     * @return Nothing.
     */
    @FXML
    public void updateArtistName() {
        // get SQL record that is cast as an Artist class
        final Artist artist = (Artist) artistsTable.getItems().get(2);

        Task<Boolean> task = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return DataSource.getDataSourceInstance()
                        .updateArtistName(artist.get_id(), "AC/DC");

            }
        };

        // if task succeeds, then update UI to match updated record in the db on it's own thread
        task.setOnSucceeded(event -> {
            if(task.valueProperty().get()) {
                artist.setName("AC/DC");
                // refresh() forces table to re-draw UI rows for proper table alignment with new db data
                artistsTable.refresh();
            }
        });

        // use new Thread to start task and make SQL queries on db
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