/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import spotifyapiconsole.search.objects.Album;
import spotifyapiconsole.search.objects.Artist;

/**
 *
 * @author Luis G
 */
public class Spotify {

    private JsonArray json;
    private String data;
    private String type;
    private int limit = 20;

    public Spotify() {
    }

    public void get(String req, String type) {
        this.type = type;
        req = sanitize(req);
        switch (type) {
            case "albums":
                searchByAlbum(req);
                break;
            case "artists":
                searchByArtist(req);
                break;
            case "track":
                this.type += "s";
                searchByTrack(req);
                break;
        }
    }

    //Search by
    public void searchByArtist(String artist) {
        this.data = xmlHttpRequest("https://api.spotify.com/v1/search?q=" + artist + "&type=artist&limit=" + limit);
        this.json = new JsonParser().parse(data).getAsJsonObject().get("artists").getAsJsonObject().get("items").getAsJsonArray();
    }

    public void searchByAlbum(String album) {
        this.data = xmlHttpRequest("https://api.spotify.com/v1/search?q=" + album + "&type=album&limit=" + limit);
        this.json = new JsonParser().parse(data).getAsJsonObject().get("albums").getAsJsonObject().get("items").getAsJsonArray();
    }

    public void searchByTrack(String track) {
        this.data = xmlHttpRequest("https://api.spotify.com/v1/search?q=" + track + "&type=track&limit=" + limit);
        this.json = new JsonParser().parse(data).getAsJsonObject().get("tracks").getAsJsonObject().get("items").getAsJsonArray();
    }

    public int getFollowers(int i) {
        return json.get(i).getAsJsonObject().getAsJsonObject().get("followers").getAsJsonObject().get("total").getAsInt();
    }

    public Album getAlbum(int i, int size) {
        Album album = new Album();
        ArrayList<Artist> artists = new ArrayList();
        try {
            for (int j = 0; true; j++) {
                Artist artist = new Artist();
                artist.setId(json.get(i).getAsJsonObject().get("album").getAsJsonObject().get("artists").getAsJsonArray().get(j).getAsJsonObject().get("id").getAsString());
                artist.setName(json.get(i).getAsJsonObject().get("album").getAsJsonObject().get("artists").getAsJsonArray().get(j).getAsJsonObject().get("name").getAsString());
                artist.setType(json.get(i).getAsJsonObject().get("album").getAsJsonObject().get("artists").getAsJsonArray().get(j).getAsJsonObject().get("type").getAsString());
                artists.add(artist);
            }
        } catch (Exception e) {
        }
        album.setArtists(artists);
        album.setId(json.get(i).getAsJsonObject().get("album").getAsJsonObject().get("id").getAsString());
        ArrayList<ImageIcon> images = new ArrayList();
        int j = 0;
        try {
            for (j = 0; true; j++) {
                String imageUrl = json.get(i).getAsJsonObject().get("album").getAsJsonObject().get("images").getAsJsonArray().get(j).getAsJsonObject().get("url").getAsString();
                images.add(new ImageIcon((new URL(imageUrl))));
            }
        } catch (Exception e) {
            if (j == 0) {
                try {
                    images.add(new ImageIcon((new URL("https://cdn.browshot.com/static/images/not-found.png"))));
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Spotify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        images.set(0, new ImageIcon(images.get(0).getImage().getScaledInstance(size, size, java.awt.Image.SCALE_AREA_AVERAGING)));
        album.setName(json.get(i).getAsJsonObject().get("album").getAsJsonObject().get("name").getAsString());
        album.setType(json.get(i).getAsJsonObject().get("album").getAsJsonObject().get("type").getAsString());
        album.setImages(images);
        return album;
    }

    public long getDuration(int i) {
        return json.get(i).getAsJsonObject().get("duration_ms").getAsInt();
    }

    public boolean isExplicit(int i) {
        return json.get(i).getAsJsonObject().get("explicit").getAsBoolean();
    }

    public int getTrackNumber(int i) {
        return json.get(i).getAsJsonObject().get("track_number").getAsInt();
    }

    public ArrayList<String> getGenres(int i) {
        ArrayList<String> genres = new ArrayList();
        try {
            for (int j = 0; true; j++) {
                genres.add(json.get(i).getAsJsonObject().get("genres").getAsJsonArray().get(j).getAsString());
            }
        } catch (Exception e) {
        }
        return genres;
    }

    public String getAlbumType(int i) {
        return json.get(i).getAsJsonObject().get("album_type").getAsString();
    }

    public ArrayList<Artist> getArtist(int i) {
        ArrayList<Artist> artists = new ArrayList();
        try {
            for (int j = 0; true; j++) {
                Artist artist = new Artist();
                artist.setName(json.get(i).getAsJsonObject().get("artists").getAsJsonArray().get(j).getAsJsonObject().get("name").getAsString());
                artist.setType(json.get(i).getAsJsonObject().get("artists").getAsJsonArray().get(j).getAsJsonObject().get("type").getAsString());
                artists.add(artist);
            }
        } catch (Exception e) {
        }
        return artists;
    }

    public String getId(int i) {
        return json.get(i).getAsJsonObject().get("id").getAsString();
    }

    public ArrayList<ImageIcon> getImages(int i, int size) {
        ArrayList<ImageIcon> images = new ArrayList();
        int j = 0;
        try {
            for (j = 0; true; j++) {
                String imageUrl = json.get(i).getAsJsonObject().get("images").getAsJsonArray().get(j).getAsJsonObject().get("url").getAsString();
                images.add(new ImageIcon((new URL(imageUrl))));

            }
        } catch (Exception e) {
            if (j == 0) {
                try {
                    images.add(new ImageIcon((new URL("https://cdn.browshot.com/static/images/not-found.png"))));

                } catch (MalformedURLException ex) {
                    Logger.getLogger(Spotify.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        images.set(0, new ImageIcon(images.get(0).getImage().getScaledInstance(size, size, java.awt.Image.SCALE_AREA_AVERAGING)));
        return images;
    }

    public String getName(int i) {
        return json.get(i).getAsJsonObject().get("name").getAsString();
    }

    public int getPopularity(int i) {
        return json.get(i).getAsJsonObject().get("popularity").getAsInt();
    }

    public String getType(int i) {
        return json.get(i).getAsJsonObject().get("type").getAsString();
    }

    public int getLimit() {

        return new JsonParser().parse(data).getAsJsonObject().get(type).getAsJsonObject().get("limit").getAsInt();
    }

    public int getTotal() {
        return new JsonParser().parse(data).getAsJsonObject().get(type).getAsJsonObject().get("total").getAsInt();
    }

    private String sanitize(String str) {
        return str.replaceAll(" ", "%20");
    }

    private String xmlHttpRequest(String url) {
        String res = "";
        java.net.URLConnection yc;
        try {
            yc = new java.net.URL(url).openConnection();
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                res += inputLine;
            }
            in.close();

        } catch (java.io.IOException ex) {
            java.util.logging.Logger.getLogger(myspotify.ArtistsSearch.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return res;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
