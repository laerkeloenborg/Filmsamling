import java.util.Comparator;

public class ComparatorDirector implements Comparator<Movie> {
    public int compare(Movie a, Movie b){
        int result = a.getDirector().compareToIgnoreCase(b.getDirector());
        return result;
    }
}
