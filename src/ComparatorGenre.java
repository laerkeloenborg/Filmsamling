import java.util.Comparator;

public class ComparatorGenre implements Comparator<Movie> {
    public int compare(Movie a, Movie b){
        int result = a.getGenre().compareToIgnoreCase(b.getGenre());
        return result;
    }
}
