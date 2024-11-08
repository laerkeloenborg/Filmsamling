package main.java.domainmodel;

import java.util.Comparator;

public class ComparatorTitle implements Comparator<Movie> {
    public int compare(Movie a, Movie b){

        int result = a.getTitle().compareToIgnoreCase(b.getTitle());
        return result;



    }
}
