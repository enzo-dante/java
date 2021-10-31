package com.crownhoundz;

import model.Artist;
import model.DataSource;

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
        List<Artist> artists = datasource.queryArtists();
        if(artists == null) {
            System.out.println("Where have all the artists gone?");
            return;
        }

        // for each Artist object (named artist) in the artists list
        for(Artist artist : artists) {
            System.out.println("_id = " + artist.get_id() + ", " + "name = " + artist.getName());
        }

        datasource.close();
    }
}
