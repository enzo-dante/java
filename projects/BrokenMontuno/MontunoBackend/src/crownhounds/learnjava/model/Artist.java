package crownhounds.learnjava.model;

public class Artist {

    // OOP ENCAPSULATION private class fields
    private int _id;
    private String name;

    // OOP getters & setters
    public int get_id() {
        return this._id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}