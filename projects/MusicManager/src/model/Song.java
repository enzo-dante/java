package model;

public class Song {

    private int _id;
    private int track;
    private String title;
    private int albumId;

    /**
     * This is the method which is used to get a song _id.
     * @return An int _id.
     */
    public int get_id() {
        return _id;
    }

    /**
     * This is the method which is used to set a song _id.
     * @return Nothing.
     */
    public void set_id(int _id) {
        this._id = _id;
    }

    /**
     * This is the method which is used to get a song track.
     * @return An int _id.
     */
    public int getTrack() {
        return track;
    }

    /**
     * This is the method which is used to set a song track.
     * @return Nothing.
     */
    public void setTrack(int track) {
        this.track = track;
    }

    /**
     * This is the method which is used to get a song's title.
     * @return A String title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * This is the method which is used to set an song title.
     * @return Nothing.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This is the method which is used to get a song's album id.
     * @return An int album id.
     */
    public int getAlbumId() {
        return albumId;
    }

    /**
     * This is the method which is used to set a song's album id.
     * @return Nothing.
     */
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
}
