package main.java.domainmodel;

import java.util.Comparator;

public class ComparatorLength implements Comparator<Movie> {
    public int compare(Movie a, Movie b){
        int result = Integer.compare(a.getLengthInMinutes(),b.getLengthInMinutes());
        return result;
    }
}
