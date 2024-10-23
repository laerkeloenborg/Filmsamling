import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movieCollection = new ArrayList<>();

    public MovieCollection(ArrayList<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    public ArrayList<Movie> getMovieCollection() {
        return movieCollection;
    }

    public void setMovieCollection(ArrayList<Movie> movieCollection) {
        this.movieCollection = movieCollection;
    }

    public void addMovie(Movie movie) {
        movieCollection.add(movie);
    }

    public Movie searchMovie(String title) {
        String noMovies = "There is no movies on your list with the title";
        for (Movie movieCollection : movieCollection) {
            if (movieCollection.getTitle().equalsIgnoreCase(title)) {
                return movieCollection;
            }
        }

        return null;
    }
}
