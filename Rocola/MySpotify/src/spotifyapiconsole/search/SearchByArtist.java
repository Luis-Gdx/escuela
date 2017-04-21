/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.search;

import javax.swing.DefaultListModel;
import static myspotify.ArtistsSearch.artistList;
import static myspotify.ArtistsSearch.search;
import spotifyapiconsole.search.objects.Artist;
import spotifyapi.Spotify;

/**
 *
 * @author Luis G
 */
public class SearchByArtist implements Runnable {

    private final Spotify SPOTIFY;
    public Thread thread;
    private DefaultListModel<Artist> artistListModel;
    private final int SIZE;

    public SearchByArtist() {
        thread = new Thread(this, "Artist");
        SPOTIFY = new Spotify();
        artistListModel = new DefaultListModel();
        SIZE = 75;
    }

    public void run() {
        SPOTIFY.get(search.getText(), "artists");
        int total = SPOTIFY.getTotal();
        for (int i = 0; i < ((total > 20) ? 20 : total); i++) {
            Artist artist = new Artist();
            artist.setFollowers(SPOTIFY.getFollowers(i));
            artist.setGenres(SPOTIFY.getGenres(i));
            artist.setId(SPOTIFY.getId(i));
            artist.setImages(SPOTIFY.getImages(i, SIZE));
            artist.setName(SPOTIFY.getName(i));
            artist.setPopularity(SPOTIFY.getPopularity(i));
            artist.setType(SPOTIFY.getType(i));
            artistListModel.addElement(artist);
        }
        artistList.setModel(artistListModel);
    }
}
