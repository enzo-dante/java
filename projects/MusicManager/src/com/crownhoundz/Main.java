package com.crownhoundz;

import model.Artist;
import model.DataSource;
import model.SongArtist;

import java.util.List;

/**
 * <h1>MusicManager!</h1>
 * The MusicManager! program implements an application that
 * demonstrates how Java can interface with a SQL database
 * <p>
 *
 * @author  Enzo Vernon
 * @version 1.0
 * @since   2021-10-30
 */

public class Main {

    /**
     * This is the main method which makes use of DataSource class.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
        // create instance of DataSource class
        DataSource datasource = new DataSource();

        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        // get all artists
        List<Artist> artists = datasource.queryArtists(DataSource.ORDER_BY_ASC);
        if(artists == null) {
            System.out.println("Where have all the artists gone?");
            return;
        }

        // for each Artist object (named artist) in the artists list
        for(Artist artist : artists) {
            System.out.println("_id = " + artist.get_id() + ", " + "name = " + artist.getName());
        }

        System.out.println("---");

        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Carole King", DataSource.ORDER_BY_DESC);

        // for each albums.name in the albums list
        for(String albumName : albumsForArtist) {
            System.out.println("album name: " + albumName);
        }

        System.out.println("---");

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", DataSource.ORDER_BY_DESC);
        // for each songArtist object in the songArtists list
        for(SongArtist songArtist : songArtists) {
            System.out.println(
                    "\nartist: " + songArtist.getArtistName() +
                    "\nalbum name: " + songArtist.getAlbumName() +
                    "\nsong track: " + songArtist.getTrack());
        }

        System.out.println("---");

        datasource.querySongsMetadata();

        System.out.println("---");

        int count = datasource.getCount(DataSource.TABLE_SONGS);
        System.out.println("Songs count: " + count);

        datasource.close();
    }
}
