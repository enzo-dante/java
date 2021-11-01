package model;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    /**
     * This class is used to handle the JDBC-SQLite3 database connection and data management.
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

    public static final String QUERY_ARTISTS_START =
            "SELECT * FROM " + TABLE_ARTISTS;

    public static final String QUERY_ARTISTS_SORT =
            " ORDER BY " + COLUMN_ARTISTS_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ALBUMS_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME +
                    " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID +
                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + " = ";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTISTS_FOR_SONGS_START =
            "SELECT " +
                    TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONGS_TRACK +
                    " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONGS_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID +
                    " WHERE " + TABLE_SONGS + "." + COLUMN_SONGS_TITLE + " = ";

    public static final String QUERY_ARTISTS_FOR_SONGS_SORT =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONGS_TITLE + " COLLATE NOCASE ";

    public static final String ALBUMS_SCHEMA = "SELECT * FROM " + TABLE_ALBUMS;
    public static final String ARTISTS_SCHEMA = "SELECT * FROM " + TABLE_ARTISTS;
    public static final String SONGS_SCHEMA = "SELECT * FROM " + TABLE_SONGS;
    public static final String COUNT_FROM = "SELECT COUNT(*) AS count FROM ";

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
     *
     * SQL statement:
     *         SELECT *
     *         FROM   artists
     *         ORDER  BY NAME COLLATE NOCASE ASC;
     *
     * @param sortOrder order of results in ASC or DESC.
     * @return A list of all artists and their respective _id and name.
     * @exception SQLException On SQLite3 statement error.
     */
    public List<Artist> queryArtists(int sortOrder) {

        Statement statement = null;
        ResultSet results = null;

        // build String of SQL query
        StringBuilder stringBuilder = new StringBuilder(QUERY_ARTISTS_START);

        if(sortOrder != ORDER_BY_NONE) {
            stringBuilder.append(QUERY_ARTISTS_SORT);

            if(sortOrder == ORDER_BY_DESC) {
                stringBuilder.append("DESC");
            } else {
                stringBuilder.append("ASC");
            }
        }

        stringBuilder.append(";");

        // validate SQL command composition
        System.out.println("Artists SQL query: \n" + stringBuilder.toString());

        // SQL query handler
        try {

            // create new instance of connection statement to maintain query data integrity
            // executeQuery with built SQL toString
            statement = connection.createStatement();
            results = statement.executeQuery(stringBuilder.toString());

            // instantiate list of artist class objects
            List<Artist> artists = new ArrayList<>();

            // loop over results array and add result with respective data type to artists list as long as there is a next object
            while(results.next()) {
                Artist artist = new Artist();

                // overloaded method type cast SQL return values
                // since result is only querying a single table that is not JOINED,
                // ResultSet and table column index are identical
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
            // executeQuery with built SQL toString

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
     *
     * SQL statement:
     *         SELECT albums.NAME
     *         FROM   albums
     *         INNER JOIN artists
     *         ON albums.artist = artists._id
     *         WHERE  artists.NAME = 'Carole King'
     *         ORDER  BY albums.NAME COLLATE NOCASE ASC;
     *
     * @param artistName name of artist.
     * @param sortOrder order of results in ASC or DESC.
     * @return list of String albumNames.
     * @exception SQLException On SQLite3 statement error.
     */
    public List<String> queryAlbumsForArtist(String artistName, int sortOrder) {

        Statement statement = null;
        ResultSet results = null;

        // build string of SQL query
        StringBuilder stringBuilder = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        stringBuilder.append("'" + artistName + "'");

        // handle sort order
        if(sortOrder != ORDER_BY_NONE) {
            stringBuilder.append(QUERY_ALBUMS_BY_ARTIST_SORT);

            if(sortOrder == ORDER_BY_DESC) {
                stringBuilder.append("DESC");
            } else {
                stringBuilder.append("ASC");
            }
        }

        stringBuilder.append(";");

        // validate SQL command composition
        System.out.println("AlbumsForArtist SQL query: \n" + stringBuilder.toString());

        // SQL query handler
        try {

            // create new instance of connection statement to maintain query data integrity during asynchronous calls
            // executeQuery with built SQL toString
            statement = connection.createStatement();
            results = statement.executeQuery(stringBuilder.toString());

            // instantiate new list of album String names
            // only SQL querying for albums.name and not full rocord
            List<String> albums = new ArrayList<>();

            // loop over results array and add result.getString() to albums list as long as there is a next object
            while(results.next()) {
                // columnIndex refers to the index in the ResultSet and not SQL table column index
                albums.add(results.getString(1));
            }

            return albums;

        } catch(SQLException e) {
            System.out.println("AlbumsForArtist query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This is the method which gets the artists.name, albums.name and songs.track by the specified songs title.
     *
     * SQL statement:
     *         SELECT artists.NAME,
     *                 albums.NAME,
     *                 songs.track
     *         FROM   songs
     *         INNER JOIN albums
     *         ON songs.album = albums._id
     *         INNER JOIN artists
     *         ON albums.artist = artists._id
     *         WHERE  songs.title = 'Heartless';
     *
     * @param songTitle title of song.
     * @param sortOrder order of results in ASC or DESC.
     * @return A list of artists.name, albums.name and songs.track.
     * @exception SQLException On SQLite3 statement error.
     */
    public List<SongArtist> queryArtistsForSong(String songTitle, int sortOrder) {

        Statement statement = null;
        ResultSet results = null;

        // build String for SQL query
        StringBuilder stringBuilder = new StringBuilder(QUERY_ARTISTS_FOR_SONGS_START);
        stringBuilder.append("'" + songTitle + "'");

        if (sortOrder != ORDER_BY_NONE) {
            stringBuilder.append(QUERY_ARTISTS_FOR_SONGS_SORT);

            if(sortOrder == ORDER_BY_DESC) {
                stringBuilder.append("DESC");
            } else {
                stringBuilder.append("ASC");
            }
        }

        stringBuilder.append(";");

        // validate SQL statement composition
        System.out.println("ArtistsForSong SQL Statement: \n" + stringBuilder.toString());

        try {

            // create new instance of connection statement to maintain query data integrity during asynchronous calls
            // executeQuery with built SQL toString
            statement = connection.createStatement();
            results = statement.executeQuery(stringBuilder.toString());

            // instantiate new list for SongArtist objects
            List<SongArtist> songArtists = new ArrayList<>();

            // loop over results array and add result.getToString() to songArtists list as long as there is a next object
            while(results.next()) {
                // instantiate new SongArtist object
                SongArtist songArtist = new SongArtist();

                // columnIndex refers to the index in the ResultSet and not SQL table column index
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));

                songArtists.add(songArtist);
            }

            return songArtists;

        } catch(SQLException e) {
            System.out.println("ArtistsForSong query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This is the method which gets the database schema for songs table.
     *
     * SQL statement: SELECT * FROM songs;
     *
     * @return A String that shows the schema for the songs table.
     * @exception SQLException On SQLite3 statement error.
     */
    public void querySongsMetadata() {

       String sql = SONGS_SCHEMA;
       Statement statement = null;
       ResultSet results = null;

       try {

           statement = connection.createStatement();
           results = statement.executeQuery(SONGS_SCHEMA);

           // get and save metadate of songs query result
           ResultSetMetaData metadata = results.getMetaData();
           // get number of columns in songs table metadata
           int numColumns = metadata.getColumnCount();

           // iterate over numColumns, print column metadata
           // ResultSet columns start at 1 and not 0
           for(int i = 1; i <= numColumns; i++) {
               // %d = specified variable corresponding with position in .format after String
               System.out.format("Column %d in the songs table is names %s\n", i, metadata.getColumnName(i));
           }

       } catch(SQLException e) {
           System.out.println("Songs Metadata query failed: " + e.getMessage());
           e.printStackTrace();
       }
    }


    /**
     * This is the method which gets the count for songs table.
     *
     * SQL statement: SELECT COUNT(*) FROM {table};
     *
     * @return A int that shows the number of for the specified table.
     * @exception SQLException On SQLite3 statement error.
     */

    public int getCount(String table) {
        String sql = COUNT_FROM + table;
        Statement statement = null;
        ResultSet results = null;

        try {

            statement = connection.createStatement();
            results = statement.executeQuery(sql);

            // columnIndex refers to the index in the ResultSet and not SQL table column index
            // since sql command is using an AS alias, you can specifically access the column by name
                // still needs to be a getInt though
            int count = results.getInt("count");

            return count;

        } catch(SQLException e) {
            System.out.println("Getting count failed: " + e.getMessage());
            e.printStackTrace();
            // -1 = error
            return -1;
        }
    }
}
