/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.search;

import static app.Search.dataList;
import static app.Search.jScrollPane2;
import static app.Search.search;
import panels.ArtistPanel;
import panels.NotFound;
import spotifyapi.Spotify;
import spotifyapiconsole.search.objects.Artist;

/**
 *
 * @author Luis G
 */
public class SearchByArtist implements Runnable {

    private final Spotify SPOTIFY;
    public Thread thread;
    private final int SIZE;

    public SearchByArtist() {
        thread = new Thread(this, "Artist");
        SPOTIFY = new Spotify();
        SIZE = 75;
    }

    @Override
    public void run() {
        SPOTIFY.get(search.getText(), "artists");
        int total = SPOTIFY.getTotal();
        int limit = SPOTIFY.getLimit();
        for (int i = 0; i < ((total > limit) ? limit : total); i++) {
            Artist artist = new Artist();
            artist.setFollowers(SPOTIFY.getFollowers(i));
            artist.setGenres(SPOTIFY.getGenres(i));
            artist.setId(SPOTIFY.getId(i));
            artist.setImages(SPOTIFY.getImages(i, SIZE));
            artist.setName(SPOTIFY.getName(i));
            artist.setPopularity(SPOTIFY.getPopularity(i));
            artist.setType(SPOTIFY.getType(i));
            dataList.add(new ArtistPanel(artist));
        }
        if (dataList.getComponentCount() > 0) {
            jScrollPane2.setViewportView(dataList);
        } else {
            jScrollPane2.setViewportView(new NotFound("ningun artista"));
        }
    }
}
