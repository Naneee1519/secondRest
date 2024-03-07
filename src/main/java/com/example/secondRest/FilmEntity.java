package com.example.secondRest;

import jakarta.persistence.*;

@Entity
@Table(name="movie_list")
public class FilmEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Name;

    private String Price;

    private String Artist;

    private String URL;

    private String Image;

    private String Category;

    private String Releasedate;

    private String Rights;

    private String Summary;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getRights() {
        return Rights;
    }

    public void setRights(String rights) {
        Rights = rights;
    }


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getReleasedate() {
        return Releasedate;
    }

    public void setReleasedate(String releasedate) {
        Releasedate = releasedate;
    }
}
