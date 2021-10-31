package model;

public class Artist {

    private int _id;
    private String name;

    /**
     * This is the method which is used to get an artist _id.
     * @return An int _id.
     */
    public int get_id() {
        return _id;
    }

    /**
     * This is the method which is used to set an artist _id.
     * @return Nothing.
     */
    public void set_id(int _id) {
        this._id = _id;
    }

    /**
     * This is the method which is used to get an artist name.
     * @return A String name.
     */
    public String getName() {
        return name;
    }

    /**
     * This is the method which is used to set an artist name
     * @return Nothing.
     */
    public void setName(String name) {
        this.name = name;
    }
}
