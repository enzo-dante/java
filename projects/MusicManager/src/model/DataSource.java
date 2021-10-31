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

    // COLUMN INDICES are 1 based, not 0 based
    public static final int INDEX_ALBUMS_ID = 1;
    public static final int INDEX_ALBUMS_NAME = 2;
    public static final int INDEX_ALBUMS_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";

    // COLUMN INDICES are 1 based, not 0 based
    public static final int INDEX_ARTISTS_ID = 1;
    public static final int INDEX_ARTISTS_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "_id";
    public static final String COLUMN_SONGS_TITLE = "title";

    // SQLite3 INTEGER
    public static final String COLUMN_SONGS_TRACK = "track";

    // SQLite3 INTEGER
    public static final String COLUMN_SONGS_ALBUM = "album";

    // COLUMN INDICES are 1 based, not 0 based
    public static final int INDEX_SONGS_ID = 1;
    public static final int INDEX_SONGS_TRACK = 2;
    public static final int INDEX_SONGS_TITLE = 3;
    public static final int INDEX_SONGS_ALBUM = 3;

    // SQL query composition
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    private Connection connection;

    /**
     * This is the method which opens a connection to the music SQLite3 database.
     * @return A boolean indicating connection success or failure.
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
     * This is the method which closes a connection to the music SQLite3 database.
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
     * This is the method which gets a list of all artists.
     * SQL: SELECT * FROM artists ORDER BY COLLATE NOCASE ASC;
     * @param sortOrder order of results in ASC or DESC.
     * @return Nothing.
     * @exception SQLException On SQLite3 connection error.
     */
    public List<Artist> queryArtists(int sortOrder) {

        // Build string for SQL query statement
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ");
        stringBuilder.append(TABLE_ARTISTS);
        if(sortOrder != ORDER_BY_NONE) {
            stringBuilder.append(" ORDER BY ");
            stringBuilder.append(COLUMN_ARTISTS_NAME);
            stringBuilder.append(" COLLATE NOCASE ");

            if(sortOrder == ORDER_BY_DESC) {
                stringBuilder.append("DESC");
            } else {
                stringBuilder.append("ASC");
            }
        }

        Statement statement = null;
        ResultSet results = null;

        try {

            // new instance of connection statement to maintain query data integrity
            statement = connection.createStatement();
            results = statement.executeQuery(stringBuilder.toString());

            // instantiate list of artist class objects
            List<Artist> artists = new ArrayList<>();

            // loop over SQL results and add to artists list
            while(results.next()) {
                Artist artist = new Artist();

                // overloaded method type cast SQL return values
                artist.set_id(results.getInt(INDEX_ARTISTS_ID));
                artist.setName(results.getString(INDEX_ARTISTS_NAME));

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
    /**
     * This is the method which gets a list of albums by the specified artist.
     * SQL: SELECT * FROM artists ORDER BY COLLATE NOCASE ASC;
     * @param artistName name of artist.
     * @param sortOrder order of results in ASC or DESC.
     * @return Nothing.
     * @exception SQLException On SQLite3 connection error.
     */
    public List<String> queryAlbumsForAritst(String artistName, int sortOrder) {

    }
}
