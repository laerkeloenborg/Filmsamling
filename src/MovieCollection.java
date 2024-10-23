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

    public String searchMovie(String title) {
        for (Movie movie : movieCollection) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return "\nMovie found!\n" + "--------------------\n" + "Title: " + movie.getTitle() + "\n" + "Director: " + movie.getDirector() + "\n" + "Year: " + movie.getYearCreated() + "\n" + "In color: " + (movie.getIsInColor() ? "Yes" : "No") + "\n" + "Length: " + movie.getLengthInMinutes() + " minutes\n" + "Genre: " + movie.getGenre() + "\n" + "--------------------";
            }
        }
        return "\nNo movie found with the title: " + title;
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