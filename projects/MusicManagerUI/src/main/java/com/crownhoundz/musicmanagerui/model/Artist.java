package com.crownhoundz.musicmanagerui.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Artist {

    // data binding is a general technique that binds data sources from the provider and consumer together and synchronizes them
    // to use data binding, use simple properties
    private SimpleIntegerProperty _id;
    private SimpleStringProperty name;

    // use constructor to initialize fields as simple properties to avoid null pointer exceptions
    public Artist() {
        this._id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
    }

    // use .get and .set to convert from primitive data types into simple properties
    /**
     * This is the method which is used to get an artist _id.
     * @return An int _id.
     */
    public int get_id() {
        return _id.get();
    }

    /**
     * This is the method which is used to set an artist _id and to convert the SimpleIntProperty to an int.
     * @return Nothing.
     * @param _id
     */
    public void set_id(int _id) {
        this._id.set(_id);
    }

    /**
     * This is the method which is used to get an artist name.
     * @return A String name.
     */
    public String getName() {
        return name.get();
    }

    /**
     * This is the method which is used to set an artist name and convert from a SimpleStringProperty to a String.
     * @return Nothing.
     */
    public void setName(String name) {
        this.name.set(name);
    }


}

