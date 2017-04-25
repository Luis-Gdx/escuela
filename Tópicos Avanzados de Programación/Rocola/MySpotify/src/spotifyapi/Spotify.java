/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotifyapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
    private JsonObject singleJson;

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
            case "tracks":
                searchByTrack(req);
                break;
            case "track":
                searchTrack(req);
                break;
            case "artist albums":
                searchAlbum(req);
                break;
            case "tracks by album":
                searchTracksByAlbum(req);
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

    public void searchTracksByAlbum(String id) {
        this.data = xmlHttpRequest("https://api.spotify.com/v1/albums/" + id);
        this.json = new JsonParser().parse(data).getAsJsonObject().get("tracks").getAsJsonObject().get("items").getAsJsonArray();
        this.singleJson = new JsonParser().parse(data).getAsJsonObject();
    }

    public void searchAlbum(String id) {
        this.data = xmlHttpRequest("https://api.spotify.com/v1/artists/" + id + "/albums");
        this.json = new JsonParser().parse(data).getAsJsonObject().get("items").getAsJsonArray();
    }

    public void searchTrack(String id) {
        this.data = xmlHttpRequest("https://api.spotify.com/v1/tracks/" + id);
        this.singleJson = new JsonParser().parse(data).getAsJsonObject();
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

    public Album getAlbum(int size) {
        Album album = new Album();
        ArrayList<Artist> artists = new ArrayList();
        try {
            for (int j = 0; true; j++) {
                Artist artist = new Artist();
                artist.setId(singleJson.get("album").getAsJsonObject().get("artists").getAsJsonArray().get(j).getAsJsonObject().get("id").getAsString());
                artist.setName(singleJson.get("album").getAsJsonObject().get("artists").getAsJsonArray().get(j).getAsJsonObject().get("name").getAsString());
                artist.setType(singleJson.get("album").getAsJsonObject().get("artists").getAsJsonArray().get(j).getAsJsonObject().get("type").getAsString());
                artists.add(artist);
            }
        } catch (Exception e) {
        }
        album.setArtists(artists);
        album.setId(singleJson.get("album").getAsJsonObject().get("id").getAsString());
        ArrayList<ImageIcon> images = new ArrayList();
        int j = 0;
        try {
            for (j = 0; true; j++) {
                String imageUrl = singleJson.get("album").getAsJsonObject().get("images").getAsJsonArray().get(j).getAsJsonObject().get("url").getAsString();
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
        album.setName(singleJson.get("album").getAsJsonObject().get("name").getAsString());
        album.setType(singleJson.get("album").getAsJsonObject().get("type").getAsString());
        album.setImages(images);
        return album;
    }

    public Album getAlbumByArtist(int size) {
        Album album = new Album();
        ArrayList<Artist> artists = new ArrayList();
        try {
            for (int j = 0; true; j++) {
                Artist artist = new Artist();
                artist.setId(singleJson.get("artists").getAsJsonArray().get(j).getAsJsonObject().get("id").getAsString());
                artist.setName(singleJson.get("artists").getAsJsonArray().get(j).getAsJsonObject().get("name").getAsString());
                artist.setType(singleJson.get("artists").getAsJsonArray().get(j).getAsJsonObject().get("type").getAsString());
                artists.add(artist);
            }
        } catch (Exception e) {
        }
        album.setArtists(artists);
        album.setId(singleJson.get("id").getAsString());
        ArrayList<ImageIcon> images = new ArrayList();
        int j = 0;
        try {
            for (j = 0; true; j++) {
                String imageUrl = singleJson.get("images").getAsJsonArray().get(j).getAsJsonObject().get("url").getAsString();
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
        album.setName(singleJson.get("name").getAsString());
        album.setType(singleJson.get("type").getAsString());
        album.setImages(images);
        return album;
    }

    public long getDuration(int i) {
        return json.get(i).getAsJsonObject().get("duration_ms").getAsInt();
    }

    public long getDuration() {
        return singleJson.get("duration_ms").getAsInt();
    }

    public boolean isExplicit(int i) {
        return json.get(i).getAsJsonObject().get("explicit").getAsBoolean();
    }

    public boolean isExplicit() {
        return singleJson.get("explicit").getAsBoolean();
    }

    public int getTrackNumber(int i) {
        return json.get(i).getAsJsonObject().get("track_number").getAsInt();
    }

    public int getTrackNumber() {
        return singleJson.get("track_number").getAsInt();
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

    public ArrayList<String> getGenres() {
        ArrayList<String> genres = new ArrayList();
        try {
            for (int j = 0; true; j++) {
                genres.add(singleJson.get("genres").getAsJsonArray().get(j).getAsString());
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
                artist.setId(json.get(i).getAsJsonObject().get("artists").getAsJsonArray().get(j).getAsJsonObject().get("id").getAsString());
                artists.add(artist);
            }
        } catch (Exception e) {
        }
        return artists;
    }

    public ArrayList<Artist> getArtist() {
        ArrayList<Artist> artists = new ArrayList();
        try {
            for (int j = 0; true; j++) {
                Artist artist = new Artist();
                artist.setName(singleJson.get("artists").getAsJsonArray().get(j).getAsJsonObject().get("name").getAsString());
                artist.setType(singleJson.get("artists").getAsJsonArray().get(j).getAsJsonObject().get("type").getAsString());
                artists.add(artist);
            }
        } catch (Exception e) {
        }
        return artists;
    }

    public String getId(int i) {
        return json.get(i).getAsJsonObject().get("id").getAsString();
    }

    public String getId() {
        return singleJson.get("id").getAsString();
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

    public String getName() {
        return singleJson.get("name").getAsString();
    }

    public int getPopularity(int i) {
        return json.get(i).getAsJsonObject().get("popularity").getAsInt();
    }

    public int getPopularity() {
        return singleJson.get("popularity").getAsInt();
    }

    public String getPreviewUrl() {
        return singleJson.get("preview_url").getAsString();
    }

    public String getType(int i) {
        return json.get(i).getAsJsonObject().get("type").getAsString();
    }

    public String getType() {
        return singleJson.get("type").getAsString();
    }

    public int getLimit() {
        int limit = 0;
        try {
            limit = new JsonParser().parse(data).getAsJsonObject().get(type).getAsJsonObject().get("limit").getAsInt();
        } catch (Exception e) {
            limit = new JsonParser().parse(data).getAsJsonObject().get("limit").getAsInt();
        }
        return limit;
    }

    public int getTotal() {
        int limit = 0;
        try {
            limit = new JsonParser().parse(data).getAsJsonObject().get(type).getAsJsonObject().get("total").getAsInt();
        } catch (Exception e) {
            try {
                limit = new JsonParser().parse(data).getAsJsonObject().get("total").getAsInt();
            } catch (Exception ex) {

            }
        }
        return limit;
    }

    private String sanitize(String str) {
        str = str.replaceAll("[^a-zA-Z0-9' '/]", "");
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
            java.util.logging.Logger.getLogger(app.Search.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return res;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
