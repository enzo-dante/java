package com.crownhounds.montuno.backend.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    /**
     * This class is used to handle the JDBC-SQLite3 database connection and data management.
     */

    // connection string used to connect JDBC and SQLite3 db with DriverManager
    public static final String DB_NAME = "music.db";
    public static final String JDBC_CONNECTION_STRING = "jdbc:sqlite:/Users/enzo_dante/git/java/projects/Montuno/" + DB_NAME;

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
    public static final int INDEX_SONGS_ALBUM = 4;

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

    public static final String TABLE_ARTIST_LIST_VIEW = "artist_list";
    public static final String CREATE_VIEW_ARTIST_LIST =
            "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_LIST_VIEW + " AS SELECT " +
                    TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + " AS album, " +
                    TABLE_SONGS + "." + COLUMN_SONGS_TRACK + ", " +
                    TABLE_SONGS + "." + COLUMN_SONGS_TITLE +
                    " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONGS_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID +
                    " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " +
                    TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + ", " +
                    TABLE_SONGS + "." + COLUMN_SONGS_TRACK + ";";

    public static final String QUERY_VIEW_SONG_INFO =
            "SELECT " +
                    COLUMN_ARTISTS_NAME + ", " +
                    "album, " +
                    COLUMN_SONGS_TRACK +
                    " FROM " + TABLE_ARTIST_LIST_VIEW +
                    " WHERE " + COLUMN_SONGS_TITLE + " = ";

    // ? = placeholder for title
    // SQL statement: SELECT name, album, track FROM artist_list WHERE title = ?
    public static final String QUERY_ARTIST_LIST_PREPARED_STATEMENT =
            "SELECT " + COLUMN_ARTISTS_NAME + ", " + COLUMN_SONGS_ALBUM + ", " + COLUMN_SONGS_TRACK +
            " FROM " + TABLE_ARTIST_LIST_VIEW +
            " WHERE " + COLUMN_SONGS_TITLE + " = ?";

    public static final String INSERT_INTO_ARTISTS = "INSERT INTO " + TABLE_ARTISTS + "(" + COLUMN_ARTISTS_NAME + ") VALUES(?)";
    public static final String INSERT_INTO_ALBUMS = "INSERT INTO " + TABLE_ALBUMS + "(" + COLUMN_ALBUMS_NAME + ", " + COLUMN_ALBUMS_ARTIST + ") VALUES(?, ?)";
    public static final String INSERT_INTO_SONGS = "INSERT INTO " + TABLE_SONGS + "(" + COLUMN_SONGS_TRACK + ", " + COLUMN_SONGS_TITLE + ", " + COLUMN_SONGS_ALBUM + ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTISTS =
            "SELECT " + COLUMN_ARTISTS_ID +
                    " FROM " + TABLE_ARTISTS +
                    " WHERE " + COLUMN_ARTISTS_NAME + " = ?";
    public static final String QUERY_ALBUMS =
            "SELECT " + COLUMN_ALBUMS_ID +
                    " FROM " + TABLE_ALBUMS +
                    " WHERE " + COLUMN_ALBUMS_NAME + " = ?";
    public static final String QUERY_SONGS =
            "SELECT " + COLUMN_SONGS_ID +
                    " FROM " + TABLE_SONGS +
                    " WHERE " + COLUMN_SONGS_TITLE + " = ?";

    public static final String QUERY_ALBUMS_BY_ARTIST_ID =
            "SELECT * FROM " + TABLE_ALBUMS +
                    " WHERE " + COLUMN_ALBUMS_ARTIST + " = ? ORDER BY " + COLUMN_ALBUMS_NAME + " COLLATE NOCASE";

    public static final String UPDATE_ARTIST_NAME =
            "UPDATE " + TABLE_ARTISTS +
            " SET " + COLUMN_ARTISTS_NAME +
            " = ? WHERE " + COLUMN_ARTISTS_ID + " = ?";

    // instance variable for PreparedStatement that is only pre-compiled only once
        // helpful for performance and protecting against SQL Injection Attacks
    // PreparedStatement is a subclass of Statement
    private PreparedStatement queryArtistListView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtists;
    private PreparedStatement queryAlbums;
    private PreparedStatement querySongs;
    private PreparedStatement queryAlbumsByArtistId;
    private PreparedStatement updateArtistName;

    // singleton pattern: ensures that only one object of its kind exists and provides a single point of access to it for any other code
    // validate only 1 instance of DataSource class is being used and thread safe if multiple threads are running
    private static DataSource dataSourceInstance = new DataSource();

    private DataSource() {

    }

    // lazy instantiation: only create instance using singleton pattern when instance is needed
    // DataSource.getDataSourceInstance.methodName()
    public static DataSource getDataSourceInstance() {
        return dataSourceInstance;
    }

    private Connection connection;

    /**
     * This is the method which opens a connection to the music SQLite3 database.
     * @return A boolean indicating connection success or failure.
     * @exception SQLException On SQLite3 connection error.
     */
    public boolean open() {
        try{
            connection = DriverManager.getConnection(JDBC_CONNECTION_STRING);

            // preparedStatement(SQL_PREPARED_STATEMENT) is great for performance instead of creating a new instance on every query
            queryArtistListView = connection.prepareStatement(QUERY_ARTIST_LIST_PREPARED_STATEMENT);

            // Statement.RETURN_GENERATED_KEYS = need ids to pass into subsequent insert statement until committing to songs table
            insertIntoArtists = connection.prepareStatement(INSERT_INTO_ARTISTS, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = connection.prepareStatement(INSERT_INTO_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = connection.prepareStatement(INSERT_INTO_SONGS);

            queryArtists = connection.prepareStatement(QUERY_ARTISTS);
            queryAlbums = connection.prepareStatement(QUERY_ALBUMS);
            querySongs = connection.prepareStatement(QUERY_SONGS);
            queryAlbumsByArtistId = connection.prepareStatement(QUERY_ALBUMS_BY_ARTIST_ID);
            updateArtistName = connection.prepareStatement(UPDATE_ARTIST_NAME);

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
            // close resources before connection
            if(queryArtistListView != null) {
                queryArtistListView.close();
            }
            if(insertIntoArtists != null) {
                insertIntoArtists.close();
            }

            if(insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }

            if(insertIntoSongs != null) {
                insertIntoSongs.close();
            }

            if(queryArtists != null) {
                queryArtists.close();
            }

            if(queryAlbums != null) {
                queryAlbums.close();
            }

            if(querySongs != null) {
                querySongs.close();
            }

            if(queryAlbumsByArtistId != null) {
                queryAlbumsByArtistId.close();
            }

            if(updateArtistName != null) {
                updateArtistName.close();
            }

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
     *         ORDER  BY name COLLATE NOCASE ASC;
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

                // forcing query to slow down to test progress bar visibility
                try {
                    Thread.sleep(10);
                } catch(InterruptedException e) {
                    System.out.println("Interrupted: " + e.getMessage());
                }

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
     * This is the method which updates the name of a specific artist.
     *
     * SQL statement:
     *         UPDATE artists
     *          SET name = ?
     *          WHERE _id = ?;
     *
     * @param artist_id The id of the artist.
     * @param newArtistName The user-provided artist name.
     * @return A boolean variable that indicates update success or failure.
     * @exception SQLException On SQLite3 statement error.
     */
    public boolean updateArtistName(int artist_id, String newArtistName) {

        try {
            updateArtistName.setString(1, newArtistName);
            updateArtistName.setInt(2, artist_id);

            int updatedRecords = updateArtistName.executeUpdate();

            return updatedRecords == 1;

        } catch(SQLException e) {
            System.out.println("updateArtistName() failed: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * This is the method which gets a list of albums by the specified artist.
     *
     * SQL statement:
     *         SELECT *
     *         FROM   albums
     *         WHERE  artist = 66
     *         ORDER  BY name COLLATE NOCASE ASC;
     *
     * @param artistId name of artist.
     * @return list of String albumNames.
     * @exception SQLException On SQLite3 statement error.
     */
    public List<Album> queryAlbumsForArtistId(int artistId) {
        try {

            queryAlbumsByArtistId.setInt(1, artistId);
            System.out.println(queryAlbumsByArtistId);

            ResultSet results = queryAlbumsByArtistId.executeQuery();
            List<Album> albums = new ArrayList<>();

            // iterate over SQL query results, create an album object with respective data, and add to array list
            while(results.next()) {
                Album album = new Album();
                album.set_id(results.getInt(1));
                album.setName(results.getString(2));
                album.setArtistId(artistId);
                albums.add(album);
            }

            return albums;

        } catch(SQLException e) {
            System.out.println("queryAlbumForArtistId() failed " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This is the method which gets a list of albums by the specified artist.
     *
     * SQL statement:
     *         SELECT albums.name
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
     *         SELECT artists.name,
     *                 albums.name,
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

       // validate SQL statement
       System.out.println("querySongsMetadata SQL statement:\n" + SONGS_SCHEMA);

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

        // validate SQL statement
        System.out.println("getCount() SQL statement:\n" + sql);

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

    /**
     * This is the method which creates the artist_list view if it does not exist.
     *
     * SQL statement:
     *         CREATE VIEW IF NOT EXISTS artist_list AS
     *         SELECT     artists.name AS artist,
     *                    albums.name  AS album,
     *                    songs.track,
     *                    songs.title
     *         FROM       songs
     *         INNER JOIN albums
     *         ON         songs.album = albums._id
     *         INNER JOIN artists
     *         ON         albums.artist = artists._id
     *         ORDER BY   artists.name,
     *                    albums.name,
     *                    songs.track;
     *
     * @return A boolean that indicates success or failure.
     * @exception SQLException On SQLite3 statement error.
     */
    public boolean createViewArtistList() {

        Statement statement = null;

        try {
            statement = connection.createStatement();

            // validate SQL command
            System.out.println("Create view artist_list SQL statement:\n" + CREATE_VIEW_ARTIST_LIST);

            statement.execute(CREATE_VIEW_ARTIST_LIST);
            return true;

        } catch(SQLException e) {
            System.out.println("Create view artist_list failed: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    /**
     * This is the method which queries the artist_list view
     *
     * SQL statement:
     *         SELECT name,
     *                album,
     *                track
     *         FROM   artist_list
     *         WHERE  title = '{song_title}';
     *
     * @param title A title of a song.
     * @return A list of artist names, albums, and tracks order by artists.
     * @exception SQLException On SQLite3 statement error.
     */
    public List<SongArtist> querySongInfoView(String title) {
      // unnecessary with PreparedStatement
//        Statement statement = null;
//        ResultSet results = null;
//
//        StringBuilder stringBuilder = new StringBuilder(QUERY_VIEW_SONG_INFO);
//        stringBuilder.append("'" + title + "'");
//        System.out.println("queryViewInfoSong SQL statement:\n" + stringBuilder.toString());

        try {
//            statement = connection.createStatement();
//            results = statement.executeQuery(stringBuilder.toString());

            // preparedStatement.setString(questionMarkIndex, replacementValue)
            queryArtistListView.setString(1, title);

            // executeQuery() does not require a query since we've already preparedStatement.setString() in the line above pre-compiled
            ResultSet results = queryArtistListView.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();

            while(results.next()) {
                // instantiate new SongArtist object
                SongArtist songArtist = new SongArtist();

                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));

                songArtists.add(songArtist);
            }

            return songArtists;

        } catch(SQLException e) {
            System.out.println("querySongInfo failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    /**
     * This is the method which inserts an artist into the Artists table if missing and returns the respective _id.
     *
     * SQL statement:
     *         INSERT INTO   artists(name)
     *         VALUES(?);
     *
     * @param artistName The name of the artist.
     * @return The _id of the artist.
     * @exception SQLException On SQLite3 statement error.
     */
    private int insertArtist(String artistName) throws SQLException {

        // PreparedStatement that replaces the ? with parameter
        queryArtists.setString(1, artistName);

        // use query PreparedStatement to validate if data is already present
        ResultSet results = queryArtists.executeQuery();
        if(results.next()) {
            System.out.println("The artist is already in the db");
            return results.getInt(1);
        } else {
            // insert artist because SQL query PreparedStatement returned null
            insertIntoArtists.setString(1, artistName);

            // check if number of rows affected match expectation of 1 row created with PreparedStatement.executeUpdate()
            int numRowsAffected = insertIntoArtists.executeUpdate();
            if(numRowsAffected != 1) {
                throw new SQLException("insertArtist() failed to insert an artist");
            } else {
                System.out.println(artistName + " was added to the db table Artists");
            }

            // on successful insert, get _id from newly created row in table
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }

    /**
     * This is the method which inserts an album into the Albums table if missing and returns the respective _id.
     *
     * SQL statement:
     *         INSERT INTO   albums(name, artistId)
     *         VALUES(?, ?);
     *
     * @param albumName The name of the album.
     * @param artistId The id of the artist.
     * @return The _id of the album.
     * @exception SQLException On SQLite3 statement error.
     */
    private int insertAlbum(String albumName, int artistId) throws SQLException {

        // PreparedStatement that replaces the ? with parameter
        queryAlbums.setString(1, albumName);

        // use query PreparedStatement to validate if data is already present
        ResultSet results = queryAlbums.executeQuery();
        if(results.next()) {
            System.out.println("The album is already in the db");
            return results.getInt(1);
        } else {
            // insert album because SQL query PreparedStatement returned null
            insertIntoAlbums.setString(1, albumName);
            insertIntoAlbums.setInt(2, artistId);

            // check if number of rows affected match expectation of 1 row created with PreparedStatement.executeUpdate()
            int numRowsAffected = insertIntoAlbums.executeUpdate();
            if(numRowsAffected != 1) {
                throw new SQLException("insertAlbum() failed to insert an album");
            } else {
                System.out.println(albumName + " added to the db table Albums");
            }

            // on successful insert, get _id from newly created row in table
            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if(generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }

    /**
     * This is the public method which inserts a song into the Songs table if missing.
     *
     * SQL statement:
     *         INSERT INTO   songs(track, title, album)
     *         VALUES(?, ?, ?);
     *
     * @param artist The id of the artist.
     * @param album The id of the album.
     * @param title The name of the album.
     * @param track The name of the album.
     * @return Nothing.
     * @exception SQLException On SQLite3 statement error.
     */
    public void insertSong(String album, String artist, String title, int track) {

        try {
            // set JDBC auto-commit to false to avoid db locks and allow for multi-statement transaction
            connection.setAutoCommit(false);

            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);

            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);

            // check if number of rows affected match expectation of 1 row created with PreparedStatement.executeUpdate()
            int numRowsAffected = insertIntoSongs.executeUpdate();
            if(numRowsAffected == 1) {
                System.out.println(title + " was added to the Songs table");
                connection.commit();
            } else {
                throw new SQLException("insertSong() failed");
            }

        } catch(Exception e) {
            System.out.println("InsertSong() exception: " + e.getMessage());
            e.printStackTrace();

            try {
                System.out.println("Performing rollback");
                connection.rollback();

            } catch(SQLException e2) {
                // catch all Exceptions, not just SQL exceptions to ensure a rollback
                System.out.println("Rollback to previous state failed: " + e.getMessage());
                e.printStackTrace();
            }

        } finally {

            try {
                System.out.println("\nReset AutoCommit back to true regardless if transaction successful or failed");
                connection.setAutoCommit(true);

            } catch (SQLException e) {
                System.out.println("Reset AutoCommit failed: " + e.getMessage());
            }
        }
    }
}
