package com.example.waqas.testq;

/**
 * Created by Waqas on 6/21/2015.
 */
public class Constants {

    public static final String DB_NAME = "MovieQuotes";
    public static final int DB_VERSION = 1;
    public static final String DB_PATH = "/data/data/com.example.waqas.testq/databases/";
    public static final String TABLE_NAME_MOVIES = "Movies";
    public static final String  COLUMN_MOVIE = "Name";
    public static final String  COLUMN_ID = "id";
    public static final String  COLUMN_YEAR = "Year";
    public static final String  COLUMN_IMG_REF = "Img_Ref";

    public static final String TABLE_NAME_QUOTES = "Quotes";
    public static final String  COLUMN_MID = "Mid";
    public static final String  COLUMN_QUOTE = "Quote";

    int id;
    String movie;
    String year;
    String img;
    String quote;
    int mid;

    public Constants() {
    }

    public Constants(int id, String movie, String year, String img) {
        this.id = id;
        this.movie = movie;
        this.year = year;
        this.img = img;
    }

    public Constants(int id, int mid, String quote) {
        this.id = id;
        this.mid = mid;
        this.quote = quote;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}

