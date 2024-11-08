package main.java.domainmodel;

import java.util.Comparator;

public class ComparatorColor implements Comparator<Movie> {
    public int compare(Movie a, Movie b){
        int result = Boolean.compare(a.getIsInColor(),b.getIsInColor());
        return result;
    }
}
