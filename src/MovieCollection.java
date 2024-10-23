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

    public String searchMovies(String title) {
        ArrayList<Movie> matchingMovies = new ArrayList<>();

        for (Movie movie : movieCollection) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchingMovies.add(movie);
            }
        }

        String result = "";

        for (Movie movie : matchingMovies) {
            result += "Title: " + movie.getTitle() + "\n";
            result += "Director: " + movie.getDirector() + "\n";
            result += "Year: " + movie.getYearCreated() + "\n";
            result += "In color: " + (movie.getIsInColor() ? "Yes" : "No") + "\n";
            result += "Length: " + movie.getLengthInMinutes() + " minutes\n";
            result += "Genre: " + movie.getGenre() + "\n\n";
        }

        return result;
    }

    @Override
    public String toString() {
        int counter = 0;
        String empty = "";
        for (Movie movie : movieCollection) {
            counter++;
            empty += "\n" + counter + ". " + movie.getTitle();
        }
        return empty;
    }
}