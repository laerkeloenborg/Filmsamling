package domainmodel;

import java.util.Comparator;

public class ComparatorTitle implements Comparator<Movie> {
    public int compare(Movie a, Movie b){

        int result = a.getTitle().compareToIgnoreCase(b.getTitle());
        return result;



    }
}
/*
String[] arrOfA = a.getTitle().split(" ");
String [] arrOfB = b.getTitle().split(" ");

        if (arrOfA[0].compareTo(arrOfB[0]) != 0){
        return arrOfA[0].compareTo(arrOfB[0]);
        } else {
                return Integer.compare(a.getYearCreated(),b.getYearCreated());
        }*/