package model;

public class Album {

    private int _id;
    private String name;
    private int artistId;

    /**
     * This is the method which is used to get an album _id.
     * @return An int _id.
     */
    public int get_id() {
        return _id;
    }

    /**
     * This is the method which is used to set an album _id.
     * @return Nothing.
     */
    public void set_id(int _id) {
        this._id = _id;
    }

    /**
     * This is the method which is used to get an album name.
     * @return A String name.
     */
    public String getName() {
        return name;
    }

    /**
     * This is the method which is used to set an album's name.
     * @return Nothing.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is the method which is used to get an album's artist id.
     * @return An int _id.
     */
    public int getArtistId() {
        return artistId;
    }

    /**
     * This is the method which is used to set an album's artist id.
     * @return Nothing.
     */
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
