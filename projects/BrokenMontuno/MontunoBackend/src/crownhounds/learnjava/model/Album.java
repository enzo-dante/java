package crownhounds.learnjava.model;

public class Album {

    // OOP ENCAPSULATION private class fields
    private int _id;
    private String name;
    private int artistId;

    // OOP getters & setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}