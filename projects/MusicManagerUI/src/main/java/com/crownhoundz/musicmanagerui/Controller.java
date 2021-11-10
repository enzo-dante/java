package com.crownhoundz.musicmanagerui;

import com.crownhoundz.musicmanagerui.model.Album;
import com.crownhoundz.musicmanagerui.model.Artist;
import com.crownhoundz.musicmanagerui.model.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class Controller {
    @FXML
    private TableView artistsTable;

    public void listArtists() {
        Task<ObservableList<Artist>> task = new GetAllArtistsTask();
        artistsTable.itemsProperty().bind(task.valueProperty());

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
