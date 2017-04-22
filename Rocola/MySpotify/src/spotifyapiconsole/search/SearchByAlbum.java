/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.search;

import javax.swing.DefaultListModel;
import static myspotify.Search.Search;
import static myspotify.Search.search;
import spotifyapiconsole.search.objects.Album;
import spotifyapi.Spotify;

/**
 *
 * @author Luis G
 */
public class SearchByAlbum implements Runnable {

    public Thread thread;
    private final Spotify SPOTIFY;
    private DefaultListModel<Album> albumListModel;
    private final int SIZE;

    public SearchByAlbum() {
        thread = new Thread(this, "Album");
        SPOTIFY = new Spotify();
        albumListModel = new DefaultListModel();
        SIZE = 75;
    }

    @Override
    public void run() {
        SPOTIFY.get(search.getText(), "albums");
        int total = SPOTIFY.getTotal();
        for (int i = 0; i < ((total > 20) ? 20 : total); i++) {
            Album album = new Album();
            album.setArtists(SPOTIFY.getArtist(i));
            album.setId(SPOTIFY.getId(i));
            album.setImages(SPOTIFY.getImages(i, SIZE));
            album.setName(SPOTIFY.getName(i));
            album.setType(SPOTIFY.getAlbumType(i));
            albumListModel.addElement(album);
        }
        albumList.setModel(albumListModel);
    }

}
