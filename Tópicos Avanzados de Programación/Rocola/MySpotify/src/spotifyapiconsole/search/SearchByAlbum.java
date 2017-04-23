/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.search;

import static app.Search.dataList;
import static app.Search.jScrollPane2;
import static app.Search.search;
import panels.AlbumPanel;
import panels.NotFound;
import spotifyapi.Spotify;
import spotifyapiconsole.search.objects.Album;

/**
 *
 * @author Luis G
 */
public class SearchByAlbum implements Runnable {

    public Thread thread;
    private final Spotify SPOTIFY;
    private final int SIZE;

    public SearchByAlbum() {
        thread = new Thread(this, "Album");
        SPOTIFY = new Spotify();
        SIZE = 75;
    }

    @Override
    public void run() {
        SPOTIFY.get(search.getText(), "albums");
        int total = SPOTIFY.getTotal();
        int limit = SPOTIFY.getLimit();
        for (int i = 0; i < ((total > limit) ? limit : total); i++) {
            Album album = new Album();
            album.setArtists(SPOTIFY.getArtist(i));
            album.setId(SPOTIFY.getId(i));
            album.setImages(SPOTIFY.getImages(i, SIZE));
            album.setName(SPOTIFY.getName(i));
            album.setType(SPOTIFY.getAlbumType(i));
            dataList.add(new AlbumPanel(album));
        }
        if (dataList.getComponentCount() > 0) {
            jScrollPane2.setViewportView(dataList);
        } else {
            jScrollPane2.setViewportView(new NotFound("ningun artista"));
        }
    }
}
