package domainmodel;

import java.util.Comparator;

public class ComparatorYear implements Comparator<Movie> {
    public int compare(Movie a, Movie b){
        int result = Integer.compare(a.getYearCreated(),b.getYearCreated());
        return result;
    }
}
