import java.util.ArrayList;

public class MovieCollection {
    private ArrayList<Movie> movieCollection = new ArrayList<>();

    public MovieCollection() {
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

    @Override
    public String toString() {
        int counter = 0;
        String empty = "";
        for (Movie movie : movieCollection){
            counter++;
            empty += "\n" + counter + ". " + movie.getTitle();
        }
        return empty;
    }
}
