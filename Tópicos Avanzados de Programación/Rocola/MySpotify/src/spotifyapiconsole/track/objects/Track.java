/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapiconsole.track.objects;

import java.util.ArrayList;
import spotifyapiconsole.search.objects.Album;
import spotifyapiconsole.search.objects.Artist;

/**
 *
 * @author Luis G
 */
public class Track {

    private Album album;
    private ArrayList<Artist> artist;
    private boolean explicit;
    private String id;
    private String name;
    private int popularity;
    private String previewUrl;
    private int trackNumber;
    private String type;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public ArrayList<Artist> getArtist() {
        return artist;
    }

    public void setArtist(ArrayList<Artist> artist) {
        this.artist = artist;
    }

    public boolean isExplicit() {
        return explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
