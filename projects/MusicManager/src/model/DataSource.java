package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    /**
     * This method is used to handle the JDBC-SQLite3 database connection.
     * @return Nothing.
     */

    // connection string used to connect JDBC and SQLite3 db with DriverManager
    public static final String DB_NAME = "music.db";
    public static final String JDBC_CONNECTION_STRING = "jdbc:sqlite:/Users/enzo_dante/git/java/projects/MusicManager/" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "_id";
    public static final String COLUMN_ALBUMS_NAME = "name";

    // SQLite3 INTEGER
    public static final String COLUMN_ALBUMS_ARTIST = "artist";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "_id";
    public static final String COLUMN_SONGS_TITLE = "title";

    // SQLite3 INTEGER
    public static final String COLUMN_SONGS_TRACK = "track";

    // SQLite3 INTEGER
    public static final String COLUMN_SONGS_ALBUM = "album";

    private Connection connection;

    /**
     * This is the method which is used to get a list of artists
     * @return A list of artists
     * @exception SQLException On SQLite3 connection error.
     */
    public boolean open() {
        try{
            connection = DriverManager.getConnection(JDBC_CONNECTION_STRING);
            return true;
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This is the method which opens a connection to the music SQLite3 database.
     * @return Nothing.
     * @exception SQLException On SQLite3 connection error.
     */
    public void close() {
        try{
            if(connection != null) {
                connection.close();
            }
        } catch(SQLException e) {
            System.out.println("Couldn't close connection to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * This is the method which opens a connection to the music SQLite3 database.
     * @return Nothing.
     * @exception SQLException On SQLite3 connection error.
     */

    public List<Artist> queryArtists() {
        Statement statement = null;
        ResultSet results = null;

        try {

            // new instance of connection statement to maintain query data integrity
            statement = connection.createStatement();
            results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);

            // instantiate list of artist class objects
            List<Artist> artists = new ArrayList<>();

            // loop over SQL results and add to artists list
            while(results.next()) {
                Artist artist = new Artist();

                // type cast SQL return values
                artist.set_id(results.getInt(COLUMN_ARTISTS_ID));
                artist.setName(results.getString(COLUMN_ARTISTS_NAME));

                artists.add(artist);
            }

            return artists;

        } catch(SQLException e) {
            System.out.println("Artists Query failed: " + e.getMessage());
            return null;

        } finally {
            // test results.close() and statement.close() individually for precision
            try {
                // after SQL query, close ResultsSet to maintain high performance
                if(results != null) {
                    results.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing Artists ResultSet: " + e.getMessage());
            }

            try {
                // after SQL query, close Statement to maintain high performance
                if(statement != null) {
                    statement.close();
                }
            } catch(SQLException e) {
                System.out.println("Error closing Artists Statement query: " + e.getMessage());
            }
        }
    }
}
