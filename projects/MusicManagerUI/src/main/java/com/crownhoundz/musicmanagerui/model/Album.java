package com.crownhoundz.musicmanagerui.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Album {

    // data binding is a general technique that binds data sources from the provider and consumer together and synchronizes them
    // to use data binding, use simple properties
    private SimpleIntegerProperty _id;
    private SimpleStringProperty name;
    private SimpleIntegerProperty artistId;

    // use constructor to initialize fields as simple properties to avoid null pointer exceptions
    public Album() {
        this._id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.artistId = new SimpleIntegerProperty();
    }

    // use .get and .set to convert from primitive data types into simple properties
    /**
     * This is the method which is used to get an album _id.
     * @return An int _id.
     */
    public int get_id() {
        return _id.get();
    }

    /**
     * This is the method which is used to set an album _id.
     * @return Nothing.
     */
    public void set_id(int _id) {
        this._id.set(_id);
    }

    /**
     * This is the method which is used to get an album name.
     * @return A String name.
     */
    public String getName() {
        return name.get();
    }

    /**
     * This is the method which is used to set an album's name.
     * @return Nothing.
     */
    public void setName(String name) {
        this.name.set(name);
    }

    /**
     * This is the method which is used to get an album's artist id.
     * @return An int _id.
     */
    public int getArtistId() {
        return artistId.get();
    }

    /**
     * This is the method which is used to set an album's artist id.
     * @return Nothing.
     */
    public void setArtistId(int artistId) {
        this.artistId.set(artistId);
    }
}
