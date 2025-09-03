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
public class Movie extends Media {

    private String title;
    private String director;
    private int releaseYear;

    public Movie() {
    }

    public Movie(String title, String director, int releaseYear, String id, int size) {
        super(id, size);
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    String entryData() {
        return "New movie " + getId() + ": " + getTitle() + " (" + getReleaseYear() + ") by " + getDirector() + " added!\n";
    }

    @Override
    String printData() {
        return String.format("Movie %s: %s (%d) by %s\n", getId(), getTitle(), getReleaseYear(), getDirector());
    }

}
