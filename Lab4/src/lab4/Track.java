/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author Vo Chi Trong - CE191062
 */
public class Track extends Media {

    private String title;
    private String artist;
    private String category;

    public Track() {
    }

    public Track(String title, String artist, String category, String id, int size) {
        super(id, size);
        this.title = title;
        this.artist = artist;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    String entryData() {
        return String.format("New track %s: %s (%s) by %s added!\n", getId(), getTitle(), getCategory(), getArtist());

    }

    @Override
    String printData() {
        return String.format("Mucsic track %s: %s (%s) by %s\n", getId(), getTitle(), getCategory(), getArtist());

    }
}
